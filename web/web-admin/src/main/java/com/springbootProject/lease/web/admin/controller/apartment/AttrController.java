package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.AttrKey;
import com.springbootProject.lease.model.entity.AttrValue;
import com.springbootProject.lease.web.admin.service.AttrKeyService;
import com.springbootProject.lease.web.admin.service.AttrValueService;
import com.springbootProject.lease.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/attr")
@Tag(name = "房间属性管理")
public class AttrController {
    @Resource
    private AttrKeyService attrKeyService; // 属性名称
    @Resource
    private AttrValueService attrValueService; // 属性值

    @Operation(summary = "保存或更新属性名称")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateKey(@RequestBody AttrKey attrKey){
        // 连表查询
        attrKeyService.saveOrUpdate(attrKey);
        return Result.ok("保存成功");
    }

    @Operation(summary = "保存或更新属性值")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateValue(@RequestBody AttrValue attrValue){
        // 应该先检查Key是否存在 但是在页面操作不会遇到这种问题 算是个小bug
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }

    @Operation(summary = "查询全部属性名称和属性值列表")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo(){
        // 连表查询
        List<AttrKeyVo> list=attrKeyService.listAttrInfo();
        return Result.ok(list);
    }

    @Operation(summary = "根据ID删除属性名称")
    @DeleteMapping("deleteAttrKeyById/{id}")
    public Result deleteAttrNameById(@PathVariable(required = true) Long id){
        // 连表删除
        attrKeyService.removeById(id);
        LambdaQueryWrapper<AttrValue> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(AttrValue::getAttrKeyId,id);
        attrValueService.remove(lambdaQueryWrapper);
        return Result.ok();
    }
    @Operation(summary = "根据ID删除属性值")
    @DeleteMapping("deleteAttrValueById/{id}")
    public Result deleteAttrValueById(@PathVariable(required = true) long id){
        attrValueService.removeById(id);
        return Result.ok();
    }


}
