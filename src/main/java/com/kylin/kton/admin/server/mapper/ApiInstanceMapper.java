package com.kylin.kton.admin.server.mapper;

import com.kylin.kton.admin.server.domain.SysApiInstance;
import org.apache.ibatis.annotations.*;
import java.util.Date;

@Mapper
public interface ApiInstanceMapper {

    @Insert("INSERT INTO sys_api_instance(merchant_id, server_id, username, password, assigned_ip, expire_time, note, status, create_time) " +
            "VALUES(#{merchantId}, #{serverId}, #{username}, #{password}, #{assignedIp}, #{expireTime}, #{note}, '1', NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertInstance(SysApiInstance instance);

    @Update("UPDATE sys_api_instance SET expire_time = #{newExpireTime} WHERE username = #{username}")
    int renewInstance(@Param("username") String username, @Param("newExpireTime") Date newExpireTime);

    @Update("<script>" +
            "UPDATE sys_api_instance " +
            "<set>" +
            "  <if test='newUsername != null and newUsername != \"\"'>username = #{newUsername},</if>" +
            "  <if test='note != null'>note = #{note},</if>" +
            "  <if test='password != null and password != \"\"'>password = #{password},</if>" +
            "</set>" +
            "WHERE username = #{oldUsername}" +
            "</script>")
    int updateInstanceInfo(@Param("oldUsername") String oldUsername,
                           @Param("newUsername") String newUsername,
                           @Param("password") String password,
                           @Param("note") String note);

    @Update("UPDATE sys_api_instance SET status = '0' WHERE username = #{username}")
    int deleteInstance(@Param("username") String username);

    // ⭐ 新增：根据用户名查找记录 (用于找 ServerID 和 AssignedIP)
    @Select("SELECT * FROM sys_api_instance WHERE username = #{username} LIMIT 1")
    SysApiInstance selectByUsername(String username);
}