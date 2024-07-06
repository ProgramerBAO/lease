package com.springbootProject.lease.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.SystemPost;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.web.admin.service.SystemPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin/system/post")
@Tag(name = "后台用户岗位")
public class SystemPostController {
    @Resource
    private SystemPostService systemPostService;
    //1. 分页查询岗位信息
    @GetMapping("getPageList")
    @Operation(summary = "分页查询岗位信息")
    public Result<IPage<SystemPost>> getPageList(@RequestParam Integer current, @RequestParam Integer size){
        IPage<SystemPost> page=new Page<>(current,size);
        IPage<SystemPost> list=systemPostService.page(page);
        return Result.ok(list);
    }
    //2. 保存或更新岗位信息
    @PostMapping("saveOrUpdate")
    @Operation(summary = "保存或更新岗位信息")
    public Result<SystemPost> saveOrUpdate(@RequestBody  SystemPost systemPost){
        systemPostService.saveOrUpdate(systemPost);
        return Result.ok();
    }
    //3. 根据ID删除岗位信息
    @Operation(summary = "根据ID删除岗位信息")
    @DeleteMapping("deleteById")
    public Result<SystemPost> deleteById(@RequestParam Long id){
        systemPostService.removeById(id);
        return Result.ok();
    }
    //4. 获取全部岗位列表
    @GetMapping("getAllList")
    @Operation(summary = "获取全部岗位列表")
    public Result<List<SystemPost>> getAllList(){
        List<SystemPost> list = systemPostService.list();
        return Result.ok(list);
    }
    //5. 根据ID获取岗位信息
    @GetMapping("getById")
    @Operation(summary = "根据ID获取岗位信息")
    public Result<SystemPost> getById(@RequestParam Long id){
        SystemPost systemPost = systemPostService.getById(id);
        return Result.ok(systemPost);
    }
    //6. 根据ID修改岗位状态
    @GetMapping("updateStatusById")
    @Operation(summary = "根据ID修改岗位状态")
    public Result<SystemPost> updateStatusById(@RequestParam Long id,@RequestParam BaseStatus status){
        LambdaUpdateWrapper<SystemPost> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SystemPost::getId,id).set(SystemPost::getStatus,status);
        systemPostService.update(updateWrapper);
        return Result.ok();
    }
}
