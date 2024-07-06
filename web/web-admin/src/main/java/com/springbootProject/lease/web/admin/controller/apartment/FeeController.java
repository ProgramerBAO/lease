package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.FeeKey;
import com.springbootProject.lease.model.entity.FeeValue;
import com.springbootProject.lease.web.admin.service.FeeKeyService;
import com.springbootProject.lease.web.admin.service.FeeValueService;
import com.springbootProject.lease.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间杂费管理")
@RequestMapping("/admin/fee")
@RestController
public class FeeController {
    @Resource
    private FeeKeyService feeKeyService;
    @Resource
    private FeeValueService feeValueService;

    @Operation(summary = "保存或更新杂费名称")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey){
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }
    @Operation(summary = "保存或更新杂费值")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue){
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }
    @Operation(summary = "查询全部杂费名称和杂费值列表")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList(){ // FeeKeyVo 继承 FeeKey 和 FeeValue 连表查询
        List<FeeKeyVo> list=feeKeyService.feeInfoList();
        return Result.ok(list);
    }
    @Operation(summary = "根据ID删除杂费名称")
    @DeleteMapping("key/deleteById/{id}")
    @Transactional // 增加事务
    public Result deleteFeeKeyById(@PathVariable Long id){
        feeKeyService.removeById(id);
        LambdaQueryWrapper<FeeValue> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FeeValue::getFeeKeyId,id);
        feeValueService.remove(lambdaQueryWrapper);
        return Result.ok();
    }
    @Operation(summary = "根据ID删除杂费值")
    @DeleteMapping("value/deleteById/{id}")
    public Result deleteFeeValueById(@PathVariable Long id){
        feeValueService.removeById(id);
        return Result.ok();
    }
}
