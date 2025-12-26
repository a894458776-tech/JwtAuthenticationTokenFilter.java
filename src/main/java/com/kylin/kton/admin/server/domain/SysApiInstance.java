package com.kylin.kton.admin.server.domain;

import lombok.Data;
import java.util.Date;

/**
 * API 实例账本实体
 */
@Data
public class SysApiInstance {
    private Long id;
    private Long merchantId;
    private Long serverId;
    private String username;
    private String password;
    private String assignedIp;
    private Date expireTime;
    private String note;
    private String status;
    private Date createTime;
}