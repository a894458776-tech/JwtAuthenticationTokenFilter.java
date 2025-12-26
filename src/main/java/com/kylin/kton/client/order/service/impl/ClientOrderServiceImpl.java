package com.kylin.kton.client.order.service.impl;

import com.kylin.kton.client.cluster.entity.dto.ClusterTemplateDTO;
import com.kylin.kton.client.cluster.mapper.ClientClusterMapper;
import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolItemDTO;
import com.kylin.kton.client.ip.entity.dto.UpdateIpStaticPoolItemSingleDTO;
import com.kylin.kton.client.ip.entity.vo.ClientStaticPoolSearchVO;
import com.kylin.kton.client.ip.mapper.*;
import com.kylin.kton.client.merchant.base.mapper.MerchantConfigDao;
import com.kylin.kton.client.order.entity.dto.*;
import com.kylin.kton.client.order.entity.vo.*;
import com.kylin.kton.client.order.mapper.ClientOrderDao;
import com.kylin.kton.client.order.mapper.ClientOrderItemDao;
import com.kylin.kton.client.order.service.ClientOrderService;
import com.kylin.kton.client.risk.service.RiskService;
import com.kylin.kton.client.vps.mapper.*;
import com.kylin.kton.common.constant.OrderConstants;
import com.kylin.kton.common.constant.OrderIpStaticConstants;
import com.kylin.kton.common.constant.OrderProductNameConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.*;
import com.kylin.kton.system.mapper.*;
import com.kylin.kton.system.service.impl.KtonOrderServiceImpl;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClientOrderServiceImpl extends KtonOrderServiceImpl implements ClientOrderService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientOrderServiceImpl.class);
    @Autowired
    ClientOrderDao clientOrderDao;
    @Autowired
    KtonOrderMapper ktonOrderMapper;
    @Autowired
    KtonOrderItemStaticMapper ktonOrderItemStaticMapper;
    @Autowired
    KtonOrderItemDynamicsMapper orderItemDynamicsMapper;
    @Autowired
    KtonIpStaticPoolMapper ktonIpStaticPoolMapper;
    @Autowired
    KtonClusterMapper clusterMapper;
    @Autowired
    ClentVpsHostMapper clentVpsHostMapper;
    @Autowired
    KtonIpStaticConfigPeriodMapper ktonIpStaticConfigPeriodMapper;
    @Autowired
    KtonIpStaticConfigPlanMapper ktonIpStaticConfigPlanMapper;
    @Autowired
    KtonIpDynamicsConfigPeriodMapper dynamicsConfigPeriodMapper;
    @Autowired
    KtonIpDynamicsConfigPlanMapper dynamicsConfigPlanMapper;
    @Autowired
    ClientStaticPoolItemDao clientStaticPoolItemDao;
    @Autowired
    ClientOrderItemDao clientOrderItemDao;
    @Autowired
    KtonIpDynamicsChannelMapper dynamicsChannelMapper;
    @Autowired
    KtonIpDynamicsPlanMapper planMapper;
    @Autowired
    KtonIpDynamicsPlanOrderMapper planOrderMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    ClientVpsHostContainerMapper clientVpsHostContainerMapper;
    @Autowired
    KtonOrderItemVpsMapper orderItemVpsMapper;
    @Autowired
    ClientStaticPoolDao clientStaticPoolDao;
    @Autowired
    ClientStaticConfigPlanDao staticConfigPlanDao;
    @Autowired
    ClientVpsMapper clientVpsMapper;
    @Autowired
    ClientClusterMapper clientClusterMapper;
    @Autowired
    ClentVpsIpPoolMapper clentVpsIpPoolMapper;
    @Autowired
    ClientVpsHostContainerParamsMapper clientVpsHostContainerParamsMapper;
    @Resource
    KtonVpsHostContainerParamMapper vpsHostContainerParamMapper;
    @Resource
    KtonClusterHostTemplateMapper templateMapper;
    @Resource
    ClientVpsImagesMapper clientVpsImagesMapper;
    @Resource
    ClientStaticUnsubscribeDao clientStaticUnsubscribeDao;
    @Resource
    MerchantConfigDao merchantConfigDao;
    @Autowired
    @Qualifier(value = "clientStaticSourceDao")
    ClientStaticSourceDao clientStaticSourceDao;
    @Resource
    ClientStaticMerchantDao clientStaticMerchantDao;
    @Autowired
    private KtonVpsHostContainerMapper ktonVpsHostContainerMapper;
    @Autowired
    RiskService riskService;
    @Value(value = "${source.conf.assignTimes}")
    Integer assignTimes;

    @Override
    @Transactional
    public AjaxResult addStatic(OrderStaticAddVO addVO) {
        log.info("下单入参原始参数 {}", addVO);
        this.checkStaticInventory(addVO);
        KtonOrder order = this.buildBaseOrder(addVO);
        this.persistOrder(order, addVO);
        this.handlePostPayment(order, addVO);
        return AjaxResult.success("Order placed successfully.", order.getOrderNo());
    }

    private KtonOrder buildBaseOrder(OrderStaticAddVO addVO) {
        KtonOrder ktonOrder = new KtonOrder();
        BeanUtils.copyProperties(addVO, ktonOrder);
        ktonOrder.setMerchantId(addVO.getMerchantId());
        ktonOrder.setOrderNo(this.getOrderNoByTime());
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_STATIC.getAlias());
        ktonOrder.setProductType(2L);
        ktonOrder.setQuantity(this.getNum(addVO.getCountryNums()));
        ktonOrder.setTotalIps(this.getNum(addVO.getCountryNums()));
        BigDecimal totalAmount = this.calcStaticTotal(addVO);
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setCurrency(addVO.getCurrency());
        ktonOrder.setPayMethod(addVO.getPayMethod());
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setExpireDatetime(this.getExpireDatetime(addVO.getMonthCount() * 30L));
        ktonOrder.setCreateTime(new Date());
        return ktonOrder;
    }

    private void persistOrder(KtonOrder order, OrderStaticAddVO addVO) {
        this.ktonOrderMapper.insertKtonOrder(order);
        List<KtonOrderItemStatic> orderItems = this.getOrderItems(addVO, order.getId());
        log.info("addStatic orderItems = {}", orderItems);
        if (orderItems.size() > 0) {
            this.clientOrderItemDao.saveBatch(orderItems);
        }
    }

    private void handlePostPayment(KtonOrder order, OrderStaticAddVO addVO) {
        if (this.isPayLater(addVO)) {
            this.updateOrderPaymentStatus(order, 20L);
            this.addStaticItem(order, addVO.getIsExclusive());
        }
        this.notifyMerchant(addVO.getMerchantId(), order);
    }

    private boolean isPayLater(OrderStaticAddVO addVO) {
        return OrderConstants.PAY_MODE.PAY_LATER.name().equals(addVO.getPayMode());
    }

    private void updateOrderPaymentStatus(KtonOrder order, Long status) {
        order.setPaidStatus(status);
        order.setUpdateTime(new Date());
        this.ktonOrderMapper.updateKtonOrder(order);
    }

    private Date calculateExpireDate(Integer monthCount) {
        return DateUtils.addDays(new Date(), monthCount * 30);
    }

    private void notifyMerchant(Long merchantId, KtonOrder order) {
        try {
            this.sendWeComMessage(merchantId, order);
        } catch (Exception e) {
            log.warn("企业微信通知发送失败 orderNo:{}", order.getOrderNo(), e);
        }
    }

    private void checkStaticInventory(OrderStaticAddVO addVO) {
        KtonMerchantConfig config = this.merchantConfigDao.merchantConfigInfo(addVO.getMerchantId());
        boolean isRiskCheckRequired = this.isRiskCheckRequired(config);
        for (CountryNumsItemVO countryItem : addVO.getCountryNums()) {
            KtonIpStaticPool staticPool = this.getStaticPool(countryItem, (long) countryItem.getIpType());
            if (staticPool == null) {
                throw new CustomServiceException("IP pool configuration not found. Please check if the IP pool exists.");
            }
            int requiredNum = countryItem.getNum();
            int availableStock = this.getAndCheckLocalInventory(staticPool, addVO.getMerchantId(), requiredNum);
            if (!isRiskCheckRequired) continue;
            log.info("Performing risk check for poolId: {}, merchantId: {}", staticPool.getId(), addVO.getMerchantId());
            this.checkRiskInventory(config, staticPool, addVO.getMerchantId(), requiredNum, availableStock);
        }
    }

    private boolean isRiskCheckRequired(KtonMerchantConfig config) {
        return config != null && config.getRiskDetectionEnabled() == 1L && StringUtils.isNotBlank(config.getRiskDetectionBaseUrl());
    }

    private int getAndCheckLocalInventory(KtonIpStaticPool pool, Long merchantId, int requiredNum) {
        Integer availableStock = this.clientStaticPoolItemDao.getAvailableStock(pool.getId(), merchantId, this.assignTimes);
        int actualStock = availableStock == null ? 0 : availableStock;
        if (actualStock < requiredNum) {
            throw new CustomServiceException(this.buildInventoryMessage(pool, requiredNum, actualStock, "inventory"));
        }
        return actualStock;
    }

    private void checkRiskInventory(KtonMerchantConfig config, KtonIpStaticPool pool, Long merchantId, int requiredNum, int availableStock) {
        log.info("Checking risk inventory for poolId: {}, merchantId: {}", pool.getId(), merchantId);
        if (!this.isRiskAvailable(config, pool.getId(), merchantId, requiredNum)) {
            throw new CustomServiceException(this.buildInventoryMessage(pool, requiredNum, availableStock, "available IPs"));
        }
    }

    private String buildInventoryMessage(KtonIpStaticPool pool, int required, int available, String stockType) {
        return String.format("Insufficient %s for %s-%s. Requested: %d ip  greater than Available ips", stockType, pool.getCountryCode(), pool.getType(), required, available);
    }

    private boolean isRiskAvailable(KtonMerchantConfig config, Long poolId, Long merchantId, int requiredNum) {
        Boolean result = this.getRiskAvailableStock(config, poolId, merchantId, requiredNum);
        return Boolean.TRUE.equals(result);
    }

    private Boolean getRiskAvailableStock(KtonMerchantConfig config, Long poolId, Long merchantId, Integer countryNums) {
        List<KtonIpStaticPoolItem> ipItems = this.clientStaticPoolItemDao.selectByPoolAndMerchant(poolId, merchantId);
        if (ipItems == null || ipItems.isEmpty()) {
            return false;
        }
        if (countryNums == null || countryNums <= 0) {
            return true;
        }
        long availableCount = ipItems.parallelStream()
                .map(poolItem -> this.checkRiskDetection(config, poolItem.getIp()))
                .filter(Boolean.TRUE::equals)
                .limit(countryNums)
                .count();
        return availableCount >= (long) countryNums;
    }

    private Boolean checkRiskDetection(KtonMerchantConfig config, String ip) {
        log.info("checkRiskDetection ip:{}", ip);
        return this.riskService.checkRisk(config, ip);
    }

    @Override
    public AjaxResult dataStatistics(ClientDataStatisticsVO statisticsVO) {
        ClientDataStatisticsDTO clientDataStatisticsDTO = new ClientDataStatisticsDTO();
        DaysUntilExpireDTO daysUntilExpireDTO = this.clientOrderItemDao.daysUntilExpire(statisticsVO.getMerchantId());
        if (daysUntilExpireDTO != null) {
            clientDataStatisticsDTO.setNextPayDays(daysUntilExpireDTO.getDaysUntilExpire());
        }
        Integer ipTotal = this.clientOrderItemDao.ipTotal(statisticsVO.getMerchantId(), 1L);
        clientDataStatisticsDTO.setRegularipTotal(ipTotal);
        Integer expiringSoon = this.clientOrderItemDao.expiringSoonIps(statisticsVO.getMerchantId(), 1L);
        clientDataStatisticsDTO.setRegularExpiringSoon(expiringSoon);
        Integer premiumIpTotal = this.clientOrderItemDao.ipTotal(statisticsVO.getMerchantId(), 2L);
        clientDataStatisticsDTO.setPremiumIpTotal(premiumIpTotal);
        Integer premiumExpiringSoon = this.clientOrderItemDao.expiringSoonIps(statisticsVO.getMerchantId(), 2L);
        clientDataStatisticsDTO.setPremiumExpiringSoon(premiumExpiringSoon);
        return AjaxResult.success(clientDataStatisticsDTO);
    }

    private Long getNum(List<CountryNumsItemVO> countryNums) {
        long num = 0L;
        for (CountryNumsItemVO countryNumsItemVO : countryNums) {
            if (countryNumsItemVO.getIpType() != 1) continue;
            num = num + (long) countryNumsItemVO.getNum();
        }
        return num;
    }

    @Override
    @Transactional
    public AjaxResult addDynamics(OrderDynamicsAddVO addVO) {
        log.info("addDynamics 订单入参 = {}", addVO);
        KtonIpDynamicsConfigPeriod configPeriod = this.dynamicsConfigPeriodMapper.selectKtonIpDynamicsConfigPeriodById(addVO.getConfigPeriodId());
        Long days = configPeriod.getDays();
        KtonOrder ktonOrder = new KtonOrder();
        BeanUtils.copyProperties(addVO, ktonOrder);
        BigDecimal totalAmount = this.calcDynamicsTotal(addVO);
        ktonOrder.setOrderNo(this.getOrderNoByTime());
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setExpireDatetime(this.getExpireDatetime(days));
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_DYNAMICS.getAlias());
        ktonOrder.setCreateTime(new Date());
        this.ktonOrderMapper.insertKtonOrder(ktonOrder);
        this.setOrderDynamicsItems(addVO, ktonOrder.getId(), days);
        this.sendWeComMessage(addVO.getMerchantId(), ktonOrder);
        return AjaxResult.success("下单成功", ktonOrder.getOrderNo());
    }

    @Override
    @Transactional
    public AjaxResult addVpsOrder(VpsOrderAddVO addVO) {
        AjaxResult validationResult = this.validateBeforeAddOrder(addVO);
        if (validationResult != null) {
            return validationResult;
        }
        log.info("addStatic 订单入参 = {}", addVO);
        KtonOrder ktonOrder = new KtonOrder();
        BeanUtils.copyProperties(addVO, ktonOrder);
        BigDecimal totalAmount = this.calcVpsTotal(addVO);
        ktonOrder.setTotalAmount(totalAmount);
        ktonOrder.setCreateTime(new Date());
        ktonOrder.setProductType(3L);
        ktonOrder.setProductName(OrderProductNameConstants.PRODUCT_TYPE.PRO_VPS.getAlias());
        ktonOrder.setQuantity((long) addVO.getOrderItems().size());
        ktonOrder.setOrderNo(this.getOrderNoByTime());
        ktonOrder.setEffectiveDatetime(new Date());
        ktonOrder.setExpireDatetime(this.getVpsExpireDatetime(addVO.getActivationDurationType()));
        ktonOrder.setTotalAmount(totalAmount);
        this.ktonOrderMapper.insertKtonOrder(ktonOrder);
        this.addVpsItem(addVO, ktonOrder.getId());
        if (OrderConstants.PAY_MODE.PAY_LATER.name().equals(addVO.getPayMode())) {
            ktonOrder.setPaidStatus(20L);
            ktonOrder.setUpdateTime(new Date());
            this.ktonOrderMapper.updateKtonOrder(ktonOrder);
            this.createContainer(ktonOrder);
        }
        return AjaxResult.success("下单成功", ktonOrder.getOrderNo());
    }

    private AjaxResult validateBeforeAddOrder(VpsOrderAddVO addVO) {
        List<VpsOrderAddVO.OrderItem> orderItems = addVO.getOrderItems();
        if (CollectionUtils.isEmpty(orderItems)) {
            log.info("订单项不能为空");
            return AjaxResult.error("Order items cannot be empty");
        }
        for (VpsOrderAddVO.OrderItem item : orderItems) {
            KtonCluster cluster;
            if (item.getContainerId() != null) {
                KtonVpsHostContainer container = this.clientVpsHostContainerMapper.getByContainerId(item.getContainerId());
                if (container == null) {
                    log.info("容器不存在，容器ID：{}", item.getContainerId());
                    return AjaxResult.error("Container not found, ID: " + item.getContainerId());
                }
                KtonClusterHostTemplate hostTemplate = this.clientClusterMapper.getByRefId(container.getHostTemplateId());
                if (hostTemplate == null) {
                    log.info("容器关联的主机模板不存在，容器ID：{}", item.getContainerId());
                    return AjaxResult.error("Host template associated with container not found, container ID: " + item.getContainerId());
                }
                continue; // 容器存在时跳过后续检查
            }
            if (item.getHostTemplateId() == null) {
                log.info("主机模板ID不能为空");
                return AjaxResult.error("Host template ID is required");
            }
            KtonClusterHostTemplate hostTemplate = this.clientClusterMapper.getByRefId(item.getHostTemplateId());
            if (hostTemplate == null) {
                log.info("主机模板不存在，模板ID：{}", item.getHostTemplateId());
                return AjaxResult.error("Host template not found, ID: " + item.getHostTemplateId());
            }
            if (item.getImagesId() == null) {
                log.info("镜像ID不能为空");
            } else {
                if (this.clientVpsImagesMapper.getByRefId(item.getImagesId()) == null) {
                    log.info("镜像不存在，镜像ID：{}", item.getImagesId());
                }
            }
            if ((cluster = this.clusterMapper.selectKtonClusterById(hostTemplate.getClusterId())) == null) {
                log.info("集群不存在，集群ID：{}", hostTemplate.getClusterId());
                return AjaxResult.error("Cluster not found, ID: " + hostTemplate.getClusterId());
            }
            int availableIpCount = this.clientVpsMapper.countAvailableIps(cluster.getId(), addVO.getMerchantId());
            if (availableIpCount > 0) continue;
            log.info("集群[{}]无可用IP，请选择其他区域", cluster.getClusterName());
            return AjaxResult.error(String.format("No available IPs in cluster [%s], please choose another region", cluster.getClusterName()));
        }
        try {
            this.getVpsExpireDatetime(addVO.getActivationDurationType());
        } catch (IllegalArgumentException e) {
            log.info("有效期类型无效：{}", e.getMessage());
            return AjaxResult.error("Invalid activation duration type: " + e.getMessage());
        }
        return null;
    }

    private void addVpsItem(VpsOrderAddVO addVO, Long orderId) {
        List<VpsOrderAddVO.OrderItem> orderItems = addVO.getOrderItems();
        for (VpsOrderAddVO.OrderItem orderItem : orderItems) {
            KtonOrderItemVps itemVps = new KtonOrderItemVps();
            itemVps.setEffectiveDatetime(new Date());
            itemVps.setExpireDatetime(this.getVpsExpireDatetime(addVO.getActivationDurationType()));
            KtonClusterHostTemplate ktonClusterHostTemplate;
            String imagesUrl = "";
            if (orderItem.getContainerId() != null) {
                KtonVpsHostContainer hostContainer = this.clientVpsHostContainerMapper.getByContainerId(orderItem.getContainerId());
                Long vpsId = hostContainer.getId();
                itemVps.setVpsId(vpsId);
                ktonClusterHostTemplate = this.clientClusterMapper.getByRefId(hostContainer.getHostTemplateId());
                KtonVpsHostContainerParam containerParam = this.clientVpsHostContainerParamsMapper.getByContainerId(orderItem.getContainerId());
                if (containerParam == null) {
                    log.info("ContainerParam is null ");
                } else {
                    imagesUrl = containerParam.getImageUrl();
                }
                itemVps.setExpireDatetime(this.getVpsReNewExpireDatetime(hostContainer.getExpireDate(), addVO.getActivationDurationType()));
            } else {
                if (orderItem.getHostTemplateId() == null) {
                    throw new CustomServiceException("HostTemplateId is null ");
                }
                ktonClusterHostTemplate = this.clientClusterMapper.getByRefId(orderItem.getHostTemplateId());
                KtonVpsImages vpsImages = this.clientVpsImagesMapper.getByRefId(orderItem.getImagesId());
                if (vpsImages != null) {
                    imagesUrl = vpsImages.getImageUrl() + ":" + vpsImages.getImageVersion();
                }
            }
            itemVps.setImagesUrl(imagesUrl);
            itemVps.setHostTemplateId(ktonClusterHostTemplate.getRefId());
            itemVps.setOrderId(orderId);
            itemVps.setActivationDurationType(addVO.getActivationDurationType());
            BeanUtils.copyProperties(ktonClusterHostTemplate, itemVps);
            KtonCluster cluster = this.clusterMapper.selectKtonClusterById(ktonClusterHostTemplate.getClusterId());
            itemVps.setContinent(cluster.getContinent());
            itemVps.setCountryCode(cluster.getCountryCode());
            itemVps.setCity(cluster.getCity());
            itemVps.setCreateTime(new Date());
            itemVps.setUpdateTime(new Date());
            this.orderItemVpsMapper.insertKtonOrderItemVps(itemVps);
        }
    }

    public void sendWeComMessage(Long merchantId, KtonOrder order) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "业务事件通知：\n商户购买下单：\n商户名：" + ktonMerchant.getName() + "\n商户ID:" + ktonMerchant.getId() + "\n订单号: " + order.getOrderNo() + "\n下单时间：" + formattedDate;
        WeChatWebhookUtil.sendMessage(msg);
    }

    private List<KtonOrderItemStatic> getOrderItems(OrderStaticAddVO orderAddVO, Long orderId) {
        ArrayList<KtonOrderItemStatic> ktonOrderItems = new ArrayList<>();
        List<CountryNumsItemVO> countryList = orderAddVO.getCountryNums();
        for (CountryNumsItemVO countryNumsItemVO : countryList) {
            log.info("countryNumsItemVO = {}", countryNumsItemVO);
            Long ipType = (long) countryNumsItemVO.getIpType();
            Long days = orderAddVO.getMonthCount() * 30L;
            KtonIpStaticPool staticPool = this.getStaticPool(countryNumsItemVO, ipType);
            if (staticPool == null) {
                throw new CustomServiceException("IP pool configuration not found. Please check if the IP pool exists.");
            }
            Long poolId = staticPool.getId();
            Integer ipNum = countryNumsItemVO.getNum();
            BigDecimal price = this.getConfigByNum(orderAddVO.getMerchantId(), countryNumsItemVO.getCountryCode(), countryNumsItemVO.getIpType(), orderAddVO.getIsExclusive());
            for (int i = 0; i < ipNum; ++i) {
                KtonOrderItemStatic orderItem = new KtonOrderItemStatic();
                orderItem.setOrderType(ipType);
                orderItem.setOrderId(orderId);
                orderItem.setPoolId(poolId);
                orderItem.setPrice(price);
                orderItem.setCurrency(orderAddVO.getCurrency());
                orderItem.setDays(days);
                orderItem.setContinent(staticPool.getContinent());
                orderItem.setCountryCode(staticPool.getCountryCode());
                orderItem.setLocation(staticPool.getLocation());
                orderItem.setEffectiveDatetime(new Date());
                orderItem.setExpireDatetime(this.getExpireDatetime(days));
                orderItem.setStatus("Y");
                ktonOrderItems.add(orderItem);
            }
        }
        return ktonOrderItems;
    }

    private KtonIpStaticPool getStaticPool(CountryNumsItemVO countryNumsItemVO, Long ipType) {
        ClientStaticPoolSearchVO searchVO = new ClientStaticPoolSearchVO();
        if (countryNumsItemVO.getContinent() != null && !countryNumsItemVO.getContinent().equals("")) {
            searchVO.setContinent(countryNumsItemVO.getContinent());
        }
        if (countryNumsItemVO.getCountryCode() != null && !countryNumsItemVO.getCountryCode().equals("")) {
            searchVO.setCountryCode(countryNumsItemVO.getCountryCode());
        }
        if (countryNumsItemVO.getLocation() != null && !countryNumsItemVO.getLocation().equals("")) {
            searchVO.setLocation(countryNumsItemVO.getLocation());
        }
        if (ipType != null) {
            searchVO.setType(ipType);
        }
        BeanUtils.copyProperties(countryNumsItemVO, searchVO);
        log.info("getStaticPool 入参  searchVO = {}", searchVO);
        return this.clientStaticPoolDao.getByCode(searchVO);
    }

    private void setOrderDynamicsItems(OrderDynamicsAddVO addVO, Long orderId, Long days) {
        KtonOrderItemDynamics ktonOrderItems = new KtonOrderItemDynamics();
        BeanUtils.copyProperties(addVO, ktonOrderItems);
        ktonOrderItems.setOrderId(orderId);
        ktonOrderItems.setEffectiveDatetime(new Date());
        ktonOrderItems.setExpireDatetime(this.getExpireDatetime(days));
        this.orderItemDynamicsMapper.insertKtonOrderItemDynamics(ktonOrderItems);
    }

    @Override
    public ClientOrderDetailDTO orderDetail(Long orderId) {
        Long merchantId = SecurityUtils.getUserId();
        return this.clientOrderDao.detail(merchantId, orderId);
    }

    @Override
    public List<ClientOrderItemStaticDTO> purchasedList(PurchasedListSearchVO searchVO) {
        return this.clientOrderItemDao.purchasedList(searchVO);
    }

    @Override
    public Boolean beenPurchased(BeenPurchasedVO beenPurchasedVO) {
        Integer count = this.clientOrderItemDao.beenPurchased(beenPurchasedVO);
        return count > 0;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Boolean unsubscribeStaticIps(UnsubscribeStaticIpVO unsubscribeStaticIpVO) {
        try {
            this.clientStaticUnsubscribeDao.saveUnsubscribeBatch(unsubscribeStaticIpVO);
        } catch (Exception exception) {
            // empty catch block
        }
        List<String> strList = unsubscribeStaticIpVO.getIpList();
        for (String ip : strList) {
            KtonIpStaticMerchant staticMerchant = this.clientStaticMerchantDao.selectByIpAndMerchantId(ip, unsubscribeStaticIpVO.getMerchantId());
            if (staticMerchant == null || staticMerchant.getStatus() == 3L) continue;
            KtonOrderItemStatic itemStatic = this.clientOrderItemDao.selectByIp(ip, unsubscribeStaticIpVO.getMerchantId(), staticMerchant.getLastOrderId());
            if (itemStatic != null) {
                itemStatic.setStatus(OrderIpStaticConstants.STATUS.T.name());
                itemStatic.setUnsubscribeTime(new Date());
                this.ktonOrderItemStaticMapper.updateKtonOrderItemStatic(itemStatic);
            }
            this.releaseIp(staticMerchant, staticMerchant.getLastPoolId());
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Boolean unsubscribeStaticStrIps(UnsubscribeStaticStrIpsVO staticStrIpsVO) {
        List<String> ipList = new ArrayList<>();
        if (staticStrIpsVO.getIpList() != null) {
            ipList = Arrays.asList(staticStrIpsVO.getIpList().split(","));
        }
        UnsubscribeStaticIpVO unsubscribeStaticIpVO = new UnsubscribeStaticIpVO();
        unsubscribeStaticIpVO.setMerchantId(staticStrIpsVO.getMerchantId());
        unsubscribeStaticIpVO.setIpList(ipList);
        this.clientStaticUnsubscribeDao.saveUnsubscribeBatch(unsubscribeStaticIpVO);
        List<String> strList = unsubscribeStaticIpVO.getIpList();
        for (String ip : strList) {
            KtonIpStaticMerchant staticMerchant = this.clientStaticMerchantDao.selectByIpAndMerchantId(ip, unsubscribeStaticIpVO.getMerchantId());
            if (staticMerchant == null || staticMerchant.getStatus() == 3L) continue;
            KtonOrderItemStatic itemStatic = this.clientOrderItemDao.selectByIp(ip, unsubscribeStaticIpVO.getMerchantId(), staticMerchant.getLastOrderId());
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
        this.clientStaticMerchantDao.refund(staticMerchant.getId());
        this.clientStaticSourceDao.subtAssignTimes(staticMerchant.getIp());
    }

    @Override
    public List<ClientOrderDetailDTO> orderList(ClientOrderSearchVO searchVO) {
        return this.clientOrderDao.orderList(searchVO);
    }

    @Override
    public ClientOrderVpsDetailDTO vpsOrder(ClientVpsOrderSearchVO searchVO) {
        Long merchantId = SecurityUtils.getUserId();
        KtonOrder ktonOrder = this.clientOrderDao.getByOrderNo(merchantId, searchVO.getOrderNo(), 3);
        ClientOrderVpsDetailDTO dto = new ClientOrderVpsDetailDTO();
        BeanUtils.copyProperties(ktonOrder, dto);
        List<ClientOrderItemVpsDTO> list = this.clientOrderItemDao.getVpsItemByOrderId2(ktonOrder.getId());
        dto.setOrderItems(list);
        return dto;
    }

    @Override
    @Transactional
    public Boolean unsubscribeVps(UnsubscribeVpsVO searchVO) {
        String unsubscribeVpsIdS = searchVO.getUnsubscribeContainerIds();
        // 修复：添加泛型
        List<String> strList = Stream.of(unsubscribeVpsIdS.split(",")).collect(Collectors.toList());
        for (String containerId : strList) {
            KtonVpsHostContainer hostContainer = this.clientVpsHostContainerMapper.getByContainerId(containerId);
            Long vpsId = hostContainer.getId();
            KtonOrderItemVps itemVps = this.clientOrderItemDao.selectVps(searchVO.getMerchantId(), vpsId);
            if (itemVps == null) continue;
            itemVps.setUnsubscribeTime(new Date());
            this.orderItemVpsMapper.updateKtonOrderItemVps(itemVps);
            if (vpsId == null) continue;
            this.clientVpsMapper.updateContainerStatus(51, vpsId);
        }
        return true;
    }

    public Date getExpireDatetime(Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Math.toIntExact(days));
        return calendar.getTime();
    }

    private Date getVpsExpireDatetime(String activationDurationType) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int monthsToAdd = getMonthsToAdd(activationDurationType);
        LocalDateTime expireDateTime = currentDateTime.plusMonths(monthsToAdd);
        return Date.from(expireDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private Date getVpsReNewExpireDatetime(Date oldExpireDateTime, String activationDurationType) {
        LocalDateTime oldDateTime = oldExpireDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime baseDateTime = now.isAfter(oldDateTime) ? now : oldDateTime;
        int monthsToAdd = getMonthsToAdd(activationDurationType);
        LocalDateTime expireDateTime = baseDateTime.plusMonths(monthsToAdd);
        return Date.from(expireDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getOrderNoByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            result.append(random.nextInt(10));
        }
        return "N" + newDate + result;
    }

    public BigDecimal calcStaticTotal(OrderStaticAddVO addVO) {
        List<CountryNumsItemVO> countryList = addVO.getCountryNums();
        BigDecimal total = new BigDecimal(0);
        for (CountryNumsItemVO countryNumsItemVO : countryList) {
            BigDecimal price = this.getConfigByNum(addVO.getMerchantId(), countryNumsItemVO.getCountryCode(), countryNumsItemVO.getIpType(), addVO.getIsExclusive());
            BigDecimal countryTotal = price.multiply(new BigDecimal(countryNumsItemVO.getNum()));
            total = total.add(countryTotal);
        }
        total = total.multiply(new BigDecimal(addVO.getMonthCount()));
        return total;
    }

    private BigDecimal getConfigByNum(Long merchantId, String countryCode, Integer ipType, Long isExclusive) {
        KtonIpStaticConfigPlan staticConfigPlans = this.staticConfigPlanDao.getByCountryCode(merchantId, countryCode, ipType, isExclusive);
        if (staticConfigPlans == null) {
            staticConfigPlans = this.staticConfigPlanDao.getByCountryCode(0L, countryCode, ipType, isExclusive);
        }
        if (staticConfigPlans == null) {
            throw new CustomServiceException("No price configuration found for the specified country.");
        }
        return staticConfigPlans.getPrice();
    }

    private BigDecimal calcDynamicsTotal(OrderDynamicsAddVO addVO) {
        KtonIpDynamicsConfigPlan configPlan = this.dynamicsConfigPlanMapper.selectKtonIpDynamicsConfigPlanById(addVO.getConfigPlanId());
        KtonIpDynamicsConfigPeriod configPeriod = this.dynamicsConfigPeriodMapper.selectKtonIpDynamicsConfigPeriodById(addVO.getConfigPeriodId());

        // 修复 NPE 问题的关键点：使用前面定义好的 safe discount
        BigDecimal discount = (configPlan == null) ? BigDecimal.ONE : configPlan.getDiscount();

        // 修改前：configPeriod.getPrice().multiply(configPlan.getDiscount()); -> 这会导致 NPE
        // 修改后：使用 discount 变量
        BigDecimal price = configPeriod.getPrice().multiply(discount);

        price = price.setScale(2, RoundingMode.FLOOR);
        BigDecimal total = price.multiply(addVO.getCapacity());
        log.info("total = {}", total);
        return total;
    }

    private BigDecimal calcVpsTotal(VpsOrderAddVO addVO) {
        List<VpsOrderAddVO.OrderItem> orderItems = addVO.getOrderItems();
        BigDecimal total = new BigDecimal(0);
        for (VpsOrderAddVO.OrderItem orderItemVO : orderItems) {
            String hostTemplateId = orderItemVO.getHostTemplateId();
            List<ClusterTemplateDTO> ktonClusterHostTemplateList = this.clientClusterMapper.templateList(null, hostTemplateId);
            if (CollectionUtils.isEmpty(ktonClusterHostTemplateList)) {
                throw new CustomServiceException("Host template not found for id: " + hostTemplateId);
            }
            ClusterTemplateDTO ktonClusterHostTemplate = ktonClusterHostTemplateList.get(0);
            BigDecimal itemTotal = new BigDecimal(0);
            switch (addVO.getActivationDurationType()) {
                case "monthly":
                    itemTotal = ktonClusterHostTemplate.getPriceMonthly();
                    break;
                case "quarterly":
                    itemTotal = ktonClusterHostTemplate.getPriceQuarterly();
                    break;
                case "semi_annually":
                    itemTotal = ktonClusterHostTemplate.getPriceSemiAnnually();
                    break;
                case "annually":
                    itemTotal = ktonClusterHostTemplate.getPriceAnnually();
                    break;
                default:
                    itemTotal = ktonClusterHostTemplate.getPriceMonthly();
            }
            total = total.add(itemTotal);
            log.info("Calculated total price: {}", itemTotal);
        }
        return total;
    }

    private void createContainer(KtonOrder order) {
        List<KtonOrderItemVps> orderItemVps = this.clientOrderItemDao.getVpsItemByOrderId(order.getId());
        for (KtonOrderItemVps itemVps : orderItemVps) {
            KtonVpsHost vpsHost;
            if (itemVps.getVpsId() != null) {
                KtonVpsHostContainer container = this.ktonVpsHostContainerMapper.selectKtonVpsHostContainerById(itemVps.getVpsId());
                Date oldExpireDate = container.getExpireDate();
                container.setExpireDate(this.getRenewExpireDatetimeAddStartTime(container.getExpireDate(), itemVps.getActivationDurationType()));
                this.ktonVpsHostContainerMapper.updateKtonVpsHostContainer(container);
                this.clientVpsMapper.updateStatus(itemVps.getHostId(), itemVps.getVpsIp());
                itemVps.setEffectiveDatetime(oldExpireDate);
                itemVps.setExpireDatetime(container.getExpireDate());
                KtonVpsHostContainer vpsHostContainer = this.clientVpsHostContainerMapper.selectKtonVpsHostContainerById(itemVps.getVpsId());
                if (vpsHostContainer != null) {
                    log.error("续费单未查询到容器信息 orderId:" + order.getId() + "容器id：" + itemVps.getVpsId());
                    itemVps.setVpsIp(vpsHostContainer.getVpsIp());
                    String hostIp = null;
                    if (vpsHostContainer.getHostId() != null && (vpsHost = this.clentVpsHostMapper.getById(vpsHostContainer.getHostId())) != null) {
                        hostIp = vpsHost.getHostIp();
                    }
                    itemVps.setHostIp(hostIp);
                }
                itemVps.setUpdateTime(new Date());
                this.clientOrderItemDao.updateVpsItem(itemVps);
                continue;
            }
            KtonVpsHostContainer hostContainer = new KtonVpsHostContainer();
            hostContainer.setHostId(itemVps.getHostId());
            hostContainer.setMerchantId(order.getMerchantId());
            hostContainer.setType(itemVps.getVpsType());
            hostContainer.setExpireDate(itemVps.getExpireDatetime());
            KtonVpsIpPool ipPool = this.clientVpsMapper.getIp(itemVps.getClusterId(), order.getMerchantId());
            if (ipPool == null) {
                throw new CustomServiceException("No available IP addresses, Create Container Failed");
            }
            String ip = ipPool.getIp();
            String containerIp = ipPool.getContainerIp();
            Long hostId = ipPool.getHostId();
            hostContainer.setVpsIp(ip);
            hostContainer.setContainerIp(containerIp);
            hostContainer.setHostTemplateId(itemVps.getHostTemplateId());
            hostContainer.setClusterId(itemVps.getClusterId());
            hostContainer.setHostId(hostId);
            this.ktonVpsHostContainerMapper.insertKtonVpsHostContainer(hostContainer);
            this.addContainerParams(itemVps.getHostTemplateId(), hostContainer.getId(), hostId, itemVps.getImagesUrl());
            this.clientVpsMapper.updateStatus(hostId, ip);
            itemVps.setVpsId(hostContainer.getId());
            String hostIp = null;
            if (hostId != null && (vpsHost = this.clentVpsHostMapper.getById(hostId)) != null) {
                hostIp = vpsHost.getHostIp();
            }
            itemVps.setHostIp(hostIp);
            itemVps.setVpsIp(ip);
            itemVps.setUpdateTime(new Date());
            this.clientOrderItemDao.updateVpsItem(itemVps);
        }
    }

    private void addContainerParams(String templateId, Long containerId, Long hostId, String imagesUrl) {
        if (templateId != null) {
            KtonClusterHostTemplate configTemplate = this.clientClusterMapper.getByRefId(templateId);
            KtonVpsHostContainerParam addEntity = new KtonVpsHostContainerParam();
            BeanUtils.copyProperties(configTemplate, addEntity);
            addEntity.setContainerId(containerId);
            addEntity.setHostTemplateId(templateId);
            addEntity.setImageUrl(imagesUrl);
            addEntity.setHostId(hostId);
            addEntity.setCreateTime(new Date());
            this.vpsHostContainerParamMapper.insertKtonVpsHostContainerParam(addEntity);
        }
    }

    private void addStaticItem(KtonOrder order, Long isExclusive) {
        Integer assignTimesParam = this.assignTimes;
        if (isExclusive.equals(1L)) {
            assignTimesParam = 0;
        }
        KtonOrderItemStatic entity = new KtonOrderItemStatic();
        entity.setOrderId(order.getId());
        List<KtonOrderItemStatic> orderItems = this.ktonOrderItemStaticMapper.selectKtonOrderItemStaticList(entity);
        log.info("addStatic orderItems = {}", orderItems);
        Long merchantId = order.getMerchantId();
        ArrayList<KtonOrderItemStatic> ktonOrderItems = new ArrayList<>();
        KtonMerchantConfig config = this.merchantConfigDao.merchantConfigInfo(merchantId);
        boolean isRiskCheckRequired = this.isRiskCheckRequired(config);
        if (orderItems.size() > 0) {
            for (KtonOrderItemStatic orderItem : orderItems) {
                ClientIpStaticPoolItemDTO selectedIp = null;
                if (isRiskCheckRequired) {
                    List<ClientIpStaticPoolItemDTO> availableIps = this.clientStaticPoolItemDao.listAvailableIps(orderItem.getPoolId(), merchantId, assignTimesParam);
                    if (availableIps.isEmpty()) {
                        throw new CustomServiceException("Insufficient IP pool inventory, order placement failed.");
                    }
                    // 修复：补全 Map 和 List 泛型
                    Map<Integer, List<ClientIpStaticPoolItemDTO>> groupedByAssignTimes = availableIps.stream().collect(Collectors.groupingBy(ClientIpStaticPoolItemDTO::getAssignTimes, TreeMap::new, Collectors.toList()));
                    for (Map.Entry<Integer, List<ClientIpStaticPoolItemDTO>> entry : groupedByAssignTimes.entrySet()) {
                        int currentAssignLevel = entry.getKey();
                        log.debug("Checking IPs with assign_times={}", currentAssignLevel);
                        List<ClientIpStaticPoolItemDTO> sameLevelIps = entry.getValue().stream().sorted(Comparator.comparing(ClientIpStaticPoolItemDTO::getId)).collect(Collectors.toList());
                        for (ClientIpStaticPoolItemDTO ip : sameLevelIps) {
                            if (!this.checkRiskDetection(config, ip.getIp())) continue;
                            selectedIp = ip;
                            break;
                        }
                        if (selectedIp == null) continue;
                        break;
                    }
                    if (selectedIp == null) {
                        throw new CustomServiceException("No IP addresses meet the risk control requirements. Order placement failed.");
                    }
                } else {
                    selectedIp = this.clientStaticPoolItemDao.getIp(orderItem.getPoolId(), merchantId, assignTimesParam);
                }
                this.bindIpToOrderItem(orderItem, selectedIp);
                this.clientOrderItemDao.updateSingleItem(orderItem);
                this.consumingIp(order, selectedIp, orderItem.getDays());
                ktonOrderItems.add(orderItem);
            }
        }
    }

    private void bindIpToOrderItem(KtonOrderItemStatic item, ClientIpStaticPoolItemDTO poolItem) {
        item.setIp(poolItem.getIp());
        item.setPort(poolItem.getPort());
        item.setAccount(poolItem.getAccount());
        item.setPassword(poolItem.getPassword());
        item.setProtocolse(poolItem.getProtocolse());
    }

    private void consumingIp(KtonOrder order, ClientIpStaticPoolItemDTO poolItem, Long days) {
        KtonIpStaticMerchant staticMerchant = this.clientStaticMerchantDao.selectByIpAndMerchantId(poolItem.getIp(), order.getMerchantId());
        if (staticMerchant != null) {
            staticMerchant.setLastPoolId(poolItem.getPoolId());
            staticMerchant.setLastOrderId(order.getId());
            staticMerchant.setExpireDatetime(this.getStaticExpireDatetimeAddStartTime(staticMerchant.getExpireDatetime(), days));
            staticMerchant.setSubscribeDatetime(new Date());
            staticMerchant.setUpdateTime(new Date());
            this.clientStaticMerchantDao.updateKtonIpStaticMerchant(staticMerchant);
        } else {
            KtonIpStaticMerchant ktonIpStaticMerchant = new KtonIpStaticMerchant();
            ktonIpStaticMerchant.setLastOrderId(order.getId());
            ktonIpStaticMerchant.setLastPoolId(poolItem.getPoolId());
            ktonIpStaticMerchant.setIp(poolItem.getIp());
            ktonIpStaticMerchant.setPort(poolItem.getPort());
            ktonIpStaticMerchant.setProtocolse(poolItem.getProtocolse());
            ktonIpStaticMerchant.setStatus(1L);
            ktonIpStaticMerchant.setEffectiveDatetime(new Date());
            ktonIpStaticMerchant.setExpireDatetime(order.getExpireDatetime());
            ktonIpStaticMerchant.setSubscribeDatetime(new Date());
            ktonIpStaticMerchant.setLastOrderId(order.getId());
            ktonIpStaticMerchant.setMerchantId(order.getMerchantId());
            ktonIpStaticMerchant.setCreateTime(new Date());
            this.clientStaticMerchantDao.insertKtonIpStaticMerchant(ktonIpStaticMerchant);
        }
        this.clientStaticSourceDao.incrementAssignTimes(poolItem.getIp());
    }

    private void updateIpPoolItem(KtonOrder order, String ip) {
        UpdateIpStaticPoolItemSingleDTO staticPoolItemDTO = new UpdateIpStaticPoolItemSingleDTO();
        staticPoolItemDTO.setIp(ip);
        staticPoolItemDTO.setStatus(1);
        this.clientStaticPoolItemDao.updateSingle(staticPoolItemDTO);
    }

    private void updateIpPoolItemSoruce(KtonOrder order, String ip) {
        KtonIpStaticSource staticSource = this.clientStaticSourceDao.selectByIp(ip);
        if (staticSource != null) {
            staticSource.setStatus(0L);
            this.clientStaticSourceDao.updateKtonIpStaticSource(staticSource);
        }
    }

    public Date getStaticExpireDatetimeAddStartTime(Date startDate, Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, Math.toIntExact(days));
        return calendar.getTime();
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
            case "monthly":
                monthsToAdd = 1;
                break;
            case "quarterly":
                monthsToAdd = 3;
                break;
            case "semi_annually":
                monthsToAdd = 6;
                break;
            case "annually":
                monthsToAdd = 12;
                break;
            default:
                try {
                    monthsToAdd = Integer.parseInt(activationDurationType);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid activation duration type: " + activationDurationType);
                }
        }
        return monthsToAdd;
    }
}