/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsImages
 */
package com.kylin.kton.client.vps.service;

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
import com.kylin.kton.system.domain.KtonVpsImages;
import java.util.List;

public interface ClientVpsService {
    public List<VpsHostContainerVO> query(QueryVpsContainer var1);

    public VpsHostContainerVO containerDetail(Long var1);

    public void openStopVps(UpdateStatusVO var1);

    public List<VpsHostDTO> hostList(HostListSearchVO var1);

    public List<VpsHostPerformanceDTO> performanceList(PerformanceListSearchVO var1);

    public List<ContainerParamListDTO> containerParamList(ContainerParamListSearchVO var1);

    public List<KtonVpsImages> imagesList(ClientImagesSearchVO var1);
}

