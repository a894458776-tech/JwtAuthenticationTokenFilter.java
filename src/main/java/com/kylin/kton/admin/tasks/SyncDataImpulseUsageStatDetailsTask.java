/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.constant.PeriodType
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse$Usage
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
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
import com.kylin.kton.admin.tasks.mapper.DynamicsAccountUsageDetailsTaskMapper;
import com.kylin.kton.admin.tasks.mapper.TasksSourceDao;
import com.kylin.kton.api.dataimpulse.constant.PeriodType;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import com.kylin.kton.system.domain.KtonSource;
import java.time.LocalDateTime;
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
public class SyncDataImpulseUsageStatDetailsTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDataImpulseUsageStatDetailsTask.class);
    private final IpDynamicsAccountService ipDynamicsAccountService;
    private final DataImpulseSubUserApiService dataimpulseSubUserApiService;
    private final DynamicsAccountUsageDetailsTaskMapper accountUsageDetailsTaskMapper;
    private final TasksSourceDao tasksSourceDao;

    public void syncUsageStat() {
        log.info("start sync sub user account usage stat details...");
        List<KtonIpDynamicsAccount> dynamicsAccounts = this.listSubAccount();
        if (CollectionUtils.isEmpty(dynamicsAccounts)) {
            log.info("dynamics account is empty....");
            return;
        }
        dynamicsAccounts.forEach(dynamicsAccount -> {
            KtonIpDynamicsAccountUsageDetails latestUsageDetails = this.accountUsageDetailsTaskMapper.getLatestUsageDetails(dynamicsAccount.getMerchantId(), dynamicsAccount.getAccountId());
            this.doSyncUsageStatDetails((KtonIpDynamicsAccount)dynamicsAccount, latestUsageDetails, 1);
        });
        log.info("finished sync sub user account usage stat details...");
    }

    public void doSyncUsageStatDetails(KtonIpDynamicsAccount dynamicsAccount, KtonIpDynamicsAccountUsageDetails latestUsageDetails, Integer pageNo) {
        try {
            QuerySubUserUsageStatDetailsResponse usageStatDtlResponse = this.dataimpulseSubUserApiService.queryUsageStatDetails(dynamicsAccount.getAccountId(), PeriodType.DAY, pageNo, Integer.valueOf(50));
            if (Objects.isNull(usageStatDtlResponse) || usageStatDtlResponse.isEmpty().booleanValue()) {
                log.info("the usage stat details of account = {}, page no = {} is empty", (Object)dynamicsAccount.getAccountId(), (Object)pageNo);
                return;
            }
            if (Objects.isNull(latestUsageDetails)) {
                int total = this.accountUsageDetailsTaskMapper.batchInsertUsageDetails(usageStatDtlResponse.getUsage(), dynamicsAccount);
                log.info("sync sub user account usage stat details total = {}", (Object)total);
                this.doSyncUsageStatDetails(dynamicsAccount, latestUsageDetails, pageNo + 1);
            } else {
                List<QuerySubUserUsageStatDetailsResponse.Usage> usages = usageStatDtlResponse.getUsage().stream().filter(usage -> {
                    LocalDateTime dateTime = LocalDateTime.ofInstant(latestUsageDetails.getDataDatetime().toInstant(), ZoneId.systemDefault());
                    return usage.getDatetime().isAfter(dateTime);
                }).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(usages)) {
                    int total = this.accountUsageDetailsTaskMapper.batchInsertUsageDetails(usages, dynamicsAccount);
                    log.info("sync sub user account usage stat details total = {}", (Object)total);
                    this.doSyncUsageStatDetails(dynamicsAccount, latestUsageDetails, pageNo + 1);
                }
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
    public SyncDataImpulseUsageStatDetailsTask(IpDynamicsAccountService ipDynamicsAccountService, DataImpulseSubUserApiService dataimpulseSubUserApiService, DynamicsAccountUsageDetailsTaskMapper accountUsageDetailsTaskMapper, TasksSourceDao tasksSourceDao) {
        this.ipDynamicsAccountService = ipDynamicsAccountService;
        this.dataimpulseSubUserApiService = dataimpulseSubUserApiService;
        this.accountUsageDetailsTaskMapper = accountUsageDetailsTaskMapper;
        this.tasksSourceDao = tasksSourceDao;
    }
}

