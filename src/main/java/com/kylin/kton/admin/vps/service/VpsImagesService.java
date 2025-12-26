/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.service.IKtonVpsImagesService
 */
package com.kylin.kton.admin.vps.service;

import com.kylin.kton.admin.vps.entity.vo.MerchantImagesListSearchVO;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.service.IKtonVpsImagesService;
import java.util.List;

public interface VpsImagesService
extends IKtonVpsImagesService {
    public List<KtonVpsImages> merchantImagesList(MerchantImagesListSearchVO var1);

    public Integer add(KtonVpsImages var1);
}

