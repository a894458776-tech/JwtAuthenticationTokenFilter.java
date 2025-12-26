/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  com.kylin.kton.system.domain.KtonSource
 *  com.kylin.kton.system.mapper.KtonIpStaticSourceMapper
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.One
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticSourceDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticSourceSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminWithOutPoolSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.mapper.KtonIpStaticSourceMapper;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpStaticSourceDao
extends KtonIpStaticSourceMapper {
    @Select(value={"<script> SELECT *   FROM kton_ip_static_source  WHERE 1 = 1   <when test='vo.sourceId!=null'> AND source_id = #{vo.sourceId} </when> <when test='vo.ip!=null'> AND ip like concat('%', #{vo.ip}, '%') </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> ORDER BY id DESC</script>"})
    @Results(value={@Result(column="source_id", property="sourceId"), @Result(column="sourceId", property="sourceInfo", one=@One(select="selectSourceInfo"))})
    public List<AdminIpStaticSourceDTO> list(@Param(value="vo") AdminIpStaticSourceSearchVO var1);

    @Select(value={"<script> SELECT *   FROM kton_ip_static_source  WHERE 1 = 1   <when test='vo.sourceId!=null'> AND source_id = #{vo.sourceId} </when> <when test='vo.ip!=null'> AND ip like concat('%', #{vo.ip}, '%') </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> <when test='vo.poolId!=null'>  AND ip not in (SELECT ip FROM kton_ip_static_pool_item where pool_id = #{vo.poolId}  )</when> ORDER BY id DESC</script>"})
    @Results(value={@Result(column="source_id", property="sourceId"), @Result(column="sourceId", property="sourceInfo", one=@One(select="selectSourceInfo"))})
    public List<AdminIpStaticSourceDTO> withOutPoolList(@Param(value="vo") AdminWithOutPoolSearchVO var1);

    @Select(value={"select * from kton_source where id  = #{sourceId}  limit 1"})
    public KtonSource selectSourceInfo(@Param(value="sourceId") Long var1);

    @Select(value={"select * from kton_source where source_code  = #{sourceCode}  limit 1"})
    public KtonSource getBySourceCode(@Param(value="sourceCode") String var1);

    @Select(value={"<script> SELECT *  FROM kton_ip_static_source   WHERE ip = #{ip}    LIMIT 1  </script>"})
    public KtonIpStaticSource selectByIp(@Param(value="ip") String var1);

    @Update(value={"<script> UPDATE kton_ip_static_source  SET status = #{status},     update_time = NOW() WHERE ip = #{ip} </script>"})
    public void updateStatus(@Param(value="ip") String var1, @Param(value="status") Integer var2);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = assign_times + 1 ", "WHERE ip = #{ip} "})
    public int incrementAssignTimes(String var1);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = GREATEST(0, assign_times - 1) ", "WHERE ip = #{ip} AND assign_times > 0"})
    public int subtAssignTimes(String var1);

    @Insert(value={"<script>", "INSERT INTO kton_ip_static_source", "(source_id, ip, port, account, password, protocolse, effective_datetime, expire_datetime, create_time)", "VALUES", "<foreach collection='list' item='item' separator=','>", "(#{item.sourceId}, #{item.ip}, #{item.port}, #{item.account}, #{item.password}, #{item.protocolse}, ", "#{item.effectiveDatetime}, #{item.expireDatetime}, #{item.createTime})", "</foreach>", "</script>"})
    public int batchInsertKtonIpStaticSources(@Param(value="list") List<KtonIpStaticSource> var1);

    @Update(value={"<script> UPDATE kton_ip_static_source  SET is_exclusive = #{isExclusive},     update_time = NOW() WHERE ip = #{ip} </script>"})
    public void updateExclusiveStatus(@Param(value="ip") String var1, @Param(value="isExclusive") Long var2);
}

