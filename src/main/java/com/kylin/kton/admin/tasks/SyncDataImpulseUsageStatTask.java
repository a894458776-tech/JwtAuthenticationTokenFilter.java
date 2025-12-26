/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.constant.PeriodType
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse$Usage
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
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
import com.kylin.kton.api.dataimpulse.constant.PeriodType;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import com.kylin.kton.system.domain.KtonSource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncDataImpulseUsageStatTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDataImpulseUsageStatTask.class);
    private final IpDynamicsAccountService ipDynamicsAccountService;
    private final DataImpulseSubUserApiService dataimpulseSubUserApiService;
    private final DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper;
    private final IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService;
    private final TasksSourceDao tasksSourceDao;

    public void syncUsageStat() {
        log.info("start sync sub user account usage stat...");
        List<KtonIpDynamicsAccount> dynamicsAccounts = this.listSubAccount();
        if (CollectionUtils.isEmpty(dynamicsAccounts)) {
            log.info("dynamics account is empty....");
            return;
        }
        dynamicsAccounts.forEach(this::doSyncUsageStat);
        log.info("finished sync sub user account usage stat...");
    }

    public void doSyncUsageStat(KtonIpDynamicsAccount dynamicsAccount) {
        try {
            QuerySubUserUsageStatResponse.Usage currentUsage;
            QuerySubUserUsageStatResponse usageStatResponse = this.dataimpulseSubUserApiService.queryUsageStat(dynamicsAccount.getAccountId(), PeriodType.WEEK);
            if (Objects.isNull(usageStatResponse) || usageStatResponse.isEmpty().booleanValue()) {
                log.info("the usage stat of account = {} is empty", (Object)dynamicsAccount.getAccountId());
                return;
            }
            KtonIpDynamicsAccountUsageStat latestUsageStat = this.dynamicsAccountUsageStatTaskMapper.getLatestUsageStat(dynamicsAccount.getMerchantId(), dynamicsAccount.getAccountId());
            if (Objects.isNull(latestUsageStat)) {
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertUsage(usageStatResponse.getUsage(), dynamicsAccount);
                log.info("sync sub user account usage stat total = {}", (Object)total);
                return;
            }
            List<QuerySubUserUsageStatResponse.Usage> usagesNotExists = usageStatResponse.getUsage().stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return item.getUsageD().isAfter(dateTime);
            }).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(usagesNotExists)) {
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertUsage(usagesNotExists, dynamicsAccount);
                log.info("sync sub user account usage stat total = {}", (Object)total);
            }
            if (Objects.nonNull(currentUsage = (QuerySubUserUsageStatResponse.Usage)usageStatResponse.getUsage().stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return item.getUsageD().equals(dateTime);
            }).findFirst().orElse(null))) {
                latestUsageStat.setRequests(currentUsage.getRequest());
                latestUsageStat.setTraffic(currentUsage.getTraffic());
                latestUsageStat.setExtraTraffic(currentUsage.getExtraTraffic());
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
        dynamicsAccount.setSourceId(this.getSourceIdBySourceCode(ChannelCode.DATAIMPULSE.getCode()));
        return this.ipDynamicsAccountService.selectKtonIpDynamicsAccountList(dynamicsAccount);
    }

    private Long getSourceIdBySourceCode(String sourceCode) {
        KtonSource source = this.tasksSourceDao.detailBySourceCode(sourceCode);
        Long sourceId = source.getId();
        return sourceId;
    }

    @Generated
    public SyncDataImpulseUsageStatTask(IpDynamicsAccountService ipDynamicsAccountService, DataImpulseSubUserApiService dataimpulseSubUserApiService, DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper, IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService, TasksSourceDao tasksSourceDao) {
        this.ipDynamicsAccountService = ipDynamicsAccountService;
        this.dataimpulseSubUserApiService = dataimpulseSubUserApiService;
        this.dynamicsAccountUsageStatTaskMapper = dynamicsAccountUsageStatTaskMapper;
        this.ipDynamicsAccountUsageStatService = ipDynamicsAccountUsageStatService;
        this.tasksSourceDao = tasksSourceDao;
    }
}

