/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.cluster.service.impl;

import com.kylin.kton.client.cluster.entity.dto.ClusterDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterHostDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterTemplateDTO;
import com.kylin.kton.client.cluster.entity.vo.ClusterHostListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.ClusterListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateDetailVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateListSearchVO;
import com.kylin.kton.client.cluster.mapper.ClientClusterMapper;
import com.kylin.kton.client.cluster.service.ClientClusterService;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientClusterServiceImpl
implements ClientClusterService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientClusterServiceImpl.class);
    private final ClientClusterMapper clientClusterMapper;

    @Override
    public List<ClusterDTO> clusterList(ClusterListSearchVO searchVO) {
        return this.clientClusterMapper.clusterList(searchVO);
    }

    @Override
    public List<ClusterTemplateDTO> templateList(TemplateListSearchVO searchVO) {
        return this.clientClusterMapper.templateList(searchVO.getClusterId(), searchVO.getTemplateId());
    }

    @Override
    public KtonClusterHostTemplate templateDetail(TemplateDetailVO detailVO) {
        return this.clientClusterMapper.getByRefId(detailVO.getHostTemplateId());
    }

    @Override
    public List<ClusterHostDTO> clusterHostList(ClusterHostListSearchVO searchVO) {
        return this.clientClusterMapper.clusterHostList(searchVO.getClusterId());
    }

    @Generated
    public ClientClusterServiceImpl(ClientClusterMapper clientClusterMapper) {
        this.clientClusterMapper = clientClusterMapper;
    }
}

