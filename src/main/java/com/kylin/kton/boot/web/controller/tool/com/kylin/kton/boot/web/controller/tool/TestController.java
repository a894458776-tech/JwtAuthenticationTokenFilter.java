package com.kylin.kton.boot.web.controller.tool.com.kylin.kton.boot.web.controller.tool;

import com.kylin.kton.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api("用户信息管理")
@RestController
@RequestMapping("/test/user")
public class TestController {
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<>();

    static {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public AjaxResult userList() {
        List<UserEntity> userList = new ArrayList<>(users.values());
        return AjaxResult.success(userList);
    }

    @ApiOperation("获取用户详细")
    @GetMapping("/{userId}")
    public AjaxResult getUser(@PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            // 修复：显式强转为 Object，避免编译器泛型推断钻牛角尖
            return AjaxResult.success((Object) users.get(userId));
        } else {
            return AjaxResult.error("用户不存在");
        }
    }

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public AjaxResult save(UserEntity user) {
        if (user == null || user.getUserId() == null) {
            return AjaxResult.error("用户ID不能为空");
        }
        users.put(user.getUserId(), user);
        return AjaxResult.success();
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public AjaxResult update(UserEntity user) {
        if (user == null || user.getUserId() == null) {
            return AjaxResult.error("用户ID不能为空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId())) {
            return AjaxResult.error("用户不存在");
        }
        users.remove(user.getUserId());
        users.put(user.getUserId(), user);
        return AjaxResult.success();
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/{userId}")
    public AjaxResult delete(@PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            users.remove(userId);
            return AjaxResult.success();
        } else {
            return AjaxResult.error("用户不存在");
        }
    }
}

class UserEntity {
    private Integer userId;
    private String username;
    private String password;
    private String mobile;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String username, String password, String mobile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}