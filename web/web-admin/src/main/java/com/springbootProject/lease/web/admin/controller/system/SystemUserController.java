package com.springbootProject.lease.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.SystemUser;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.web.admin.service.SystemUserService;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserItemVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserQueryVo;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin/system/user")
@Tag(name = "后台用户管理")
public class SystemUserController {
    @Resource
    private SystemUserService systemUserService;
    //1.根据条件分页查询用户信息
    @GetMapping("getPageList")
    @Operation(summary = "分页查询用户信息")
    public Result<IPage<SystemUserItemVo>> getPageList(@RequestParam Integer current,
                                                       @RequestParam Integer size,
                                                       @ParameterObject SystemUserQueryVo queryVo) {
        IPage<SystemUser> page = new Page<>(current, size);
        IPage<SystemUserItemVo> list=systemUserService.getPageListByQuery(page,queryVo);
        return Result.ok(list);
    }
    //2.根据ID查询后台用户信息
    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getSystemUserById/{id}")
    public Result<SystemUserItemVo> getSystemUserById(@PathVariable Long id) {
        SystemUserItemVo user = systemUserService.getSystemUserById(id);
        return Result.ok(user);
    }
    //3.保存或更新后台用户信息
    @Operation(summary = "保存或更新用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser){
        //密码加密
        if(systemUser.getPassword()!=null){
            systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword()));
        }
        systemUserService.saveOrUpdate(systemUser);
        return Result.ok();
    }
    //4.判断后台用户名是否可用
    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUsernameExists")
    public Result isUsernameExists(@RequestParam String username){
        LambdaQueryWrapper<SystemUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SystemUser::getUsername,username);
        long count = systemUserService.count(lambdaQueryWrapper);
        return Result.ok(count==0);
    }
    //5.根据ID删除后台用户信息
    @Operation(summary = "根据Id删除后台用户信息")
    @DeleteMapping("deleteSystemUserById/{id}")
    public Result deleteSystemUserById(@PathVariable Long id){
        systemUserService.removeById(id);
        return Result.ok();
    }
    //6.根据ID修改后台用户状态
    @Operation(summary = "根据ID修改后台用户的状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam BaseStatus status,@RequestParam Long id){
        LambdaUpdateWrapper<SystemUser> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(SystemUser::getId,id);
        lambdaUpdateWrapper.set(SystemUser::getStatus,status);
        systemUserService.update(lambdaUpdateWrapper);
        return Result.ok();
    }
}
