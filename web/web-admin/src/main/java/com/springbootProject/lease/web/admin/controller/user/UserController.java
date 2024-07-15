package com.springbootProject.lease.web.admin.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.UserInfo;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.web.admin.service.UserInfoService;
import com.springbootProject.lease.web.admin.vo.user.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;


@Tag(name = "用户管理")
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @Operation(summary = "根据条件分页查询用户信息")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserByQuery(@RequestParam Long current,
                                                   @RequestParam Long size,
                                                   @ParameterObject UserInfoQueryVo queryVo) {
        Page<UserInfo> page = new Page<>(current, size);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(queryVo.getPhone() != null, UserInfo::getPhone, queryVo.getPhone());
        queryWrapper.eq(queryVo.getStatus() != null, UserInfo::getStatus, queryVo.getStatus());
        IPage<UserInfo> list = userInfoService.page(page, queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "根据Id修改用户状态")
    @PutMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id,
                                   @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInfo::getId, id).set(UserInfo::getStatus, status);
        userInfoService.update(updateWrapper);
        return Result.ok();
    }
}
