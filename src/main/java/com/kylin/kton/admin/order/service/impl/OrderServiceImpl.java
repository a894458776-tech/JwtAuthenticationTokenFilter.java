/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.OrderIpStaticConstants$STATUS
 *  com.kylin.kton.common.constant.OrderProductNameConstants$PRODUCT_TYPE
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  com.kylin.kton.system.domain.KtonMerchantWallet
 *  com.kylin.kton.system.domain.KtonMerchantWalletItem
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  com.kylin.kton.system.mapper.KtonMerchantWalletItemMapper
 *  com.kylin.kton.system.mapper.KtonMerchantWalletMapper
 *  com.kylin.kton.system.mapper.KtonOrderItemStaticMapper
 *  com.kylin.kton.system.mapper.KtonOrderMapper
 *  com.kylin.kton.system.service.impl.KtonOrderServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.kylin.kton.admin.order.service.impl;

import com.kylin.kton.admin.ip.mapper.AdminIpStaticMerchantDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolItemDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticSourceDao;
import com.kylin.kton.admin.ip.mapper.AdminStaticConfigPlanDao;
import com.kylin.kton.admin.ip.mapper.AdminStaticUnsubscribeDao;
import com.kylin.kton.admin.ip.mapper.IpStaticPoolSourceDao;
import com.kylin.kton.admin.order.entity.dto.AdminOrderDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderDetailDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderItemStaticDTO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderSearchVO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderStaticAddVO;
import com.kylin.kton.admin.order.entity.vo.AdminProcessIpReplacementVO;
import com.kylin.kton.admin.order.entity.vo.AdminReNewIpListVO;
import com.kylin.kton.admin.order.entity.vo.AdminUnsubscribeStaticIpVO;
import com.kylin.kton.admin.order.entity.vo.AdminUnsubscribeStaticStrIpsVO;
import com.kylin.kton.admin.order.mapper.AdminOrderDao;
import com.kylin.kton.admin.order.mapper.AdminOrderItemStaticDao;
import com.kylin.kton.admin.order.service.OrderService;
import com.kylin.kton.common.constant.OrderIpStaticConstants;
import com.kylin.kton.common.constant.OrderProductNameConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.domain.KtonMerchantWallet;
import com.kylin.kton.system.domain.KtonMerchantWalletItem;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonMerchantWalletItemMapper;
import com.kylin.kton.system.mapper.KtonMerchantWalletMapper;
import com.kylin.kton.system.mapper.KtonOrderItemStaticMapper;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import com.kylin.kton.system.service.impl.KtonOrderServiceImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl
extends KtonOrderServiceImpl
implements OrderService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final AdminOrderDao adminOrderDao;
    private final AdminStaticConfigPlanDao staticConfigPlanDao;
    private final AdminIpStaticPoolDao adminIpStaticPoolDao;
    private final AdminOrderItemStaticDao adminOrderItemStaticDao;
    private final KtonOrderItemStaticMapper ktonOrderItemStaticMapper;
    private final AdminIpStaticSourceDao adminIpStaticSourceDao;
    private final AdminIpStaticMerchantDao adminIpStaticMerchantDao;
    private final AdminIpStaticPoolItemDao adminIpStaticPoolItemDao;
    private final KtonMerchantWalletMapper ktonMerchantWalletMapper;
    private final KtonMerchantWalletItemMapper ktonMerchantWalletItemMapper;
    private final AdminStaticUnsubscribeDao adminStaticUnsubscribeDao;
    private final IpStaticPoolSourceDao ipStaticPoolSourceDao;
    private final KtonOrderMapper ktonOrderMapper;
    private static final String ORDER_PREFIX = "N";
    private static final int RANDOM_NUMBER_LENGTH = 5;
    private static final int DAYS_IN_MONTH = 30;

    @Override
    public List<AdminOrderDTO> list(AdminOrderSearchVO searchVO) {
        return this.adminOrderDao.list(searchVO);
    }

    @Override
    public AdminOrderDetailDTO detail(Long orderId) {
        return this.adminOrderDao.detail(orderId);
    }

    @Override
    public List<AdminOrderItemStaticDTO> expireList() {
        return this.adminOrderDao.expireList();
    }

    @Override
    @Transactional
    public String addStatic(AdminOrderStaticAddVO addVO) {
        this.validateAddStaticRequest(addVO);
        addVO.getIps().forEach(ip -> {
            Integer res = this.adminIpStaticPoolItemDao.checkIsExists(addVO.getMerchantId(), (String)ip);
            if (res <= 0) {
                log.info("\u65e0\u6548\u7684IP: " + ip);
                throw new IllegalArgumentException("\u65e0\u6548\u7684IP: " + ip + ",\u8be5IP\u4e0d\u5c5e\u4e8e\u8be5\u5546\u6237\u7684IP\u6c60");
            }
        });
        AtomicInteger existsNum = new AtomicInteger(0);
        ArrayList existingIps = new ArrayList();
        addVO.getIps().forEach(ip -> {
            Integer res = this.adminIpStaticMerchantDao.checkIsExists(addVO.getMerchantId(), (String)ip);
            if (res > 0) {
                log.info("IP\u5df2\u5b58\u5728\u5728\u8be5\u5546\u6237\u7684\u8d2d\u4e70\u5217\u8868: " + ip);
                existsNum.incrementAndGet();
                existingIps.add(ip);
            }
        });
        if (existsNum.get() > 0) {
            throw new IllegalArgumentException("\u4ee5\u4e0bIP\u5df2\u5b58\u5728\uff0c\u4e0d\u80fd\u91cd\u590d\u8d2d\u4e70: " + String.join((CharSequence)",", existingIps));
        }
        BigDecimal totalAmount = this.calculateStaticTotal(addVO.getIps(), addVO.getMerchantId(), addVO.getDays(), addVO.getIsExclusive());
        this.deductMerchantBalance(addVO.getMerchantId(), totalAmount);
        KtonOrder ktonOrder = this.createOrder(addVO.getIps(), addVO.getMerchantId(), this.calculateExpireDate(addVO.getDays()), totalAmount);
        this.processOrderItems(addVO.getIps(), addVO.getDays(), ktonOrder, addVO.getIsExclusive());
        return ktonOrder.getOrderNo();
    }

    @Override
    @Transactional(rollbackFor={Exception.class})
    public Boolean unsubscribeStaticStrIps(AdminUnsubscribeStaticStrIpsVO staticStrIpsVO) {
        List<String> ipList = new ArrayList<String>();
        if (staticStrIpsVO.getIpList() != null) {
            ipList = Arrays.asList(staticStrIpsVO.getIpList().split(","));
        }
        this.doUnsubscribeStaticStrIps(ipList, staticStrIpsVO.getMerchantId());
        return true;
    }

    public Boolean doUnsubscribeStaticStrIps(List<String> ipList, Long merchantId) {
        AdminUnsubscribeStaticIpVO unsubscribeStaticIpVO = new AdminUnsubscribeStaticIpVO();
        unsubscribeStaticIpVO.setMerchantId(merchantId);
        unsubscribeStaticIpVO.setIpList(ipList);
        this.adminStaticUnsubscribeDao.saveUnsubscribeBatch(unsubscribeStaticIpVO);
        List<String> strList = unsubscribeStaticIpVO.getIpList();
        for (String ip : strList) {
            KtonIpStaticMerchant staticMerchant = this.adminIpStaticMerchantDao.selectByIpAndMerchantId(ip, unsubscribeStaticIpVO.getMerchantId());
            if (staticMerchant == null || staticMerchant.getStatus() == 3L) continue;
            KtonOrderItemStatic itemStatic = this.adminOrderItemStaticDao.selectByIp(ip, unsubscribeStaticIpVO.getMerchantId(), staticMerchant.getLastOrderId());
            if (itemStatic != null) {
                itemStatic.setStatus(OrderIpStaticConstants.STATUS.T.name());
                itemStatic.setUnsubscribeTime(new Date());
                this.ktonOrderItemStaticMapper.updateKtonOrderItemStatic(itemStatic);
            }
            this.releaseIp(staticMerchant, staticMerchant.getLastPoolId());
        }
        return true;
    }

    private void releaseIp(KtonIpStaticMerchant staticMerchant, Long pooId) {
        this.adminIpStaticMerchantDao.refund(staticMerchant.getId());
        this.ipStaticPoolSourceDao.subtAssignTimes(staticMerchant.getIp());
        this.adminIpStaticSourceDao.updateExclusiveStatus(staticMerchant.getIp(), 0L);
    }

    private void validateAddStaticRequest(AdminOrderStaticAddVO addVO) {
        if (addVO == null || addVO.getIps() == null || addVO.getIps().isEmpty()) {
            throw new IllegalArgumentException("\u65e0\u6548\u7684\u8ba2\u5355\u8bf7\u6c42: IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a");
        }
    }

    private void deductMerchantBalance(Long merchantId, BigDecimal totalAmount) {
        KtonMerchantWallet assets = this.ktonMerchantWalletMapper.selectKtonMerchantWalletByMerchantId(merchantId);
        if (assets == null || assets.getBalance().compareTo(totalAmount) < 0) {
            throw new IllegalStateException("\u5546\u6237\u4f59\u989d\u4e0d\u8db3");
        }
        BigDecimal newBalance = assets.getBalance().subtract(totalAmount);
        BigDecimal newTotalAmount = assets.getTotalAmount().add(totalAmount);
        assets.setBalance(newBalance);
        assets.setTotalAmount(newTotalAmount);
        assets.setUpdateTime(new Date());
        this.ktonMerchantWalletMapper.updateKtonMerchantWallet(assets);
        this.createWalletDeductionRecord(merchantId, totalAmount);
    }

    private void createWalletDeductionRecord(Long merchantId, BigDecimal amount) {
        KtonMerchantWalletItem assetsHistory = new KtonMerchantWalletItem();
        assetsHistory.setType(Long.valueOf(2L));
        assetsHistory.setAmount(amount);
        assetsHistory.setMerchantId(merchantId);
        this.ktonMerchantWalletItemMapper.insertKtonMerchantWalletItem(assetsHistory);
    }

    private KtonOrder createOrder(List<String> ips, Long merchantId, Date expireDatetime, BigDecimal totalAmount) {
        KtonOrder ktonOrder = new KtonOrder();
        ktonOrder.setMerchantId(merchantId);
        ktonOrder.setOrderNo(this.generateOrderNumber());
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_STATIC.getAlias());
        ktonOrder.setProductType(Long.valueOf(2L));
        ktonOrder.setQuantity(Long.valueOf(ips.size()));
        ktonOrder.setTotalIps(Long.valueOf(ips.size()));
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setPayMethod("BALANCE");
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setExpireDatetime(expireDatetime);
        ktonOrder.setCreateTime(new Date());
        this.ktonOrderMapper.insertKtonOrder(ktonOrder);
        return ktonOrder;
    }

    private void processOrderItems(List<String> ips, Object timeParam, KtonOrder order, Long isExclusive) {
        List<KtonOrderItemStatic> orderItems = this.createOrderItems(ips, timeParam, order, isExclusive);
        if (!orderItems.isEmpty()) {
            this.adminOrderItemStaticDao.saveBatch(orderItems);
            this.updateOrderStatus(order);
        }
    }

    private List<KtonOrderItemStatic> createOrderItems(List<String> ips, Object timeParam, KtonOrder order, Long isExclusive) {
        return ips.stream().map(ip -> {
            if (timeParam instanceof Long) {
                return this.createOrderItem((String)ip, (Long)timeParam, order, isExclusive);
            }
            if (timeParam instanceof Date) {
                return this.createOrderItem((String)ip, (Date)timeParam, order, isExclusive);
            }
            throw new IllegalArgumentException("\u65f6\u95f4\u53c2\u6570\u7c7b\u578b\u9519\u8bef");
        }).collect(Collectors.toList());
    }

    private KtonOrderItemStatic createOrderItem(String ip, Long days, KtonOrder order, Long isExclusive) {
        KtonIpStaticPool staticPool = this.adminIpStaticPoolDao.getByIp(ip, order.getMerchantId());
        if (staticPool == null) {
            throw new IllegalArgumentException(ip + "\u672a\u4e0a\u67b6\uff0c\u6216\u5df2\u8fc7\u671f");
        }
        BigDecimal price = this.getConfigPrice(order.getMerchantId(), staticPool.getCountryCode(), staticPool.getType().intValue(), isExclusive);
        KtonOrderItemStatic orderItem = new KtonOrderItemStatic();
        orderItem.setOrderType(staticPool.getType());
        orderItem.setOrderId(order.getId());
        orderItem.setPoolId(staticPool.getId());
        orderItem.setPrice(price);
        orderItem.setDays(days);
        orderItem.setContinent(staticPool.getContinent());
        orderItem.setCountryCode(staticPool.getCountryCode());
        orderItem.setLocation(staticPool.getLocation());
        orderItem.setEffectiveDatetime(new Date());
        orderItem.setExpireDatetime(this.calculateExpireDate(days));
        orderItem.setStatus("Y");
        KtonIpStaticSource poolItem = this.adminIpStaticSourceDao.selectByIp(ip);
        orderItem.setIp(poolItem.getIp());
        orderItem.setPort(poolItem.getPort());
        orderItem.setAccount(poolItem.getAccount());
        orderItem.setPassword(poolItem.getPassword());
        orderItem.setProtocolse(poolItem.getProtocolse());
        this.consumingIp(order, orderItem, days, isExclusive);
        return orderItem;
    }

    private KtonOrderItemStatic createOrderItem(String ip, Date expireDatetime, KtonOrder order, Long isExclusive) {
        Long days = this.getDaysUntil(expireDatetime);
        KtonIpStaticPool staticPool = this.adminIpStaticPoolDao.getByIp(ip, order.getMerchantId());
        if (staticPool == null) {
            throw new IllegalArgumentException(ip + "\u672a\u4e0a\u67b6\u3002\u6216\u5df2\u8fc7\u671f\uff01");
        }
        BigDecimal price = this.getConfigPrice(order.getMerchantId(), staticPool.getCountryCode(), staticPool.getType().intValue(), isExclusive);
        KtonOrderItemStatic orderItem = new KtonOrderItemStatic();
        orderItem.setOrderType(staticPool.getType());
        orderItem.setOrderId(order.getId());
        orderItem.setPoolId(staticPool.getId());
        orderItem.setPrice(price);
        orderItem.setDays(days);
        orderItem.setContinent(staticPool.getContinent());
        orderItem.setCountryCode(staticPool.getCountryCode());
        orderItem.setLocation(staticPool.getLocation());
        orderItem.setEffectiveDatetime(new Date());
        orderItem.setExpireDatetime(expireDatetime);
        orderItem.setStatus("Y");
        KtonIpStaticSource poolItem = this.adminIpStaticSourceDao.selectByIp(ip);
        orderItem.setIp(poolItem.getIp());
        orderItem.setPort(poolItem.getPort());
        orderItem.setAccount(poolItem.getAccount());
        orderItem.setPassword(poolItem.getPassword());
        orderItem.setProtocolse(poolItem.getProtocolse());
        this.consumingIp(order, orderItem, days, isExclusive);
        return orderItem;
    }

    private void consumingIp(KtonOrder order, KtonOrderItemStatic poolItem, Long days, Long isExclusive) {
        KtonIpStaticMerchant staticMerchant = this.adminIpStaticMerchantDao.selectByIpAndMerchantId(poolItem.getIp(), order.getMerchantId());
        if (staticMerchant != null) {
            staticMerchant.setLastPoolId(poolItem.getPoolId());
            staticMerchant.setLastOrderId(order.getId());
            staticMerchant.setExpireDatetime(this.getStaticExpireDatetimeAddStartTime(staticMerchant.getExpireDatetime(), days));
            staticMerchant.setSubscribeDatetime(new Date());
            staticMerchant.setUpdateTime(new Date());
            this.adminIpStaticMerchantDao.updateKtonIpStaticMerchant(staticMerchant);
        } else {
            KtonIpStaticMerchant ktonIpStaticMerchant = new KtonIpStaticMerchant();
            ktonIpStaticMerchant.setLastOrderId(order.getId());
            ktonIpStaticMerchant.setLastPoolId(poolItem.getPoolId());
            ktonIpStaticMerchant.setIp(poolItem.getIp());
            ktonIpStaticMerchant.setPort(poolItem.getPort());
            ktonIpStaticMerchant.setProtocolse(poolItem.getProtocolse());
            ktonIpStaticMerchant.setStatus(Long.valueOf(1L));
            ktonIpStaticMerchant.setEffectiveDatetime(new Date());
            ktonIpStaticMerchant.setExpireDatetime(order.getExpireDatetime());
            ktonIpStaticMerchant.setSubscribeDatetime(new Date());
            ktonIpStaticMerchant.setLastOrderId(order.getId());
            ktonIpStaticMerchant.setMerchantId(order.getMerchantId());
            ktonIpStaticMerchant.setCreateTime(new Date());
            this.adminIpStaticMerchantDao.insertKtonIpStaticMerchant(ktonIpStaticMerchant);
        }
        this.adminIpStaticSourceDao.incrementAssignTimes(poolItem.getIp());
        if (isExclusive == 1L) {
            this.adminIpStaticSourceDao.updateExclusiveStatus(poolItem.getIp(), 1L);
        }
    }

    public long getDaysUntil(Date endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("\u7ed3\u675f\u65e5\u671f\u4e0d\u80fd\u4e3anull");
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(currentDate, endLocalDate);
    }

    private void updateIpPoolItemStatus(KtonOrderItemStatic orderItem) {
        this.adminIpStaticPoolItemDao.updateByPoolIdAndIp(orderItem.getPoolId(), orderItem.getIp(), 1);
    }

    private void updateOrCreateMerchantIpRecord(KtonOrder order, KtonOrderItemStatic orderItem, Long days) {
        KtonIpStaticMerchant staticMerchant = this.adminIpStaticMerchantDao.selectByIpAndMerchantId(orderItem.getIp(), order.getMerchantId());
        if (staticMerchant != null) {
            this.updateExistingMerchantIp(staticMerchant, order, orderItem, days);
        } else {
            this.createNewMerchantIp(order, orderItem);
        }
    }

    private void updateExistingMerchantIp(KtonIpStaticMerchant staticMerchant, KtonOrder order, KtonOrderItemStatic orderItem, Long days) {
        staticMerchant.setLastPoolId(orderItem.getPoolId());
        staticMerchant.setLastOrderId(order.getId());
        staticMerchant.setExpireDatetime(this.calculateExpireDateFrom(staticMerchant.getExpireDatetime(), days));
        staticMerchant.setUpdateTime(new Date());
        this.adminIpStaticMerchantDao.updateKtonIpStaticMerchant(staticMerchant);
    }

    private void createNewMerchantIp(KtonOrder order, KtonOrderItemStatic orderItem) {
        KtonIpStaticMerchant merchantIp = new KtonIpStaticMerchant();
        merchantIp.setLastOrderId(order.getId());
        merchantIp.setLastPoolId(orderItem.getPoolId());
        merchantIp.setIp(orderItem.getIp());
        merchantIp.setPort(orderItem.getPort());
        merchantIp.setProtocolse(orderItem.getProtocolse());
        merchantIp.setStatus(Long.valueOf(1L));
        merchantIp.setEffectiveDatetime(new Date());
        merchantIp.setExpireDatetime(order.getExpireDatetime());
        merchantIp.setMerchantId(order.getMerchantId());
        merchantIp.setCreateTime(new Date());
        this.adminIpStaticMerchantDao.insertKtonIpStaticMerchant(merchantIp);
    }

    private void updateIpSourceStatus(KtonOrderItemStatic orderItem) {
        this.adminIpStaticSourceDao.incrementAssignTimes(orderItem.getIp());
    }

    private void updateOrderStatus(KtonOrder order) {
        order.setPaidStatus(Long.valueOf(20L));
        order.setUpdateTime(new Date());
        this.ktonOrderMapper.updateKtonOrder(order);
    }

    private BigDecimal calculateStaticTotal(List<String> ips, Long merchantId, Long days, Long isExclusive) {
        if (days <= 0L) {
            return BigDecimal.ZERO;
        }
        BigDecimal monthCount = this.calculateMonths(days);
        return ips.stream().map(ip -> {
            KtonIpStaticPool staticPool = this.adminIpStaticPoolDao.getByIp((String)ip, merchantId);
            if (staticPool == null) {
                throw new IllegalArgumentException(ip + "\u672a\u4e0a\u67b6\u3002\u6216\u5df2\u8fc7\u671f\uff01");
            }
            return this.getConfigPrice(merchantId, staticPool.getCountryCode(), staticPool.getType().intValue(), isExclusive);
        }).reduce(BigDecimal.ZERO, BigDecimal::add).multiply(monthCount);
    }

    public BigDecimal calculateMonths(Long days) {
        if (days <= 0L) {
            throw new IllegalArgumentException("\u7eed\u8d39\u5929\u6570\u5fc5\u987b\u5927\u4e8e0");
        }
        BigDecimal daysBD = BigDecimal.valueOf(days);
        BigDecimal monthDays = BigDecimal.valueOf(30L);
        return daysBD.divide(monthDays, 0, RoundingMode.CEILING);
    }

    private BigDecimal getConfigPrice(Long merchantId, String countryCode, Integer ipType, Long isExclusive) {
        KtonIpStaticConfigPlan config = this.staticConfigPlanDao.getByCountryCode(merchantId, countryCode, ipType, isExclusive);
        if (config == null) {
            config = this.staticConfigPlanDao.getByCountryCode(0L, countryCode, ipType, isExclusive);
        }
        if (config == null) {
            String ipTypeStr = "\u672a\u77e5IP\u7c7b\u578b";
            if (ipType == 0) {
                ipTypeStr = "\u5e7f\u64adIP";
            } else if (ipType == 1) {
                ipTypeStr = "\u539f\u751fIP";
            }
            throw new IllegalArgumentException("\u56fd\u5bb6\u4ee3\u7801\uff1a" + countryCode + "\uff0cIP\u7c7b\u578b\uff1a" + ipTypeStr + "\uff0c\u627e\u4e0d\u5230\u914d\u7f6e\u4ef7\u683c\uff0c\u8bf7\u68c0\u67e5\u914d\u7f6e\u8868\u662f\u5426\u6709\u8be5\u56fd\u5bb6\u4ee3\u7801\u548cIP\u7c7b\u578b\u5bf9\u5e94\u7684\u8bb0\u5f55\u3002");
        }
        return config.getPrice();
    }

    public Date getStaticExpireDatetimeAddStartTime(Date startDate, Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(5, Math.toIntExact(days));
        return calendar.getTime();
    }

    private String generateOrderNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        String randomDigits = new Random().ints(5L, 0, 10).mapToObj(String::valueOf).collect(Collectors.joining());
        return ORDER_PREFIX + timestamp + randomDigits;
    }

    private Date calculateExpireDate(Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, days.intValue());
        return calendar.getTime();
    }

    private Date calculateExpireDateFrom(Date startDate, Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(5, days.intValue());
        return calendar.getTime();
    }

    @Override
    @Transactional
    public AjaxResult renewIpList(AdminReNewIpListVO reNewIpListVO) {
        reNewIpListVO.getIpList().forEach(ip -> {
            Integer res = this.adminIpStaticMerchantDao.checkIsExists(reNewIpListVO.getMerchantId(), (String)ip);
            if (res <= 0) {
                log.info("\u65e0\u6548\u7684IP: " + ip);
                throw new IllegalArgumentException("\u65e0\u6548\u7684IP: " + ip + ",\u8be5IP\u4e0d\u5c5e\u4e8e\u8be5\u5546\u6237");
            }
        });
        reNewIpListVO.getIpList().forEach(ip -> {
            Integer res = this.adminIpStaticMerchantDao.checkIsExpire((String)ip);
            if (res <= 0) {
                log.info("\u5df2\u8fc7\u671f\u7684IP: " + ip);
                throw new IllegalArgumentException("IP\uff1a " + ip + "\u5df2\u8fc7\u671f\u4e0b\u67b6\uff0c\u65e0\u6cd5\u7eed\u8d39");
            }
        });
        Long mechantId = reNewIpListVO.getMerchantId();
        BigDecimal totalAmount = this.calculateStaticTotal(reNewIpListVO.getIpList(), mechantId, reNewIpListVO.getMonthCount(), 0L);
        this.deductMerchantBalance(mechantId, totalAmount);
        KtonOrder ktonOrder = this.createOrder(reNewIpListVO);
        List<KtonOrderItemStatic> orderItems = this.processOrderItems(reNewIpListVO, ktonOrder);
        this.renewOrder(orderItems, mechantId);
        return AjaxResult.success((String)"\u7eed\u8d39\u6210\u529f", (Object)ktonOrder.getOrderNo());
    }

    @Override
    @Transactional
    public AjaxResult processIpReplacement(AdminProcessIpReplacementVO processIpReplacementVO) {
        this.doUnsubscribeStaticStrIps(processIpReplacementVO.getOldIpList(), processIpReplacementVO.getMerchantId());
        Date expireDatetime = this.getExpireDatetime(processIpReplacementVO.getOldIpList(), processIpReplacementVO.getMerchantId());
        String orderNo = this.createProcessIpReplacementOrder(processIpReplacementVO.getNewIpList(), processIpReplacementVO.getMerchantId(), expireDatetime, processIpReplacementVO.getIsExclusive());
        return AjaxResult.success((String)"\u66f4\u6362IP\u6210\u529f", (Object)orderNo);
    }

    private String createProcessIpReplacementOrder(List<String> ips, Long merchantId, Date expireDatetime, Long isExclusive) {
        ips.forEach(ip -> {
            Integer res = this.adminIpStaticPoolItemDao.checkIsExists(merchantId, (String)ip);
            if (res <= 0) {
                log.info("\u65e0\u6548\u7684IP: " + ip);
                throw new IllegalArgumentException("\u65e0\u6548\u7684IP: " + ip + ",\u8be5IP\u4e0d\u5c5e\u4e8e\u8be5\u5546\u6237\u7684IP\u6c60");
            }
        });
        AtomicInteger existsNum = new AtomicInteger(0);
        ArrayList existingIps = new ArrayList();
        ips.forEach(ip -> {
            Integer res = this.adminIpStaticMerchantDao.checkIsExists(merchantId, (String)ip);
            if (res > 0) {
                log.info("IP\u5df2\u5b58\u5728\u5728\u8be5\u5546\u6237\u7684\u8d2d\u4e70\u5217\u8868: " + ip);
                existsNum.incrementAndGet();
                existingIps.add(ip);
            }
        });
        if (existsNum.get() > 0) {
            throw new IllegalArgumentException("\u4ee5\u4e0bIP\u5df2\u5b58\u5728\uff0c\u4e0d\u80fd\u91cd\u590d\u8d2d\u4e70: " + String.join((CharSequence)",", existingIps));
        }
        BigDecimal totalAmount = new BigDecimal(0);
        KtonOrder ktonOrder = this.createOrder(ips, merchantId, expireDatetime, totalAmount);
        this.processOrderItems(ips, expireDatetime, ktonOrder, isExclusive);
        return ktonOrder.getOrderNo();
    }

    private Date getExpireDatetime(List<String> ips, Long merchantId) {
        long diffInDays = 0L;
        KtonIpStaticMerchant merchant = this.adminIpStaticMerchantDao.selectByIpAndMerchantId(ips.get(0), merchantId);
        Date expireDatetime = null;
        if (merchant == null || merchant.getExpireDatetime() == null) {
            throw new IllegalArgumentException("IP\uff1a" + ips.get(0) + "\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u7eed\u8d39");
        }
        expireDatetime = merchant.getExpireDatetime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expireDatetime);
        Date currentDate = new Date();
        diffInDays = (calendar.getTimeInMillis() - currentDate.getTime()) / 86400000L;
        if (diffInDays <= 0L) {
            throw new IllegalArgumentException("IP\uff1a" + ips.get(0) + "\u5df2\u7ecf\u8fc7\u671f\uff0c\u65e0\u6cd5\u7eed\u8d39");
        }
        return expireDatetime;
    }

    private List<KtonOrderItemStatic> processOrderItems(AdminReNewIpListVO reNewIpListVO, KtonOrder order) {
        List<KtonOrderItemStatic> orderItems = this.getOrderItems(reNewIpListVO.getIpList(), order.getMerchantId(), reNewIpListVO.getMonthCount(), order.getId());
        if (!orderItems.isEmpty()) {
            this.adminOrderItemStaticDao.saveBatch(orderItems);
            this.updateOrderStatus(order);
        }
        return orderItems;
    }

    private KtonOrder createOrder(AdminReNewIpListVO reNewIpListVO) {
        Long merchantId = reNewIpListVO.getMerchantId();
        log.info("addStatic \u8ba2\u5355\u5165\u53c2 = {}", (Object)reNewIpListVO);
        KtonOrder ktonOrder = new KtonOrder();
        ktonOrder.setMerchantId(merchantId);
        ktonOrder.setOrderNo(this.getOrderNoByTime());
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_STATIC.getAlias());
        ktonOrder.setProductType(Long.valueOf(2L));
        ktonOrder.setQuantity(Long.valueOf(reNewIpListVO.getIpList().size()));
        ktonOrder.setTotalIps(Long.valueOf(reNewIpListVO.getIpList().size()));
        BigDecimal totalAmount = this.calTotalAmount(reNewIpListVO.getIpList(), merchantId, reNewIpListVO.getMonthCount());
        if (totalAmount == null) {
            throw new IllegalArgumentException("\u627e\u4e0d\u5230IP\uff1a" + reNewIpListVO.getIpList() + "\u7684IP\u6c60\u4ef7\u683c\u914d\u7f6e\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6709\u8be5IP\u662f\u5426\u4e0a\u67b6\u3002");
        }
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setPayMethod("BALANCE");
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setCreateTime(new Date());
        this.ktonOrderMapper.insertKtonOrder(ktonOrder);
        return ktonOrder;
    }

    private void renewOrder(List<KtonOrderItemStatic> orderItems, Long merchantId) {
        if (orderItems.size() > 0) {
            for (KtonOrderItemStatic orderItem : orderItems) {
                if (orderItem.getIp() == null) continue;
                Date subscribeDatetime = new Date();
                this.adminIpStaticMerchantDao.updateExpireDate(orderItem.getOrderId(), orderItem.getExpireDatetime(), subscribeDatetime, orderItem.getIp(), merchantId);
            }
        }
    }

    private List<KtonOrderItemStatic> getOrderItems(List<String> ipList, Long merchantId, Long monthCount, Long orderId) {
        List<KtonOrderItemStatic> list = this.adminIpStaticMerchantDao.getListByIpList(ipList, merchantId);
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
            orderItemStatic.setExpireDatetime(this.getRenewExpireDatetimeAddStartTime(orderItemStatic.getExpireDatetime(), String.valueOf(monthCount)));
            return orderItemStatic;
        }).collect(Collectors.toList());
        return resultList;
    }

    private BigDecimal calTotalAmount(List<String> ipList, Long merchantId, Long monthCount) {
        KtonIpStaticConfigPlan ktonIpStaticConfigPlan = this.staticConfigPlanDao.getByMerchantId(merchantId);
        BigDecimal totalAmount = null;
        totalAmount = ktonIpStaticConfigPlan == null ? this.staticConfigPlanDao.calIpListTotalAmount(0L, ipList) : this.staticConfigPlanDao.calIpListTotalAmount(merchantId, ipList);
        if (totalAmount == null) {
            throw new IllegalArgumentException("\u8ba1\u7b97\u603b\u4ef7\u5931\u8d25\uff0c\u914d\u7f6e\u4ef7\u683c\u672a\u627e\u5230\uff0c\u8bf7\u914d\u7f6e\u4ef7\u683c");
        }
        totalAmount = totalAmount.multiply(BigDecimal.valueOf(monthCount));
        return totalAmount;
    }

    public Date getRenewExpireDatetimeAddStartTime(Date startDate, String activationDurationType) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = this.convertDateToLocalDateTime(startDate);
        int monthsToAdd = this.getMonthsToAdd(activationDurationType);
        LocalDateTime expireDateTime = now.isAfter(startDateTime) ? now.plusMonths(monthsToAdd) : startDateTime.plusMonths(monthsToAdd);
        return this.convertLocalDateTimeToDate(expireDateTime);
    }

    private LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    private int getMonthsToAdd(String activationDurationType) {
        int monthsToAdd = 0;
        switch (activationDurationType) {
            case "monthly": {
                monthsToAdd = 1;
                break;
            }
            case "quarterly": {
                monthsToAdd = 3;
                break;
            }
            case "semi_annually": {
                monthsToAdd = 6;
                break;
            }
            case "annually": {
                monthsToAdd = 12;
                break;
            }
            default: {
                try {
                    monthsToAdd = Integer.parseInt(activationDurationType);
                    break;
                }
                catch (NumberFormatException e) {
                    System.err.println("Invalid activation duration type: " + activationDurationType);
                }
            }
        }
        return monthsToAdd;
    }

    public String getOrderNoByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            result = result + random.nextInt(10);
        }
        return ORDER_PREFIX + newDate + result;
    }

    @Generated
    public OrderServiceImpl(AdminOrderDao adminOrderDao, AdminStaticConfigPlanDao staticConfigPlanDao, AdminIpStaticPoolDao adminIpStaticPoolDao, AdminOrderItemStaticDao adminOrderItemStaticDao, KtonOrderItemStaticMapper ktonOrderItemStaticMapper, AdminIpStaticSourceDao adminIpStaticSourceDao, AdminIpStaticMerchantDao adminIpStaticMerchantDao, AdminIpStaticPoolItemDao adminIpStaticPoolItemDao, KtonMerchantWalletMapper ktonMerchantWalletMapper, KtonMerchantWalletItemMapper ktonMerchantWalletItemMapper, AdminStaticUnsubscribeDao adminStaticUnsubscribeDao, IpStaticPoolSourceDao ipStaticPoolSourceDao, KtonOrderMapper ktonOrderMapper) {
        this.adminOrderDao = adminOrderDao;
        this.staticConfigPlanDao = staticConfigPlanDao;
        this.adminIpStaticPoolDao = adminIpStaticPoolDao;
        this.adminOrderItemStaticDao = adminOrderItemStaticDao;
        this.ktonOrderItemStaticMapper = ktonOrderItemStaticMapper;
        this.adminIpStaticSourceDao = adminIpStaticSourceDao;
        this.adminIpStaticMerchantDao = adminIpStaticMerchantDao;
        this.adminIpStaticPoolItemDao = adminIpStaticPoolItemDao;
        this.ktonMerchantWalletMapper = ktonMerchantWalletMapper;
        this.ktonMerchantWalletItemMapper = ktonMerchantWalletItemMapper;
        this.adminStaticUnsubscribeDao = adminStaticUnsubscribeDao;
        this.ipStaticPoolSourceDao = ipStaticPoolSourceDao;
        this.ktonOrderMapper = ktonOrderMapper;
    }
}

