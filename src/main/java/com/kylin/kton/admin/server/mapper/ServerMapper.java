package com.kylin.kton.admin.server.mapper;

import com.kylin.kton.admin.server.domain.SysServer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ServerMapper {
    @Select("SELECT id, name, ip, port, token, country_code as countryCode, location, status " +
            "FROM sys_server WHERE status = '1' ORDER BY id DESC")
    List<SysServer> selectServerList();

    @Select("SELECT * FROM sys_server WHERE ip = #{ip} LIMIT 1")
    SysServer selectServerByIp(String ip);

    // ⭐ 新增：根据 ID 查服务器
    @Select("SELECT * FROM sys_server WHERE id = #{id}")
    SysServer selectServerById(Long id);
}