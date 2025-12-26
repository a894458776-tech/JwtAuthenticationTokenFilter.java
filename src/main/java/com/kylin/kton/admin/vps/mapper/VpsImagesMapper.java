/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.mapper.KtonVpsImagesMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.vps.mapper;

import com.kylin.kton.admin.vps.entity.vo.MerchantImagesListSearchVO;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.mapper.KtonVpsImagesMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface VpsImagesMapper
extends KtonVpsImagesMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_images ", "WHERE  ref_id = #{refId} ", "LIMIT 1 ", "</script>"})
    public KtonVpsImages getByRefId(@Param(value="refId") String var1);

    @Select(value={"<script>select *  from kton_vps_images   where status = 1 and image_type ='vps-container' and (merchant_id = #{vo.merchantId} or merchant_id = 0 ) <if test='vo.name != null'> and name = #{vo.name}</if><if test='vo.refId != null'> and h.ref_id = #{vo.refId}</if> order by id desc</script>"})
    public List<KtonVpsImages> merchantImagesList(@Param(value="vo") MerchantImagesListSearchVO var1);
}

