/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpUnsubscribe;
import java.util.List;

public interface IKtonIpUnsubscribeService {
    public KtonIpUnsubscribe selectKtonIpUnsubscribeById(Long var1);

    public List<KtonIpUnsubscribe> selectKtonIpUnsubscribeList(KtonIpUnsubscribe var1);

    public int insertKtonIpUnsubscribe(KtonIpUnsubscribe var1);

    public int updateKtonIpUnsubscribe(KtonIpUnsubscribe var1);

    public int deleteKtonIpUnsubscribeByIds(Long[] var1);

    public int deleteKtonIpUnsubscribeById(Long var1);
}

