/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.One
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 */
package com.kylin.kton.admin.vps.mapper;

import com.kylin.kton.admin.vps.entity.vo.QueryVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.SourceInfoVO;
import com.kylin.kton.admin.vps.entity.vo.UpdateVpsStatusVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostContainerVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VpsHostContainerMapper {
    @Select(value={"<script>select hc.*, h.continent, h.country_code, h.city, h.host_ip,c.cluster_name   from kton_vps_host_container hc join kton_vps_host h on hc.host_id = h.id left join kton_cluster as c on hc.cluster_id = c.id  where 1=1<if test='p.hostId != null'> and hc.host_id = #{p.hostId}</if><if test='p.clusterId != null'> and hc.cluster_id = #{p.clusterId}</if><if test='p.merchantId != null'> and hc.merchant_id = #{p.merchantId}</if><if test='p.sshAccount != null'> and hc.ssh_account = #{p.sshAccount}</if><if test='p.sshPort != null'> and hc.ssh_port = #{p.sshPort}</if><if test='p.containerId != null'> and hc.container_id = #{p.containerId}</if><if test='p.status != null'> and hc.status = #{p.status}</if><if test='p.type != null'> and hc.type = #{p.type}</if><if test='p.vpsIp != null'> and hc.vps_ip LIKE CONCAT('%', #{p.vpsIp}, '%')</if><if test='p.beginDate != null'> and hc.expire_date &gt;= #{p.beginDate}</if><if test='p.endDate != null'> and hc.expire_date &lt;= #{p.endDate}</if> order by hc.id desc</script>"})
    @Results(value={@Result(column="merchant_id", property="merchantId"), @Result(column="host_id", property="hostId"), @Result(column="host_id", property="sourceInfo", one=@One(select="selectSourceInfo"))})
    public List<VpsHostContainerVO> queryVpsHostContainer(@Param(value="p") QueryVpsHostContainerVO var1);

    @Update(value={"<script>update kton_vps_host_container set status = #{p.status} where id = #{p.id}</script>"})
    public Integer updateVpsContainerStatus(@Param(value="p") UpdateVpsStatusVO var1);

    @Select(value={"select * from kton_source where id in (SELECT source_id FROM kton_vps_host WHERE id = #{hostId} ) limit 1"})
    public SourceInfoVO selectSourceInfo(@Param(value="hostId") Long var1);
}

