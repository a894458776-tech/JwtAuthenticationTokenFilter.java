/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserBalanceResponse
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
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
import com.kylin.kton.admin.account.service.IpDynamicsAccountBalanceService;
import com.kylin.kton.admin.account.service.IpDynamicsAccountService;
import com.kylin.kton.admin.tasks.mapper.TasksSourceDao;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.domain.KtonSource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncDataImpulseBalanceTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDataImpulseBalanceTask.class);
    private final IpDynamicsAccountService ipDynamicsAccountService;
    private final DataImpulseSubUserApiService dataimpulseSubUserApiService;
    private final IpDynamicsAccountBalanceService dynamicsAccountBalanceService;
    private final TasksSourceDao tasksSourceDao;

    public void syncSubUserBalance() {
        log.info("start sync sub user account balance...");
        List<KtonIpDynamicsAccount> dynamicsAccounts = this.listSubAccount();
        if (CollectionUtils.isEmpty(dynamicsAccounts)) {
            log.info("dynamics account is empty....");
            return;
        }
        dynamicsAccounts.forEach(this::doSyncSubAccountBalance);
        log.info("finished sync sub user account balance...");
    }

    private void doSyncSubAccountBalance(KtonIpDynamicsAccount dynamicsAccount) {
        try {
            QuerySubUserBalanceResponse balanceResponse = this.dataimpulseSubUserApiService.queryBalance(dynamicsAccount.getAccountId());
            if (Objects.isNull(balanceResponse)) {
                return;
            }
            KtonIpDynamicsAccountBalance accountBalance = new KtonIpDynamicsAccountBalance();
            accountBalance.setAccountId(dynamicsAccount.getAccountId());
            accountBalance.setMerchantId(dynamicsAccount.getMerchantId());
            List accountBalances = this.dynamicsAccountBalanceService.selectKtonIpDynamicsAccountBalanceList(accountBalance);
            if (CollectionUtils.isEmpty((Collection)accountBalances)) {
                this.covert(accountBalance, balanceResponse);
                this.dynamicsAccountBalanceService.insertKtonIpDynamicsAccountBalance(accountBalance);
            } else {
                accountBalance = (KtonIpDynamicsAccountBalance)accountBalances.get(0);
                this.covert(accountBalance, balanceResponse);
                this.dynamicsAccountBalanceService.updateKtonIpDynamicsAccountBalance(accountBalance);
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

    private void covert(KtonIpDynamicsAccountBalance accountBalance, QuerySubUserBalanceResponse balanceResponse) {
        accountBalance.setBalance(balanceResponse.getBalance());
        accountBalance.setBalanceFormat(balanceResponse.getBalanceFormat());
        accountBalance.setBalanceTotal(balanceResponse.getBalanceTotal());
        accountBalance.setBalanceTotalFormat(balanceResponse.getBalanceTotalFormat());
        accountBalance.setBalanceUsed(balanceResponse.getBalanceUsed());
        accountBalance.setBalanceUsedFormat(balanceResponse.getBalanceUsedFormat());
        accountBalance.setThreadsUsed(balanceResponse.getThreadsUsed());
    }

    @Generated
    public SyncDataImpulseBalanceTask(IpDynamicsAccountService ipDynamicsAccountService, DataImpulseSubUserApiService dataimpulseSubUserApiService, IpDynamicsAccountBalanceService dynamicsAccountBalanceService, TasksSourceDao tasksSourceDao) {
        this.ipDynamicsAccountService = ipDynamicsAccountService;
        this.dataimpulseSubUserApiService = dataimpulseSubUserApiService;
        this.dynamicsAccountBalanceService = dynamicsAccountBalanceService;
        this.tasksSourceDao = tasksSourceDao;
    }
}

