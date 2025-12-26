/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticAuthWhitelist;
import java.util.List;

public interface IKtonIpStaticAuthWhitelistService {
    public KtonIpStaticAuthWhitelist selectKtonIpStaticAuthWhitelistById(Long var1);

    public List<KtonIpStaticAuthWhitelist> selectKtonIpStaticAuthWhitelistList(KtonIpStaticAuthWhitelist var1);

    public int insertKtonIpStaticAuthWhitelist(KtonIpStaticAuthWhitelist var1);

    public int updateKtonIpStaticAuthWhitelist(KtonIpStaticAuthWhitelist var1);

    public int deleteKtonIpStaticAuthWhitelistByIds(Long[] var1);

    public int deleteKtonIpStaticAuthWhitelistById(Long var1);
}

