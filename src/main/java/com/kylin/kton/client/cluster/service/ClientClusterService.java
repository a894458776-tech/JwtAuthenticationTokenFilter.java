/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 */
package com.kylin.kton.client.cluster.service;

import com.kylin.kton.client.cluster.entity.dto.ClusterDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterHostDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterTemplateDTO;
import com.kylin.kton.client.cluster.entity.vo.ClusterHostListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.ClusterListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateDetailVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateListSearchVO;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import java.util.List;

public interface ClientClusterService {
    public List<ClusterDTO> clusterList(ClusterListSearchVO var1);

    public List<ClusterTemplateDTO> templateList(TemplateListSearchVO var1);

    public KtonClusterHostTemplate templateDetail(TemplateDetailVO var1);

    public List<ClusterHostDTO> clusterHostList(ClusterHostListSearchVO var1);
}

