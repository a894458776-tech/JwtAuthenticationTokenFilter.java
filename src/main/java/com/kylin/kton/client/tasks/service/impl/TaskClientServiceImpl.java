package com.kylin.kton.client.tasks.service.impl;

import com.kylin.kton.client.order.entity.dto.ClientStaticPoolItemDTO;
import com.kylin.kton.client.tasks.mapper.TaskClientOrderDao;
import com.kylin.kton.client.tasks.mapper.TaskIpStaticPoolItemDao;
import com.kylin.kton.client.tasks.service.TaskClientService;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper;
import com.kylin.kton.system.mapper.KtonMerchantSummaryMapper;
import com.kylin.kton.system.mapper.KtonOrderItemStaticMapper;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskClientServiceImpl implements TaskClientService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(TaskClientServiceImpl.class);
    @Resource
    TaskClientOrderDao taskClientOrderDao;
    @Autowired
    KtonOrderItemStaticMapper ktonOrderItemStaticMapper;
    @Autowired
    KtonIpStaticPoolItemMapper ktonIpStaticPoolItemMapper;
    @Resource
    KtonMerchantSummaryMapper ktonMerchantSummaryMapper;
    @Autowired
    TaskIpStaticPoolItemDao taskIpStaticPoolItemDao;

    @Override
    public void autoOverdueOrder() {
        List<KtonOrder> cancelOrderList = this.taskClientOrderDao.pendingCancelOrderList();
        if (cancelOrderList.size() > 0) {
            log.info("autoOverdueOrder size 共计" + cancelOrderList.size());
            for (KtonOrder ktonOrder : cancelOrderList) {
                ktonOrder.setStatus(0L);
                ktonOrder.setPaidStatus(0L);
                ktonOrder.setUpdateTime(new Date());
                this.taskClientOrderDao.updateKtonOrder(ktonOrder);
                this.restoreIpPoolStatus(ktonOrder.getId());
            }
        }
    }

    private void restoreIpPoolStatus(Long orderId) {
        KtonOrderItemStatic entity = new KtonOrderItemStatic();
        entity.setOrderId(orderId);
        // 修复：添加泛型
        List<KtonOrderItemStatic> itemStatics = this.ktonOrderItemStaticMapper.selectKtonOrderItemStaticList(entity);
        log.info("restoreIpPoolStatus itemStatics size 共计" + itemStatics.size());
        if (itemStatics.size() > 0) {
            for (KtonOrderItemStatic ktonOrderItemStatic : itemStatics) {
                this.resetIpPoolStatus(ktonOrderItemStatic.getIp(), ktonOrderItemStatic.getPort());
            }
        }
    }

    private void resetIpPoolStatus(String ip, String port) {
        // 修复：原代码试图将DTO强转为Entity，这里改为创建Entity对象
        KtonIpStaticPoolItem entity = new KtonIpStaticPoolItem();
        entity.setIp(ip);
        // 如果需要port，也应该设置 entity.setPort(port); 

        // 修复：添加泛型
        List<KtonIpStaticPoolItem> items = this.ktonIpStaticPoolItemMapper.selectKtonIpStaticPoolItemList(entity);
        if (items.size() > 0) {
            List<String> ips = items.stream().map(KtonIpStaticPoolItem::getIp).collect(Collectors.toList());
            this.taskIpStaticPoolItemDao.batchEdit(0, ips);
        }
    }
}