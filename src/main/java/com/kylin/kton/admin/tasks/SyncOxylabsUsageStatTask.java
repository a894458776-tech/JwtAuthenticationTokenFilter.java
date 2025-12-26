/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.netnut.entity.subuser.CustomerPlansRequest
 *  com.kylin.kton.api.oxylabs.entity.subuser.DateResItem
 *  com.kylin.kton.api.oxylabs.entity.subuser.SubUserTrafficStatsResponse
 *  com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService
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
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansRequest;
import com.kylin.kton.api.oxylabs.entity.subuser.DateResItem;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserTrafficStatsResponse;
import com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import com.kylin.kton.system.domain.KtonSource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncOxylabsUsageStatTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncOxylabsUsageStatTask.class);
    private final IpDynamicsAccountService ipDynamicsAccountService;
    private final OxylabsSubUserApiService oxylabsSubUserApiService;
    private final DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper;
    private final IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService;
    private final TasksSourceDao tasksSourceDao;

    public void syncUsageStat() {
        log.info("start sync oxylabs sub user account usage stat...");
        List<KtonIpDynamicsAccount> dynamicsAccounts = this.listSubAccount();
        if (CollectionUtils.isEmpty(dynamicsAccounts)) {
            log.info("oxylabs dynamics account is empty....");
            return;
        }
        dynamicsAccounts.forEach(this::doSyncUsageStat);
        log.info("finished sync oxylabs sub user account usage stat...");
    }

    public void doSyncUsageStat(KtonIpDynamicsAccount dynamicsAccount) {
        try {
            List<DateResItem> dataList;
            DateResItem dateResItem;
            CustomerPlansRequest customerPlansRequest = new CustomerPlansRequest();
            Integer subUserId = dynamicsAccount.getAccountId().intValue();
            String type = "24h";
            SubUserTrafficStatsResponse subUserTrafficStatsResponse = this.oxylabsSubUserApiService.getSubUserTrafficStats(subUserId, type);
            if (Objects.isNull(subUserTrafficStatsResponse) || subUserTrafficStatsResponse.isEmpty().booleanValue()) {
                log.info("the oxylabs usage stat of account = {} is empty", (Object)dynamicsAccount.getAccountId());
                return;
            }
            KtonIpDynamicsAccountUsageStat latestUsageStat = this.dynamicsAccountUsageStatTaskMapper.getLatestUsageStat(dynamicsAccount.getMerchantId(), dynamicsAccount.getAccountId());
            if (Objects.isNull(latestUsageStat)) {
                List<DateResItem> dataList2 = this.convertToDtoList(subUserTrafficStatsResponse.getTrafficByPeriod());
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertOxylabsUsage(dataList2, dynamicsAccount);
                log.info("sync oxylabs sub user account usage stat total = {}", (Object)total);
                return;
            }
            List<DateResItem> usagesNotExists = this.convertToDtoList(subUserTrafficStatsResponse.getTrafficByPeriod());
            usagesNotExists.stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String dateString = item.getDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate date = LocalDate.parse(dateString, formatter);
                    return date.isAfter(dateTime);
                }
                catch (DateTimeParseException e) {
                    return false;
                }
            }).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(usagesNotExists)) {
                int total = this.dynamicsAccountUsageStatTaskMapper.batchInsertOxylabsUsage(usagesNotExists, dynamicsAccount);
                log.info("sync oxylabs sub user account usage stat total = {}", (Object)total);
            }
            if (Objects.nonNull(dateResItem = (DateResItem)(dataList = this.convertToDtoList(subUserTrafficStatsResponse.getTrafficByPeriod())).stream().filter(item -> {
                LocalDate dateTime = latestUsageStat.getdUsage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date = this.strDateToLocatDate(item.getDate());
                return date.equals(dateTime);
            }).findFirst().orElse(null))) {
                latestUsageStat.setTraffic(Double.valueOf(dateResItem.getValue()));
                this.ipDynamicsAccountUsageStatService.updateKtonIpDynamicsAccountUsageStat(latestUsageStat);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
    }

    private LocalDate strDateToLocatDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            return date;
        }
        catch (DateTimeParseException e) {
            return null;
        }
    }

    private List<KtonIpDynamicsAccount> listSubAccount() {
        KtonIpDynamicsAccount dynamicsAccount = new KtonIpDynamicsAccount();
        dynamicsAccount.setStatus(AccountStatus.ACTIVE.getCode());
        dynamicsAccount.setSourceId(this.getSourceIdBySourceCode(ChannelCode.OXYLABS.getCode()));
        return this.ipDynamicsAccountService.selectKtonIpDynamicsAccountList(dynamicsAccount);
    }

    public List<DateResItem> convertToDtoList(Map<String, Double> trafficByPeriod) {
        ArrayList<DateResItem> list = new ArrayList<DateResItem>();
        for (Map.Entry<String, Double> entry : trafficByPeriod.entrySet()) {
            String date = entry.getKey();
            double value = entry.getValue();
            list.add(new DateResItem(date, value));
        }
        return list;
    }

    private Long getSourceIdBySourceCode(String sourceCode) {
        KtonSource source = this.tasksSourceDao.detailBySourceCode(sourceCode);
        Long sourceId = source.getId();
        return sourceId;
    }

    @Generated
    public SyncOxylabsUsageStatTask(IpDynamicsAccountService ipDynamicsAccountService, OxylabsSubUserApiService oxylabsSubUserApiService, DynamicsAccountUsageStatTaskMapper dynamicsAccountUsageStatTaskMapper, IpDynamicsAccountUsageStatService ipDynamicsAccountUsageStatService, TasksSourceDao tasksSourceDao) {
        this.ipDynamicsAccountService = ipDynamicsAccountService;
        this.oxylabsSubUserApiService = oxylabsSubUserApiService;
        this.dynamicsAccountUsageStatTaskMapper = dynamicsAccountUsageStatTaskMapper;
        this.ipDynamicsAccountUsageStatService = ipDynamicsAccountUsageStatService;
        this.tasksSourceDao = tasksSourceDao;
    }
}

