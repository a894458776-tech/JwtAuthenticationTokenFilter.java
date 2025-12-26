/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.OrderProductNameConstants$PRODUCT_TYPE
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.exception.CustomServiceException
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  com.kylin.kton.system.mapper.KtonOrderMapper
 *  com.kylin.kton.system.service.impl.KtonIpStaticPoolItemServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolMerchantDTO;
import com.kylin.kton.client.ip.entity.vo.IpStaticPoolItemSearchVO;
import com.kylin.kton.client.ip.entity.vo.ReNewIpListVO;
import com.kylin.kton.client.ip.mapper.ClientStaticConfigPlanDao;
import com.kylin.kton.client.ip.mapper.ClientStaticMerchantDao;
import com.kylin.kton.client.ip.mapper.ClientStaticPoolDao;
import com.kylin.kton.client.ip.mapper.ClientStaticPoolItemDao;
import com.kylin.kton.client.ip.service.ClientIpStaticPoolItemService;
import com.kylin.kton.client.order.entity.vo.ClientMerchantIpsByOrderNoGetVO;
import com.kylin.kton.client.order.mapper.ClientOrderDao;
import com.kylin.kton.client.order.mapper.ClientOrderItemDao;
import com.kylin.kton.client.order.service.impl.ClientOrderServiceImpl;
import com.kylin.kton.common.constant.OrderProductNameConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import com.kylin.kton.system.service.impl.KtonIpStaticPoolItemServiceImpl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientIpStaticPoolItemServiceImpl
extends KtonIpStaticPoolItemServiceImpl
implements ClientIpStaticPoolItemService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpStaticPoolItemServiceImpl.class);
    @Autowired
    private ClientStaticPoolItemDao clientStaticPoolItemDao;
    @Autowired
    private ClientOrderServiceImpl clientOrderService;
    @Autowired
    private ClientStaticConfigPlanDao clientStaticConfigPlanDao;
    @Autowired
    private KtonOrderMapper ktonOrderMapper;
    @Autowired
    private ClientOrderItemDao clientOrderItemDao;
    @Autowired
    private ClientStaticMerchantDao clientStaticMerchantDao;
    @Autowired
    ClientOrderDao clientOrderDao;
    @Autowired
    ClientStaticPoolDao clientStaticPoolDao;

    @Override
    public List<ClientIpStaticPoolMerchantDTO> merchantIpList(IpStaticPoolItemSearchVO searchVO) {
        return this.clientStaticPoolItemDao.merchantIpList(searchVO);
    }

    @Override
    @Transactional
    public AjaxResult renewIpList(ReNewIpListVO reNewIpListVO, Long merchantId) {
        reNewIpListVO.getIpList().forEach(ip -> {
            Integer res = this.clientStaticMerchantDao.checkIsExists(merchantId, (String)ip);
            if (res <= 0) {
                log.info("\u65e0\u6548\u7684IP: " + ip);
                throw new CustomServiceException("Invalid IP: " + ip + ", this IP does not belong to the merchant");
            }
        });
        reNewIpListVO.getIpList().forEach(ip -> {
            Integer res = this.clientStaticMerchantDao.checkIsExpire((String)ip);
            if (res <= 0) {
                log.info("\u5df2\u8fc7\u671f\u7684IP: " + ip);
                throw new CustomServiceException("IP: " + ip + " has expired and been removed, cannot be renewed. Please contact the administrator");
            }
        });
        log.info("addStatic \u8ba2\u5355\u5165\u53c2 = {}", (Object)reNewIpListVO);
        KtonOrder ktonOrder = new KtonOrder();
        ktonOrder.setMerchantId(merchantId);
        ktonOrder.setOrderNo(this.clientOrderService.getOrderNoByTime());
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_STATIC.getAlias());
        ktonOrder.setProductType(Long.valueOf(2L));
        ktonOrder.setQuantity(Long.valueOf(reNewIpListVO.getIpList().size()));
        ktonOrder.setTotalIps(Long.valueOf(reNewIpListVO.getIpList().size()));
        BigDecimal totalAmount = this.calculateStaticTotal(reNewIpListVO.getIpList(), merchantId, reNewIpListVO.getMonthCount(), 0L);
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setPayMethod("BALANCE");
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setCreateTime(new Date());
        this.ktonOrderMapper.insertKtonOrder(ktonOrder);
        List<KtonOrderItemStatic> orderItems = this.getOrderItems(reNewIpListVO.getIpList(), merchantId, reNewIpListVO.getMonthCount(), ktonOrder.getId());
        log.info("addStatic orderItems = {}", orderItems);
        if (orderItems.size() > 0) {
            this.clientOrderItemDao.saveBatch(orderItems);
        }
        this.clientOrderService.sendWeComMessage(merchantId, ktonOrder);
        return AjaxResult.success((String)"\u4e0b\u5355\u6210\u529f", (Object)ktonOrder.getOrderNo());
    }

    @Override
    public AjaxResult getMerchantIpsByOrderNo(ClientMerchantIpsByOrderNoGetVO merchantIpsByOrderNoGetVO) {
        List<ClientIpStaticPoolMerchantDTO> staticPoolItemDTOS = this.clientOrderDao.getMerchantIpsByOrderNo(merchantIpsByOrderNoGetVO.getOrderNo(), merchantIpsByOrderNoGetVO.getMerchantId());
        return AjaxResult.success(staticPoolItemDTOS);
    }

    private List<KtonOrderItemStatic> getOrderItems(List<String> ipList, Long merchantId, Long monthCount, Long orderId) {
        List<KtonOrderItemStatic> list = this.clientStaticMerchantDao.getListByIpList(ipList, merchantId);
        List<KtonOrderItemStatic> resultList = list.stream().collect(Collectors.toMap(KtonOrderItemStatic::getIp, Function.identity(), (i1, i2) -> {
            if (i1.getExpireDatetime().compareTo(i2.getExpireDatetime()) >= 0) {
                return i1;
            }
            return i2;
        })).entrySet().stream().map(item -> {
            KtonOrderItemStatic orderItemStatic = (KtonOrderItemStatic)item.getValue();
            orderItemStatic.setId(null);
            orderItemStatic.setOrderId(orderId);
            orderItemStatic.setStatus("Y");
            orderItemStatic.setEffectiveDatetime(orderItemStatic.getExpireDatetime());
            orderItemStatic.setExpireDatetime(this.clientOrderService.getRenewExpireDatetimeAddStartTime(orderItemStatic.getExpireDatetime(), String.valueOf(monthCount)));
            return orderItemStatic;
        }).collect(Collectors.toList());
        return resultList;
    }

    private BigDecimal calculateStaticTotal(List<String> ips, Long merchantId, Long monthCount, Long isExclusive) {
        if (monthCount <= 0L) {
            return BigDecimal.ZERO;
        }
        return ips.stream().map(ip -> {
            KtonIpStaticPool staticPool = this.clientStaticPoolDao.getByIp((String)ip, merchantId);
            if (staticPool == null) {
                throw new CustomServiceException("IP: " + ip + " is not on sale or has expired.");
            }
            return this.getConfigPrice(merchantId, staticPool.getCountryCode(), staticPool.getType().intValue(), isExclusive);
        }).reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(monthCount));
    }

    private BigDecimal getConfigPrice(Long merchantId, String countryCode, Integer ipType, Long isExclusive) {
        KtonIpStaticConfigPlan config = this.clientStaticConfigPlanDao.getByCountryCode(merchantId, countryCode, ipType, isExclusive);
        if (config == null) {
            config = this.clientStaticConfigPlanDao.getByCountryCode(0L, countryCode, ipType, isExclusive);
        }
        if (config == null) {
            String ipTypeStr = "\u672a\u77e5IP\u7c7b\u578b";
            if (ipType == 0) {
                ipTypeStr = "\u5e7f\u64adIP";
            } else if (ipType == 1) {
                ipTypeStr = "\u539f\u751fIP";
            }
            throw new CustomServiceException("Country code: " + countryCode + ", IP type: " + ipType + ", no configuration price found. Please check if there is a corresponding record for this country code and IP type in the configuration table.");
        }
        return config.getPrice();
    }
}

