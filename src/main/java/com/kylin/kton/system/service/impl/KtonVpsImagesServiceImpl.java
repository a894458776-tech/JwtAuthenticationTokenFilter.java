/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.system.service.impl;

import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.mapper.KtonVpsImagesMapper;
import com.kylin.kton.system.service.IKtonVpsImagesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsImagesServiceImpl
implements IKtonVpsImagesService {
    @Autowired
    private KtonVpsImagesMapper ktonVpsImagesMapper;

    @Override
    public KtonVpsImages selectKtonVpsImagesById(Long id) {
        return this.ktonVpsImagesMapper.selectKtonVpsImagesById(id);
    }

    @Override
    public List<KtonVpsImages> selectKtonVpsImagesList(KtonVpsImages ktonVpsImages) {
        return this.ktonVpsImagesMapper.selectKtonVpsImagesList(ktonVpsImages);
    }

    @Override
    public int insertKtonVpsImages(KtonVpsImages ktonVpsImages) {
        ktonVpsImages.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsImagesMapper.insertKtonVpsImages(ktonVpsImages);
    }

    @Override
    public int updateKtonVpsImages(KtonVpsImages ktonVpsImages) {
        ktonVpsImages.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsImagesMapper.updateKtonVpsImages(ktonVpsImages);
    }

    @Override
    public int deleteKtonVpsImagesByIds(Long[] ids) {
        return this.ktonVpsImagesMapper.deleteKtonVpsImagesByIds(ids);
    }

    @Override
    public int deleteKtonVpsImagesById(Long id) {
        return this.ktonVpsImagesMapper.deleteKtonVpsImagesById(id);
    }
}

