/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.vps.mapper;

import com.kylin.kton.admin.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VpsHostMapper {
    @Select(value={"<script>select hc.*,c.cluster_name  from kton_vps_host hc left  join kton_cluster c on hc.cluster_id = c.id where 1=1<if test='vo.clusterId != null'> and hc.cluster_id = #{vo.clusterId}</if><if test='vo.continent != null'> and h.continent = #{vo.continent}</if><if test='vo.countryCode != null'> and h.country_code = #{vo.countryCode}</if><if test='vo.city != null'> and h.city = #{vo.city}</if> order by hc.id desc</script>"})
    public List<VpsHostDTO> list(@Param(value="vo") VpsHostSearchVO var1);

    @Select(value={"<script>select count(*) FROM kton_vps_host WHERE  host_ip like concat('%', #{ipPre}, '%')  </script>"})
    public Integer checkIpEixit(@Param(value="ipPre") String var1);
}

