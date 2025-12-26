/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  com.kylin.kton.system.domain.KtonVpsIpPool
 *  com.kylin.kton.system.service.impl.KtonVpsIpPoolServiceImpl
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.vps.service.impl;

import com.kylin.kton.admin.user.mapper.VpsIpPoolDao;
import com.kylin.kton.admin.vps.entity.vo.VpsIpPoolAddVO;
import com.kylin.kton.admin.vps.mapper.VpsHostMapper;
import com.kylin.kton.admin.vps.service.VpsHostService;
import com.kylin.kton.admin.vps.service.VpsIpPoolService;
import com.kylin.kton.system.domain.KtonVpsHost;
import com.kylin.kton.system.domain.KtonVpsIpPool;
import com.kylin.kton.system.service.impl.KtonVpsIpPoolServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VpsIpPoolServiceImpl
extends KtonVpsIpPoolServiceImpl
implements VpsIpPoolService {
    @Autowired
    private VpsIpPoolDao vpsIpPoolDao;
    @Autowired
    private VpsHostService vpsHostService;
    @Autowired
    VpsHostMapper vpsHostMapper;

    @Override
    public Integer add(VpsIpPoolAddVO addVO) {
        Integer quantity = addVO.getQuantity();
        String startIp = addVO.getIp();
        String containerIp = addVO.getContainerIp();
        KtonVpsHost vpsHost = this.vpsHostService.selectKtonVpsHostById(addVO.getHostId());
        String[] ipParts = startIp.split("\\.");
        if (ipParts.length < 4) {
            throw new IllegalArgumentException("\u8d77\u59cbIP\u5730\u5740\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u662fIPv4\u683c\u5f0f\uff08\u4f8b\u5982\uff1a192.168.1.1\uff09");
        }
        int startNumber = Integer.parseInt(ipParts[3]);
        String[] containerIpParts = containerIp.split("\\.");
        if (containerIpParts.length < 4) {
            throw new IllegalArgumentException("\u5bb9\u5668IP\u8d77\u59cb\u5730\u5740\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u662fIPv4\u683c\u5f0f\uff08\u4f8b\u5982\uff1a192.168.1.1\uff09");
        }
        int containerStartNumber = Integer.parseInt(containerIpParts[3]);
        String ipPrefix = startIp.substring(0, startIp.lastIndexOf(".") + 1);
        String containerIpPrefix = containerIp.substring(0, containerIp.lastIndexOf(".") + 1);
        int maxNumber = startNumber + quantity - 1;
        if (maxNumber > 255) {
            throw new IllegalArgumentException("\u751f\u6210\u7684IP\u53f7\u6bb5\u8d85\u51fa\u8303\u56f4\uff0c\u6700\u5927\u53f7\u6bb5\u4e3a255\u3002");
        }
        int maxContainerNumber = containerStartNumber + quantity - 1;
        if (maxContainerNumber > 255) {
            throw new IllegalArgumentException("\u751f\u6210\u7684\u5bb9\u5668IP\u53f7\u6bb5\u8d85\u51fa\u8303\u56f4\uff0c\u6700\u5927\u53f7\u6bb5\u4e3a255\u3002");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("\u6570\u91cf\u5fc5\u987b\u5927\u4e8e0");
        }
        ArrayList<KtonVpsIpPool> ipPoolList = new ArrayList<KtonVpsIpPool>();
        for (int i = 0; i < quantity; ++i) {
            int currentIpLast = startNumber + i;
            if (currentIpLast == 0 || currentIpLast == 1 || currentIpLast == 2 || currentIpLast == 255) continue;
            String currentIp = ipPrefix + currentIpLast;
            String currentContainerIp = containerIpPrefix + (containerStartNumber + i);
            if (this.checkIpExist(currentIp)) continue;
            KtonVpsIpPool ktonVpsIpPool = new KtonVpsIpPool();
            BeanUtils.copyProperties((Object)addVO, (Object)ktonVpsIpPool);
            ktonVpsIpPool.setIp(currentIp);
            ktonVpsIpPool.setContainerIp(currentContainerIp);
            ktonVpsIpPool.setHostId(addVO.getHostId());
            ktonVpsIpPool.setStatus(Long.valueOf(0L));
            ktonVpsIpPool.setCreateTime(new Date());
            ktonVpsIpPool.setClusterId(Long.valueOf(Objects.isNull(vpsHost) ? 0L : vpsHost.getClusterId()));
            ipPoolList.add(ktonVpsIpPool);
        }
        return this.vpsIpPoolDao.batchInsertKtonVpsIpPool(ipPoolList);
    }

    private boolean checkIpExist(String ip) {
        Integer hostIpRes = this.vpsHostMapper.checkIpEixit(ip);
        return hostIpRes > 0;
    }
}

