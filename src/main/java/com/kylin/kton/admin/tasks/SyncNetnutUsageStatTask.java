/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.netnut.entity.subuser.TrafficUsageData
 *  com.kylin.kton.api.netnut.entity.subuser.TrafficUsageRequest
 *  com.kylin.kton.api.netnut.entity.subuser.TrafficUsageResponse
 *  com.kylin.kton.api.netnut.service.NetnutSubUserApiService
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat
 *  com.kylin.kton.system.domain.KtonSource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.account.constant.AccountStatus;
import com.kylin.kton.admin.account.constant.ChannelCode;
import com.kylin.kton.admin.account.service.IpDynamicsAccountService;
import com.kylin.kton.admin.account.service.IpDynamicsAccountUsageStatService;
import com.kylin.kton.admin.tasks.mapper.DynamicsAccountUsageStatTaskMapper;
import com.kylin.kton.admin.tasks.mapper.TasksSourceDao;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageData;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageResponse;
import com.kylin.kton.api.netnut.service.NetnutSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import com.kylin.kton.system.domain.KtonSource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncNetnutUsageStatTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncNetnutUsageStatTask.class);
    private final IpDynamicsAccountService ipDynamicsAccountService;
    private final NetnutSubUserApiService netnutSubUserApiService;
    private final DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper;
    private final IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService;
    private final TasksSourceDao tasksSourceDao;

    public void syncUsageStat() {
        log.info("start sync netnut sub user account usage stat...");
        List<KtonIpDynamicsAccount> dynamicsAccounts = this.listSubAccount();
        if (CollectionUtils.isEmpty(dynamicsAccounts)) {
            log.info("netnut dynamics account is empty....");
            return;
        }
        dynamicsAccounts.forEach(this::doSyncUsageStat);
        log.info("finished sync netnut sub user account usage stat...");
    }

    public void doSyncUsageStat(KtonIpDynamicsAccount dynamicsAccount) {
        try {
            TrafficUsageData currentUsage;
            TrafficUsageRequest trafficUsageRequest = new TrafficUsageRequest();
            trafficUsageRequest.setBySubUser(true);
            ArrayList<String> subUserIds = new ArrayList<String>();
            subUserIds.add(dynamicsAccount.getAccountId().toString());
            trafficUsageRequest.setSubUsers(subUserIds);
            trafficUsageRequest.setPackageType(Integer.valueOf(1));
            trafficUsageRequest.setPlanStatus(Integer.valueOf(1));
            TrafficUsageResponse trafficUsageResponse = this.netnutSubUserApiService.getTrafficUsage(trafficUsageRequest);
            if (Objects.isNull(trafficUsageResponse) || trafficUsageResponse.isEmpty().booleanValue()) {
                log.info("the netnut usage stat of account = {} is empty", (Object)dynamicsAccount.getAccountId());
                return;
            }
            KtonIpDynamicsAccountUsageStat latestUsageStat = this.dynamicsAccountUsageStatTaskMapper.getLatestUsageStat(dynamicsAccount.getMerchantId(), dynamicsAccount.getAccountId());
            if (Objects.isNull(latestUsageStat)) {
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertNetnutUsage(trafficUsageResponse.getData(), dynamicsAccount);
                log.info("sync netnut sub user account usage stat total = {}", (Object)total);
                return;
            }
            List<TrafficUsageData> usagesNotExists = trafficUsageResponse.getData().stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return item.getUsageD().isAfter(dateTime);
            }).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(usagesNotExists)) {
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertNetnutUsage(usagesNotExists, dynamicsAccount);
                log.info("sync netnut sub user account usage stat total = {}", (Object)total);
            }
            if (Objects.nonNull(currentUsage = (TrafficUsageData)trafficUsageResponse.getData().stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return item.getStartDate().equals(dateTime);
            }).findFirst().orElse(null))) {
                latestUsageStat.setRequests(Long.valueOf(currentUsage.getRequest()));
                latestUsageStat.setTraffic(currentUsage.getTraffic());
                this.ipDynamicsAccountUsageStatService.updateKtonIpDynamicsAccountUsageStat(latestUsageStat);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
    }

    private List<KtonIpDynamicsAccount> listSubAccount() {
        KtonIpDynamicsAccount dynamicsAccount = new KtonIpDynamicsAccount();
        dynamicsAccount.setStatus(AccountStatus.ACTIVE.getCode());
        dynamicsAccount.setSourceId(this.getSourceIdBySourceCode(ChannelCode.NNETNUT.getCode()));
        return this.ipDynamicsAccountService.selectKtonIpDynamicsAccountList(dynamicsAccount);
    }

    private Long getSourceIdBySourceCode(String sourceCode) {
        KtonSource source = this.tasksSourceDao.detailBySourceCode(sourceCode);
        Long sourceId = source.getId();
        return sourceId;
    }

    @Generated
    public SyncNetnutUsageStatTask(IpDynamicsAccountService ipDynamicsAccountService, NetnutSubUserApiService netnutSubUserApiService, DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper, IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService, TasksSourceDao tasksSourceDao) {
        this.ipDynamicsAccountService = ipDynamicsAccountService;
        this.netnutSubUserApiService = netnutSubUserApiService;
        this.dynamicsAccountUsageStatTaskMapper = dynamicsAccountUsageStatTaskMapper;
        this.ipDynamicsAccountUsageStatService = ipDynamicsAccountUsageStatService;
        this.tasksSourceDao = tasksSourceDao;
    }
}

