package com.kylin.kton.admin.server.domain;

import lombok.Data;
import java.util.Date;

/**
 * 服务器节点实体
 */
@Data
public class SysServer {
    private Long id;
    private String name;
    private String ip;
    private Integer port;
    private String token;
    private String countryCode;
    private String location;
    private String status;
    private Date createTime;
}