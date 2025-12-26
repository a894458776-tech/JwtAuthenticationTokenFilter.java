/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.bean.BeanUtils
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  com.kylin.kton.system.domain.KtonVpsHostContainerParam
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.domain.KtonVpsIpPool
 *  com.kylin.kton.system.mapper.KtonClusterHostTemplateMapper
 *  com.kylin.kton.system.mapper.KtonVpsHostContainerParamMapper
 *  com.kylin.kton.system.service.impl.KtonVpsHostContainerServiceImpl
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.vps.service.impl;

import com.kylin.kton.admin.cluster.mapper.AdminClusterMapper;
import com.kylin.kton.admin.user.mapper.VpsIpPoolDao;
import com.kylin.kton.admin.vps.entity.vo.AddVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.QueryVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.UpdateVpsStatusVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostContainerVO;
import com.kylin.kton.admin.vps.mapper.VpsHostContainerMapper;
import com.kylin.kton.admin.vps.mapper.VpsImagesMapper;
import com.kylin.kton.admin.vps.service.VpsHostContainerService;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import com.kylin.kton.system.domain.KtonVpsHostContainer;
import com.kylin.kton.system.domain.KtonVpsHostContainerParam;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.domain.KtonVpsIpPool;
import com.kylin.kton.system.mapper.KtonClusterHostTemplateMapper;
import com.kylin.kton.system.mapper.KtonVpsHostContainerParamMapper;
import com.kylin.kton.system.service.impl.KtonVpsHostContainerServiceImpl;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VpsHostContainerServiceImpl
extends KtonVpsHostContainerServiceImpl
implements VpsHostContainerService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(VpsHostContainerServiceImpl.class);
    private final VpsHostContainerMapper vpsHostContainerMapper;
    @Resource
    VpsIpPoolDao vpsIpPoolDao;
    @Resource
    KtonVpsHostContainerParamMapper vpsHostContainerParamMapper;
    @Resource
    AdminClusterMapper adminClusterMapper;
    @Resource
    VpsImagesMapper vpsImagesMapper;
    @Resource
    KtonClusterHostTemplateMapper templateMapper;

    @Override
    public List<VpsHostContainerVO> queryVpsHostContainer(QueryVpsHostContainerVO queryVpsHostContainerVO) {
        return this.vpsHostContainerMapper.queryVpsHostContainer(queryVpsHostContainerVO);
    }

    @Override
    public void openStopVps(UpdateVpsStatusVO updateVpsStatusVO) {
        this.vpsHostContainerMapper.updateVpsContainerStatus(updateVpsStatusVO);
    }

    @Override
    public Integer addHostContainer(AddVpsHostContainerVO addVpsHostContainerVO) {
        int i;
        long latestIpId = 0L;
        for (i = 0; i < addVpsHostContainerVO.getQuantity(); ++i) {
            KtonVpsHostContainer hostContainer = new KtonVpsHostContainer();
            BeanUtils.copyProperties((Object)addVpsHostContainerVO, (Object)hostContainer);
            KtonVpsIpPool ipPool = this.vpsIpPoolDao.getIp(addVpsHostContainerVO.getClusterId(), latestIpId, addVpsHostContainerVO.getMerchantId());
            if (ipPool == null) {
                throw new RuntimeException("\u6ca1\u6709\u53ef\u7528\u7684IP\uff0c\u8bf7\u5148\u914d\u7f6eIP\u6c60");
            }
            latestIpId = ipPool.getId();
            String ip = ipPool.getIp();
            String containerIp = ipPool.getContainerIp();
            Long hostId = ipPool.getHostId();
            hostContainer.setVpsIp(ip);
            hostContainer.setContainerIp(containerIp);
            hostContainer.setHostId(hostId);
            this.insertKtonVpsHostContainer(hostContainer);
            KtonVpsImages vpsImages = this.vpsImagesMapper.getByRefId(addVpsHostContainerVO.getImagesId());
            String imagesUrl = vpsImages.getImageUrl() + ":" + vpsImages.getImageVersion();
            this.addContainerParams(addVpsHostContainerVO.getHostTemplateId(), hostContainer.getId(), hostId, imagesUrl);
            this.vpsIpPoolDao.updateStatus(ipPool.getId(), 1);
        }
        return i;
    }

    private void addContainerParams(String templateId, Long containerId, Long hostId, String imagesUrl) {
        if (templateId != null) {
            KtonClusterHostTemplate configTemplate = this.adminClusterMapper.getByRefId(templateId);
            KtonVpsHostContainerParam addEntity = new KtonVpsHostContainerParam();
            BeanUtils.copyProperties((Object)configTemplate, (Object)addEntity);
            addEntity.setContainerId(containerId);
            addEntity.setHostTemplateId(templateId);
            addEntity.setHostId(hostId);
            addEntity.setImageUrl(imagesUrl);
            addEntity.setCreateTime(new Date());
            this.vpsHostContainerParamMapper.insertKtonVpsHostContainerParam(addEntity);
        }
    }

    private static void updateCountAssign(Connection connection, String ip, int count) {
    }

    @Generated
    public VpsHostContainerServiceImpl(VpsHostContainerMapper vpsHostContainerMapper) {
        this.vpsHostContainerMapper = vpsHostContainerMapper;
    }
}

