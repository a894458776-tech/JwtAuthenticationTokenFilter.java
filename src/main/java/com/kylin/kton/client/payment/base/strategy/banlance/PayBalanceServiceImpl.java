package com.kylin.kton.client.payment.base.strategy.banlance;

import com.kylin.kton.client.cluster.mapper.ClientClusterMapper;
import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolItemDTO;
import com.kylin.kton.client.ip.entity.dto.UpdateIpStaticPoolItemSingleDTO;
import com.kylin.kton.client.ip.mapper.ClientStaticMerchantDao;
import com.kylin.kton.client.ip.mapper.ClientStaticPoolItemDao;
import com.kylin.kton.client.ip.mapper.ClientStaticSourceDao;
import com.kylin.kton.client.merchant.base.mapper.MerchantConfigDao;
import com.kylin.kton.client.order.mapper.ClientOrderItemDao;
import com.kylin.kton.client.payment.base.constants.PayConstants;
import com.kylin.kton.client.payment.base.entity.dto.PayResultDTO;
import com.kylin.kton.client.payment.base.service.PayService;
import com.kylin.kton.client.risk.service.RiskService;
import com.kylin.kton.client.vps.mapper.ClientVpsMapper;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.*;
import com.kylin.kton.system.mapper.*;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PayBalanceServiceImpl implements PayService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(PayBalanceServiceImpl.class);
    @Resource
    KtonOrderMapper ktonOrderMapper;
    @Resource
    KtonOrderItemDynamicsMapper ktonOrderItemDynamicsMapper;
    @Resource
    KtonOrderItemStaticMapper ktonOrderItemStaticMapper;
    @Resource
    KtonMerchantWalletMapper ktonMerchantWalletMapper;
    @Resource
    KtonMerchantWalletItemMapper ktonMerchantWalletItemMapper;
    @Resource
    KtonMerchantSummaryMapper ktonMerchantSummaryMapper;
    @Resource
    ClientStaticMerchantDao clientStaticMerchantDao;
    @Resource
    ClientOrderItemDao clientOrderItemDao;
    @Resource
    KtonVpsHostContainerParamMapper vpsHostContainerParamMapper;
    @Resource
    KtonClusterHostTemplateMapper templateMapper;
    @Resource
    ClientStaticPoolItemDao clientStaticPoolItemDao;
    @Autowired
    @Qualifier(value = "clientStaticSourceDao")
    ClientStaticSourceDao clientStaticSourceDao;
    @Autowired
    private KtonVpsHostContainerMapper ktonVpsHostContainerMapper;
    @Resource
    ClientVpsMapper clientVpsMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    KtonIpDynamicsPlanMapper planMapper;
    @Autowired
    ClientClusterMapper clientClusterMapper;
    @Resource
    MerchantConfigDao merchantConfigDao;
    @Autowired
    RiskService riskService;
    @Value(value = "${source.conf.assignTimes}")
    Integer assignTimes;

    @Override
    public PayConstants.Payment getPayment() {
        return PayConstants.Payment.BALANCE;
    }

    @Override
    @Transactional
    public PayResultDTO pay(Long orderId) {
        KtonOrder order = this.ktonOrderMapper.selectKtonOrderById(orderId);
        KtonMerchantWallet assets = this.ktonMerchantWalletMapper.selectKtonMerchantWalletByMerchantId(order.getMerchantId());
        if (assets != null) {
            BigDecimal balance = assets.getBalance();
            BigDecimal totalAmount = assets.getTotalAmount();
            BigDecimal lastBalance = balance.subtract(order.getTotalAmount());
            BigDecimal lastTotalAmount = totalAmount.add(order.getTotalAmount());
            assets.setBalance(lastBalance);
            assets.setTotalAmount(lastTotalAmount);
            assets.setUpdateTime(new Date());
            this.ktonMerchantWalletMapper.updateKtonMerchantWallet(assets);

            KtonMerchantWalletItem assetsHistory = new KtonMerchantWalletItem();
            assetsHistory.setType(2L);
            assetsHistory.setAmount(order.getTotalAmount());
            assetsHistory.setMerchantId(order.getMerchantId());
            this.ktonMerchantWalletItemMapper.insertKtonMerchantWalletItem(assetsHistory);

            order.setPaidStatus(20L);
            order.setUpdateTime(new Date());
            this.ktonOrderMapper.updateKtonOrder(order);

            this.addkSummary(order.getMerchantId(), order.getQuantity());

            if (order.getProductType() == 1L) {
                KtonOrderItemDynamics entity = new KtonOrderItemDynamics();
                entity.setOrderId(order.getId());
                // 修复：添加泛型
                List<KtonOrderItemDynamics> orderItemDynamics = this.ktonOrderItemDynamicsMapper.selectKtonOrderItemDynamicsList(entity);
                if (orderItemDynamics.size() > 0) {
                    KtonOrderItemDynamics orderItem = orderItemDynamics.get(0);
                    this.addPlan(order.getMerchantId(), orderItem.getCapacity());
                }
            } else if (order.getProductType() == 2L) {
                this.addStaticItem(order);
            } else if (order.getProductType() == 3L) {
                this.createContainer(order);
            }
        }
        PayResultDTO payResultDTO = new PayResultDTO();
        payResultDTO.setPaymentType(PayConstants.Payment.BALANCE.name());
        payResultDTO.setPaymentName("余额支付");
        payResultDTO.setPayMessage("success");
        payResultDTO.setStatus(1);
        payResultDTO.setOrderId(order.getId());
        this.sendWeComMessage(order);
        return payResultDTO;
    }

    private void addStaticItem(KtonOrder order) {
        KtonOrderItemStatic entity = new KtonOrderItemStatic();
        entity.setOrderId(order.getId());
        // 修复：添加泛型 List<KtonOrderItemStatic>
        List<KtonOrderItemStatic> orderItems = this.ktonOrderItemStaticMapper.selectKtonOrderItemStaticList(entity);
        log.info("addStatic orderItems = {}", orderItems);

        Long merchantId = order.getMerchantId();
        KtonMerchantConfig config = this.merchantConfigDao.merchantConfigInfo(merchantId);
        boolean isRiskCheckRequired = this.isRiskCheckRequired(config);

        if (orderItems.size() > 0) {
            for (KtonOrderItemStatic orderItem : orderItems) {
                if (orderItem.getIp() != null) {
                    Date subscribeDatetime = new Date();
                    this.clientStaticMerchantDao.updateExpireDate(orderItem.getOrderId(), orderItem.getExpireDatetime(), subscribeDatetime, orderItem.getIp(), order.getMerchantId());
                    continue;
                }

                ClientIpStaticPoolItemDTO selectedIp = null;
                if (isRiskCheckRequired) {
                    List<ClientIpStaticPoolItemDTO> availableIps = this.clientStaticPoolItemDao.listAvailableIps(orderItem.getPoolId(), merchantId, this.assignTimes);
                    if (availableIps.isEmpty()) {
                        throw new CustomServiceException("Insufficient IP pool inventory, order placement failed.");
                    }
                    // 修复：添加 Map 和 List 泛型
                    Map<Integer, List<ClientIpStaticPoolItemDTO>> groupedByAssignTimes = availableIps.stream()
                            .collect(Collectors.groupingBy(ClientIpStaticPoolItemDTO::getAssignTimes, TreeMap::new, Collectors.toList()));

                    for (Map.Entry<Integer, List<ClientIpStaticPoolItemDTO>> entry : groupedByAssignTimes.entrySet()) {
                        int currentAssignLevel = entry.getKey();
                        log.debug("Checking IPs with assign_times={}", currentAssignLevel);
                        // 修复：添加 List 泛型
                        List<ClientIpStaticPoolItemDTO> sameLevelIps = entry.getValue().stream()
                                .sorted(Comparator.comparing(ClientIpStaticPoolItemDTO::getId)) // 这里原本是用父类 KtonIpStaticPoolItem::getId，但 DTO 也有 Id
                                .collect(Collectors.toList());

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
                    selectedIp = this.clientStaticPoolItemDao.getIp(orderItem.getPoolId(), merchantId, this.assignTimes);
                }
                this.bindIpToOrderItem(orderItem, selectedIp);
                this.clientOrderItemDao.updateSingleItem(orderItem);
                this.consumingIp(order, selectedIp, orderItem.getDays());
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
            ktonIpStaticMerchant.setLastOrderId(order.getId());
            ktonIpStaticMerchant.setMerchantId(order.getMerchantId());
            ktonIpStaticMerchant.setCreateTime(new Date());
            this.clientStaticMerchantDao.insertKtonIpStaticMerchant(ktonIpStaticMerchant);
        }
        this.clientStaticSourceDao.incrementAssignTimes(poolItem.getIp());
    }

    private Boolean checkRiskDetection(KtonMerchantConfig config, String ip) {
        return this.riskService.checkRisk(config, ip);
    }

    private boolean isRiskCheckRequired(KtonMerchantConfig config) {
        return config != null && config.getRiskDetectionEnabled() == 1L && StringUtils.isNotBlank(config.getRiskDetectionBaseUrl());
    }

    public Date getStaticExpireDatetimeAddStartTime(Date startDate, Long days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(5, Math.toIntExact(days));
        return calendar.getTime();
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

    private void addPlan(Long merchantId, BigDecimal capacity) {
        log.info("addPlan 入参 merchantId =  " + merchantId);
        log.info("addPlan  入参 capacity" + capacity);
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        entity.setMerchantId(merchantId);
        // 修复：添加泛型
        List<KtonIpDynamicsPlan> plans = this.planMapper.selectKtonIpDynamicsPlanList(entity);
        if (plans.size() > 0) {
            KtonIpDynamicsPlan plan = plans.get(0);
            BigDecimal planTrafficGb = plan.getPlanTrafficGb();
            BigDecimal planResidueTrafficGb = plan.getPlanResidueTrafficGb();
            BigDecimal lastPlanTrafficGb = planTrafficGb.add(capacity);
            BigDecimal lastPlanResidueTrafficGb = planResidueTrafficGb.add(capacity);
            plan.setPlanTrafficGb(lastPlanTrafficGb);
            plan.setPlanResidueTrafficGb(lastPlanResidueTrafficGb);
            plan.setUpdateTime(new Date());
            this.planMapper.updateKtonIpDynamicsPlan(plan);
        } else {
            KtonIpDynamicsPlan plan = new KtonIpDynamicsPlan();
            plan.setMerchantId(merchantId);
            plan.setPlanTrafficGb(capacity);
            plan.setPlanResidueTrafficGb(capacity);
            plan.setCreateTime(new Date());
            this.planMapper.insertKtonIpDynamicsPlan(plan);
        }
    }

    private void addkSummary(Long merchantId, Long staticIpCount) {
        KtonMerchantSummary summary = this.ktonMerchantSummaryMapper.selectKtonMerchantSummaryById(merchantId);
        if (summary != null) {
            Long lastStaticIpCount = summary.getStaticIpCount() + staticIpCount;
            summary.setStaticIpCount(lastStaticIpCount);
            summary.setUpdateTime(new Date());
            this.ktonMerchantSummaryMapper.updateKtonMerchantSummary(summary);
        } else {
            KtonMerchantSummary addSummary = new KtonMerchantSummary();
            addSummary.setId(merchantId);
            addSummary.setStaticIpCount(staticIpCount);
            addSummary.setCreateTime(new Date());
            this.ktonMerchantSummaryMapper.insertKtonMerchantSummary(addSummary);
        }
    }

    private void sendWeComMessage(KtonOrder order) {
        Long merchantId = order.getMerchantId();
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "业务事件通知：\n商户成功支付：\n商户名：" + ktonMerchant.getName() + "\n商户ID:" + ktonMerchant.getId() + "\n订单号: " + order.getOrderNo() + "\n支付方式: 余额支付 \n支付时间：" + formattedDate;
        WeChatWebhookUtil.sendMessage(msg);
    }

    private void createContainer(KtonOrder order) {
        // 修复：添加泛型
        List<KtonOrderItemVps> orderItemVps = this.clientOrderItemDao.getVpsItemByOrderId(order.getId());
        for (KtonOrderItemVps itemVps : orderItemVps) {
            KtonVpsHostContainer hostContainer;
            if (itemVps.getVpsId() != null) {
                hostContainer = new KtonVpsHostContainer();
                hostContainer.setId(itemVps.getVpsId());
                hostContainer.setExpireDate(itemVps.getExpireDatetime());
                this.ktonVpsHostContainerMapper.updateKtonVpsHostContainer(hostContainer);
                this.clientVpsMapper.updateStatus(itemVps.getHostId(), itemVps.getVpsIp());
                continue;
            }
            hostContainer = new KtonVpsHostContainer();
            hostContainer.setHostId(itemVps.getHostId());
            hostContainer.setMerchantId(order.getMerchantId());
            hostContainer.setType(itemVps.getVpsType());
            hostContainer.setExpireDate(itemVps.getExpireDatetime());
            KtonVpsIpPool ipPool = this.clientVpsMapper.getIp(itemVps.getClusterId(), order.getMerchantId());
            if (ipPool == null) {
                throw new CustomServiceException("host is not config, create fail ");
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
            this.addContainerParams(itemVps.getHostTemplateId(), hostContainer.getId(), hostId);
            this.clientVpsMapper.updateStatus(hostId, ip);
            itemVps.setVpsId(hostContainer.getId());
            itemVps.setHostIp(ip);
            itemVps.setVpsIp(ip);
            itemVps.setUpdateTime(new Date());
            this.clientOrderItemDao.updateVpsItem(itemVps);
        }
    }

    private void addContainerParams(String templateId, Long containerId, Long hostId) {
        if (templateId != null) {
            KtonClusterHostTemplate configTemplate = this.clientClusterMapper.getByRefId(templateId);
            KtonVpsHostContainerParam addEntity = new KtonVpsHostContainerParam();
            BeanUtils.copyProperties(configTemplate, addEntity);
            addEntity.setContainerId(containerId);
            addEntity.setHostTemplateId(templateId);
            addEntity.setHostId(hostId);
            addEntity.setCreateTime(new Date());
            this.vpsHostContainerParamMapper.insertKtonVpsHostContainerParam(addEntity);
        }
    }
}