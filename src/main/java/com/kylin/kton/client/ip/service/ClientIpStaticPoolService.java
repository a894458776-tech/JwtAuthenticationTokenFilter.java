/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpStaticPoolService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolDTO;
import com.kylin.kton.client.ip.entity.dto.RegionalAvailableIpsDTO;
import com.kylin.kton.client.ip.entity.vo.ClientRegionalAvailableIpsVO;
import com.kylin.kton.client.ip.entity.vo.StaticPoolSearchVO;
import com.kylin.kton.system.service.IKtonIpStaticPoolService;
import java.util.List;

public interface ClientIpStaticPoolService
extends IKtonIpStaticPoolService {
    public List<ClientIpStaticPoolDTO> list(StaticPoolSearchVO var1);

    public List<RegionalAvailableIpsDTO> regionalAvailableIps(ClientRegionalAvailableIpsVO var1);
}

