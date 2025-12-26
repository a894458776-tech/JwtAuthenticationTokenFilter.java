/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.mapper.KtonVpsImagesMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.mapper.KtonVpsImagesMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClientVpsImagesMapper
extends KtonVpsImagesMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_images ", "WHERE  ref_id = #{refId} ", "LIMIT 1 ", "</script>"})
    public KtonVpsImages getByRefId(@Param(value="refId") String var1);
}

