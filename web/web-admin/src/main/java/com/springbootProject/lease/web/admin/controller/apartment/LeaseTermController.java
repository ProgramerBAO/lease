package com.springbootProject.lease.web.admin.controller.apartment;

import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.web.admin.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "租期管理")
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {
    
    @Resource
    private LeaseTermService leaseTermService;


    @Operation(summary = "查询全部租期列表")
    @GetMapping("list")
    public Result<List<LeaseTerm>> listLeaseTerm(){
        //Page<LeaseTerm> page = new Page<>(1, 10);
        List<LeaseTerm> list = leaseTermService.list(); // 查询全部
        return Result.ok(list);
    }

    @Operation(summary = "保存或更新租期信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseTerm leaseTerm){
        leaseTermService.saveOrUpdate(leaseTerm);
        return Result.ok();
    }

    @Operation(summary = "根据id删除租期")
    @DeleteMapping("deleteById/{id}")
    public Result DeleteById(@PathVariable Long id){
        leaseTermService.removeById(id);
        return Result.ok();
    }
}
