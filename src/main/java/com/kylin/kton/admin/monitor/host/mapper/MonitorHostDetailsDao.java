/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMonitorHostDetails
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.monitor.host.mapper;

import com.kylin.kton.admin.monitor.host.entity.vo.MonitorHostDetailsSearchVO;
import com.kylin.kton.system.domain.KtonMonitorHostDetails;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorHostDetailsDao {
    @Select(value={"<script> SELECT *  FROM kton_monitor_host_details as a WHERE 1 = 1  <when test='vo.hostIp!=null'> AND a.host_ip = #{vo.hostIp} </when> ORDER BY a.create_time DESC</script>"})
    public List<KtonMonitorHostDetails> list(@Param(value="vo") MonitorHostDetailsSearchVO var1);
}

