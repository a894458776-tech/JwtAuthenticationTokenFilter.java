package com.kylin.kton.framework.web.service;

import com.kylin.kton.common.core.domain.entity.SysRole;
import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.system.service.ISysMenuService;
import com.kylin.kton.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SysPermissionService {
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    public Set<String> getRolePermission(SysUser user) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            roles.add("admin");
        } else {
            // 修复：添加泛型 List<SysRole>
            List<SysRole> perms = roleService.selectRolesByUserId(user.getUserId());
            for (SysRole perm : perms) {
                // 修复：现在 perm 是 SysRole 类型，可以直接调用 getRoleKey
                roles.add(perm.getRoleKey());
            }
        }
        return roles;
    }

    public Set<String> getMenuPermission(SysUser user) {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            perms.add("*:*:*");
        } else {
            perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
        }
        return perms;
    }
}