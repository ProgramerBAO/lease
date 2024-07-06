package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.LabelInfo;
import com.springbootProject.lease.model.enums.ItemType;
import com.springbootProject.lease.web.admin.service.LabelInfoService;
import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;  这个注解错了
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "标签管理")
@RequestMapping("/admin/label")
@RestController
public class LabelController {
    @Resource
    private LabelInfoService labelInfoService; // 标签信息 主要是为了获取标签实体

    @Operation(summary = "(根据类型)查询标签列表")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type){
        LambdaQueryWrapper<LabelInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(type!=null,LabelInfo::getType,type);
        List<LabelInfo> list = labelInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "新增或修改标签信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LabelInfo labelInfo){
        System.out.println(labelInfo);
        labelInfoService.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "根据id删除标签信息")
    @DeleteMapping("deleteById")
    public Result deleteById(@RequestParam Long id){
        labelInfoService.removeById(id);
        return Result.ok();
    }
}
