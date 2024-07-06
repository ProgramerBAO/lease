package com.springbootProject.lease.web.admin.controller.lease;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.model.enums.LeaseStatus;
import com.springbootProject.lease.web.admin.service.LeaseAgreementService;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementVo;
import jakarta.annotation.Resource;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin/agreement")
@Tag(name = "租赁协议管理")
public class LeaseAgreementController {

    @Resource
    private LeaseAgreementService leaseAgreementService;

    //1.根据条件分页查询租赁协议
    @Operation(summary = "根据条件分页查询租赁协议")
    @GetMapping("page")
    public Result<IPage<AgreementVo>> page(@Schema(description = "当前页") Long current,
                                           @Schema(description = "每页大小") Long size,
                                           @Schema(description = "查询条件") @ParameterObject AgreementQueryVo queryVo) {
        IPage<AgreementVo> page = new Page<>(current,size);
        IPage<AgreementVo> result=leaseAgreementService.pageAgreementByQuery(page, queryVo);
        return Result.ok(result);
    }

    //2.根据Id删除租赁协议
    @Operation(summary = "根据Id删除租赁协议")
    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@Schema(description = "协议Id") @PathVariable(required = true) Long id) {
        LeaseAgreement leaseAgreement = leaseAgreementService.getById(id);
        LeaseStatus status = leaseAgreement.getStatus();
        if (status.getCode().equals(1)) {//1
            return Result.fail(500,"尚未退租不能删除");
        }else if(status.getCode().equals(2)){//2
            return Result.fail(500,"尚未退租不能删除");
        }else if(status.getCode().equals(4)){//4
            return Result.fail(500,"尚未退租不能删除");
        }else if(status.getCode().equals(5)){//5
            return Result.fail(500,"尚未退租不能删除");
        }else if(status.getCode().equals(7)){//7
            return Result.fail(500,"尚未退租不能删除");
        }else{
            leaseAgreementService.removeById(id);
            return Result.ok();
        }
    }

    //3.根据Id查询租赁协议
    @Operation(summary = "根据Id查询租赁协议")
    @GetMapping("getById/{id}")
    public Result<AgreementVo> getById(@Schema(description = "协议Id") @PathVariable Long id) {
        AgreementVo agreementVo=leaseAgreementService.getAgreementById(id);
        return Result.ok(agreementVo);
    }
    //4.保存或新增租赁协
    @Operation(summary = "保存或新增租赁协议")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@Schema(description = "协议对象") @RequestBody LeaseAgreement leaseAgreement) {
        leaseAgreementService.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }
    //5.根据Id更新租赁协议状态
    @Operation(summary = "根据Id更新租赁协议状态")
    @PutMapping("updateStatusById")
    public Result updateStatusById(@Schema(description = "协议Id") @RequestParam Long id, @Schema(description = "协议状态") @RequestParam LeaseStatus status) {
        LambdaUpdateWrapper<LeaseAgreement> leaseAgreementLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        leaseAgreementLambdaUpdateWrapper.set(LeaseAgreement::getStatus, status).eq(LeaseAgreement::getId, id);
        leaseAgreementService.update(leaseAgreementLambdaUpdateWrapper);
        return Result.ok();
    }

}
