/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.service.impl.KtonVpsImagesServiceImpl
 *  javax.annotation.Resource
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.vps.service.impl;

import com.kylin.kton.admin.vps.entity.vo.MerchantImagesListSearchVO;
import com.kylin.kton.admin.vps.mapper.VpsImagesMapper;
import com.kylin.kton.admin.vps.service.VpsImagesService;
import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.service.impl.KtonVpsImagesServiceImpl;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class VpsImagesServiceImpl
extends KtonVpsImagesServiceImpl
implements VpsImagesService {
    @Resource
    private VpsImagesMapper vpsImagesMapper;

    @Override
    public List<KtonVpsImages> merchantImagesList(MerchantImagesListSearchVO searchVO) {
        return this.vpsImagesMapper.merchantImagesList(searchVO);
    }

    @Override
    public Integer add(KtonVpsImages ktonVpsImages) {
        ktonVpsImages.setCreateTime(DateUtils.getNowDate());
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-", "");
        ktonVpsImages.setRefId(uuidStr.substring(0, 32));
        return this.vpsImagesMapper.insertKtonVpsImages(ktonVpsImages);
    }
}

