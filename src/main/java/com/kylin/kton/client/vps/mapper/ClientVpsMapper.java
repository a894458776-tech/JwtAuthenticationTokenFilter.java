/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsImages
 *  com.kylin.kton.system.domain.KtonVpsIpPool
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.client.vps.entity.dto.ContainerParamListDTO;
import com.kylin.kton.client.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.client.vps.entity.dto.VpsHostPerformanceDTO;
import com.kylin.kton.client.vps.entity.vo.ClientImagesSearchVO;
import com.kylin.kton.client.vps.entity.vo.ContainerParamListSearchVO;
import com.kylin.kton.client.vps.entity.vo.HostListSearchVO;
import com.kylin.kton.client.vps.entity.vo.PerformanceListSearchVO;
import com.kylin.kton.client.vps.entity.vo.QueryVpsContainer;
import com.kylin.kton.client.vps.entity.vo.UpdateStatusVO;
import com.kylin.kton.client.vps.entity.vo.VpsHostContainerVO;
import com.kylin.kton.system.domain.KtonVpsImages;
import com.kylin.kton.system.domain.KtonVpsIpPool;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClientVpsMapper {
    @Select(value={"<script>select hc.*,h.continent, h.country_code, h.city from kton_vps_host h join kton_vps_host_container hc on h.id = hc.host_id where hc.merchant_id = #{userId}<if test='p.containerId != null'> and hc.container_id = #{p.containerId}</if><if test='p.continent != null'> and h.continent = #{p.continent}</if><if test='p.countryCode != null'> and h.country_code = #{p.countryCode}</if><if test='p.city != null'> and h.city = #{p.city}</if><if test='p.sshAccount != null'> and hc.ssh_account = #{p.sshAccount}</if><if test='p.sshPort != null'> and hc.ssh_port = #{p.sshPort}</if><if test='p.status != null'> and hc.status = #{p.status}</if><if test='p.type != null'> and hc.type = #{p.type}</if><if test='p.beginDate != null'> and hc.expire_date &gt;= #{p.beginDate}</if><if test='p.endDate != null'> and hc.expire_date &lt;= #{p.endDate}</if> order by hc.id desc</script>"})
    public List<VpsHostContainerVO> query(@Param(value="p") QueryVpsContainer var1, @Param(value="userId") Long var2);

    @Select(value={"<script>select hc.*,h.continent, h.country_code, h.city from kton_vps_host h join kton_vps_host_container hc on h.id = hc.host_id where hc.merchant_id = #{userId} and hc.id = #{containerId} </script>"})
    public VpsHostContainerVO containerDetail(@Param(value="containerId") Long var1, @Param(value="userId") Long var2);

    @Select(value={"<script>select h.continent, h.country_code, h.city,h.host_name,h.id  from kton_vps_host h  where h.id IN (SELECT host_id FROM kton_vps_host_config_template) <if test='vo.continent != null'> and h.continent = #{vo.continent}</if><if test='vo.countryCode != null'> and h.country_code = #{vo.countryCode}</if><if test='vo.city != null'> and h.city = #{vo.city}</if> order by h.id desc</script>"})
    public List<VpsHostDTO> hostList(@Param(value="vo") HostListSearchVO var1);

    @Select(value={"<script>select cpt.*   from kton_vps_host_config_template cpt where 1 = 1 and  cpt.price_monthly  &gt; 0  <if test='vo.hostId != null'> and cpt.host_id = #{vo.hostId}</if> order by cpt.id desc</script>"})
    public List<VpsHostPerformanceDTO> performanceList(@Param(value="vo") PerformanceListSearchVO var1);

    @Select(value={"<script>select hcp.*   from kton_vps_host_container_param hcp  where  hcp.container_id = #{vo.containerId}  order by hcp.id desc</script>"})
    public List<ContainerParamListDTO> containerParamList(@Param(value="vo") ContainerParamListSearchVO var1);

    @Update(value={"<script>update kton_vps_host_container set status = #{p.status} where id = #{p.id}</script>"})
    public Integer openStopVps(@Param(value="p") UpdateStatusVO var1);

    @Update(value={"<script>", "UPDATE kton_vps_ip_pool ", "SET status = 1, ", "count_assign = count_assign + 1 ", "WHERE host_id = #{hostId} ", "AND ip = #{ip} ", "AND status = 0 ", "</script>"})
    public int updateStatus(@Param(value="hostId") Long var1, @Param(value="ip") String var2);

    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_ip_pool ", "WHERE cluster_id = #{clusterId} and (merchant_id = #{merchantId} or merchant_id = 0 ) ", "AND status = 0 and id &gt; 0 ORDER BY id asc LIMIT 1 ", "</script>"})
    public KtonVpsIpPool getIp(@Param(value="clusterId") Long var1, @Param(value="merchantId") Long var2);

    @Select(value={"<script>", "SELECT count(*) ", "FROM kton_vps_ip_pool ", "WHERE cluster_id = #{clusterId} and (merchant_id = #{merchantId} or merchant_id = 0 ) ", "AND status = 0 and id &gt; 0 </script>"})
    public int countAvailableIps(@Param(value="clusterId") Long var1, @Param(value="merchantId") Long var2);

    @Update(value={"<script>update kton_vps_host_container set status = #{status} where id = #{id}</script>"})
    public Integer updateContainerStatus(@Param(value="status") Integer var1, @Param(value="id") Long var2);

    @Select(value={"<script>select *  from kton_vps_images   where status = 1 and image_type ='vps-container' and (merchant_id = #{vo.merchantId} or merchant_id = 0 ) <if test='vo.name != null'> and name = #{vo.name}</if><if test='vo.refId != null'> and h.ref_id = #{vo.refId}</if> order by id desc</script>"})
    public List<KtonVpsImages> imagesList(@Param(value="vo") ClientImagesSearchVO var1);
}

