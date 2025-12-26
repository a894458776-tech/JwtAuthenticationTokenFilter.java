/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMessageRecords
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.system.domain.KtonMessageRecords;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskMessageRecordMapper {
    @Select(value={"<script>", "SELECT DISTINCT source_id", "FROM kton_message_records", "WHERE source_id IN", "<foreach collection='merchantIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>", "AND message_type = #{messageType}", "</script>"})
    public List<Long> findMerchantIdsWithNotificationType(@Param(value="merchantIds") List<Long> var1, @Param(value="messageType") String var2);

    @Insert(value={"<script>", "INSERT INTO kton_message_records", "(content, source_id, message_type, create_time)", "VALUES (#{content}, #{sourceId}, #{messageType},  #{createTime})", "</script>"})
    public int insertMessageRecord(KtonMessageRecords var1);

    @Select(value={"<script>", "SELECT DISTINCT CAST(source_id AS SIGNED) AS merchantId ", "FROM kton_message_records ", "WHERE source_id IN ", "  <foreach collection=\"merchantIds\" item=\"id\" open=\"(\" separator=\",\" close=\")\">", "    #{id}", "  </foreach>", "AND message_type = #{messageType}", "AND create_time >= #{threeDaysAgo}", "</script>"})
    public List<Long> findMerchantIdsWithRecentNotification(@Param(value="merchantIds") List<Long> var1, @Param(value="messageType") String var2, @Param(value="threeDaysAgo") Date var3);
}

