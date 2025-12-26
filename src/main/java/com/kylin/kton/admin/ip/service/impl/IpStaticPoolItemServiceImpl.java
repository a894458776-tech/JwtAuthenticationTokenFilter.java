/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  com.kylin.kton.system.service.impl.KtonIpStaticPoolItemServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemInfoDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminUnassignedIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolAllListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminUnassignedIpsVO;
import com.kylin.kton.admin.ip.entity.vo.PoolItemAddBatchVO;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolItemDao;
import com.kylin.kton.admin.ip.service.IpStaticPoolItemService;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.service.impl.KtonIpStaticPoolItemServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpStaticPoolItemServiceImpl
extends KtonIpStaticPoolItemServiceImpl
implements IpStaticPoolItemService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpStaticPoolItemServiceImpl.class);
    @Autowired
    AdminIpStaticPoolItemDao adminIpStaticPoolItemDao;

    @Override
    public List<AdminIpStaticPoolItemDTO> allList(AdminIpStaticPoolAllListSearchVO searchVO) {
        return this.adminIpStaticPoolItemDao.allList(searchVO);
    }

    @Override
    public List<AdminIpStaticPoolItemInfoDTO> list(AdminIpStaticPoolListSearchVO searchVO) {
        return this.adminIpStaticPoolItemDao.list(searchVO);
    }

    @Override
    public Integer addBatch(PoolItemAddBatchVO addBatchVO) {
        ArrayList<KtonIpStaticPoolItem> items = new ArrayList<KtonIpStaticPoolItem>();
        for (String ip : addBatchVO.getIps()) {
            KtonIpStaticPoolItem item = new KtonIpStaticPoolItem();
            item.setIp(ip);
            item.setPoolId(addBatchVO.getPoolId());
            item.setCreateTime(new Date());
            item.setUpdateTime(new Date());
            items.add(item);
        }
        return this.adminIpStaticPoolItemDao.batchInsertIpPoolItems(items);
    }

    @Override
    public List<AdminUnassignedIpsDTO> unassignedIps(AdminUnassignedIpsVO unassignedIpsVO) {
        return this.adminIpStaticPoolItemDao.unassignedIps(unassignedIpsVO);
    }
}

