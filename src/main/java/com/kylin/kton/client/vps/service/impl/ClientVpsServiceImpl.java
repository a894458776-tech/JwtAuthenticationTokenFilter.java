/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.model.LoginUser
 *  com.kylin.kton.common.utils.PageUtils
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.vps.service.impl;

import com.kylin.kton.client.vps.entity.dto.ContainerParamListDTO;
import com.kylin.kton.client.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.client.vps.entity.dto.VpsHostPerformanceDTO;
import com.kylin.kton.client.vps.entity.vo.ClientImagesSearchVO;
import com.kylin.kton.client.vps.entity.vo.ContainerParamListSearchVO;
import com.kylin.kton.client.vps.entity.vo.HostListSearchVO;
import com.kylin.kton.client.vps.entity.vo.PerformanceListSearchVO;
import com.kylin.kton.client.vps.entity.vo.QueryVpsContainer;
import com.kylin.kton.client.vps.entity.vo.UpdateStatusVO;
import com.kylin.kton.client.vps.entity.vo.VpsHostContainerVO;
import com.kylin.kton.client.vps.mapper.ClientVpsMapper;
import com.kylin.kton.client.vps.service.ClientVpsService;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.utils.PageUtils;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonVpsImages;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientVpsServiceImpl
implements ClientVpsService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientVpsServiceImpl.class);
    private final ClientVpsMapper clientVpsMapper;

    @Override
    public List<VpsHostContainerVO> query(QueryVpsContainer queryVpsContainer) {
        PageUtils.startPage();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        return this.clientVpsMapper.query(queryVpsContainer, loginUser.getUserId());
    }

    @Override
    public VpsHostContainerVO containerDetail(Long containerId) {
        Long merchantId = SecurityUtils.getUserId();
        return this.clientVpsMapper.containerDetail(containerId, merchantId);
    }

    @Override
    public void openStopVps(UpdateStatusVO updateStatusVO) {
        this.clientVpsMapper.openStopVps(updateStatusVO);
    }

    @Override
    public List<VpsHostDTO> hostList(HostListSearchVO searchVO) {
        return this.clientVpsMapper.hostList(searchVO);
    }

    @Override
    public List<VpsHostPerformanceDTO> performanceList(PerformanceListSearchVO searchVO) {
        return this.clientVpsMapper.performanceList(searchVO);
    }

    @Override
    public List<ContainerParamListDTO> containerParamList(ContainerParamListSearchVO searchVO) {
        return this.clientVpsMapper.containerParamList(searchVO);
    }

    @Override
    public List<KtonVpsImages> imagesList(ClientImagesSearchVO searchVO) {
        return this.clientVpsMapper.imagesList(searchVO);
    }

    @Generated
    public ClientVpsServiceImpl(ClientVpsMapper clientVpsMapper) {
        this.clientVpsMapper = clientVpsMapper;
    }
}

