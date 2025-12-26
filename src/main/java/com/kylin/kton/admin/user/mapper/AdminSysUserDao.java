/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.user.mapper;

import com.kylin.kton.common.core.domain.entity.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSysUserDao {
    @Select(value={"<script> SELECT * FROM sys_user    WHERE 1 = 1  <when test='vo.phonenumber!=null'> AND phonenumber = #{vo.phonenumber} </when> <when test='vo.userName!=null'> AND user_name= #{vo.userName} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> <when test='vo.nickName!=null'> AND nick_name = #{vo.nickName} </when> AND user_id not in (SELECT id FROM kton_merchant )</script>"})
    public List<SysUser> withOutMerchantList(@Param(value="vo") SysUser var1);

    @Select(value={"<script> SELECT * FROM sys_user    WHERE 1 = 1  <when test='vo.phonenumber!=null'> AND phonenumber = #{vo.phonenumber} </when> <when test='vo.userName!=null'> AND user_name= #{vo.userName} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> <when test='vo.nickName!=null'> AND nick_name = #{vo.nickName} </when> AND user_id not in (SELECT id FROM kton_source )</script>"})
    public List<SysUser> withOutSourceList(@Param(value="vo") SysUser var1);
}

