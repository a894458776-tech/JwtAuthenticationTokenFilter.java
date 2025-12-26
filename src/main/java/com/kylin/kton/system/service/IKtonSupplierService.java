/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonSupplier;
import java.util.List;

public interface IKtonSupplierService {
    public KtonSupplier selectKtonSupplierById(Long var1);

    public List<KtonSupplier> selectKtonSupplierList(KtonSupplier var1);

    public int insertKtonSupplier(KtonSupplier var1);

    public int updateKtonSupplier(KtonSupplier var1);

    public int deleteKtonSupplierByIds(Long[] var1);

    public int deleteKtonSupplierById(Long var1);
}

