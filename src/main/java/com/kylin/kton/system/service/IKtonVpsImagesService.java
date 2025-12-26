/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonVpsImages;
import java.util.List;

public interface IKtonVpsImagesService {
    public KtonVpsImages selectKtonVpsImagesById(Long var1);

    public List<KtonVpsImages> selectKtonVpsImagesList(KtonVpsImages var1);

    public int insertKtonVpsImages(KtonVpsImages var1);

    public int updateKtonVpsImages(KtonVpsImages var1);

    public int deleteKtonVpsImagesByIds(Long[] var1);

    public int deleteKtonVpsImagesById(Long var1);
}

