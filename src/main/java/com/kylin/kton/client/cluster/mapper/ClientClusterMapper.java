/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.client.cluster.mapper;

import com.kylin.kton.client.cluster.entity.dto.ClusterDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterHostDTO;
import com.kylin.kton.client.cluster.entity.dto.ClusterTemplateDTO;
import com.kylin.kton.client.cluster.entity.vo.ClusterListSearchVO;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientClusterMapper {
    @Select(value={"<script>select h.*  from kton_cluster h  where h.id IN (SELECT cluster_id FROM kton_cluster_host_template) <if test='vo.continent != null'> and h.continent = #{vo.continent}</if><if test='vo.countryCode != null'> and h.country_code = #{vo.countryCode}</if><if test='vo.city != null'> and h.city = #{vo.city}</if><if test='vo.clusterType != null'> and h.cluster_type = #{vo.clusterType}</if> order by h.id desc</script>"})
    public List<ClusterDTO> clusterList(@Param(value="vo") ClusterListSearchVO var1);

    @Select(value={"<script>select cpt.*,cpt.ref_id as templateId  from kton_cluster_host_template cpt where 1 = 1 and  cpt.price_monthly  &gt; 0  <if test='clusterId != null'> and cpt.cluster_id = #{clusterId}</if><if test='templateId != null'> and cpt.ref_id = #{templateId}</if> order by cpt.id desc</script>"})
    public List<ClusterTemplateDTO> templateList(@Param(value="clusterId") Long var1, @Param(value="templateId") String var2);

    @Select(value={"<script>select cpt.* from kton_cluster_host_template cpt where 1 = 1 and  cpt.price_monthly  &gt; 0  <if test='templateId != null'> and cpt.ref_id = #{templateId}</if> LIMIT 1 ", "</script>"})
    public KtonClusterHostTemplate getByRefId(@Param(value="templateId") String var1);

    @Select(value={"<script>select cpt.* from kton_cluster_host_template cpt  where 1 = 1 and  cpt.price_monthly  &gt; 0  <if test='templateId != null'> and cpt.id = #{templateId}</if></script>"})
    public ClusterTemplateDTO getById(@Param(value="templateId") Long var1);

    @Select(value={"<script>SELECT   host.*,   COUNT(ip_pool.status) AS countIp FROM kton_vps_host AS host LEFT JOIN kton_vps_ip_pool AS ip_pool    ON host.id = ip_pool.host_id    AND ip_pool.status = 0 WHERE host.cluster_id = 6 GROUP BY host.id HAVING COUNT(ip_pool.status) > 0; </script>"})
    public List<ClusterHostDTO> clusterHostList(@Param(value="clusterId") Long var1);
}

