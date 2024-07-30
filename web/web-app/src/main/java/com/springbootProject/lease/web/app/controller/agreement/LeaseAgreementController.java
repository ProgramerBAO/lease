package com.springbootProject.lease.web.app.controller.agreement;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.model.entity.PaymentType;
import com.springbootProject.lease.model.enums.LeaseStatus;
import com.springbootProject.lease.web.app.service.LeaseAgreementService;
import com.springbootProject.lease.web.app.service.LeaseTermService;
import com.springbootProject.lease.web.app.service.PaymentTypeService;
import com.springbootProject.lease.web.app.vo.agreement.AgreementDetailVo;
import com.springbootProject.lease.web.app.vo.agreement.AgreementItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "租约管理")
@RestController
@RequestMapping("/app/agreement")
public class LeaseAgreementController {
    @Resource
    private LeaseTermService leaseTermService;
    @Resource
    private LeaseAgreementService leaseAgreementService;
    @Resource
    private PaymentTypeService paymentTypeService;



    @Operation(summary = "获取个人租约基本信息列表")
    @GetMapping("listItem")
    public Result<List<AgreementItemVo>> listItem(){
        List<AgreementItemVo> agreementItemVoList=leaseAgreementService.listAgreeVoByPhone(LoginUserHolder.getLoginUser().getUsername());
        return Result.ok(agreementItemVoList);
    }

    @Operation(summary = "根据Id获取租约详情")
    @GetMapping("getDetailById")
    public Result<AgreementDetailVo> getDetailById(@RequestParam Long id){
        AgreementDetailVo agreementDetailVo=leaseAgreementService.getAgreementDetailById(id);
        return Result.ok(agreementDetailVo);
    }

    @Operation(summary = "根据id更新租约状态")
    @GetMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus status){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(LeaseAgreement::getStatus,status);
        updateWrapper.eq(LeaseAgreement::getId,id);
        leaseAgreementService.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "保存或更新租约",description = "用于续约")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement){
        leaseAgreementService.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }

    @Operation(summary = "根据房间Id获取可选支付方式")
    @GetMapping("listPaymentByRoomId")
    public Result<List<PaymentType>> listPayment(@RequestParam Long id){
        List<PaymentType> paymentTypeList=paymentTypeService.listPaymentByRoomId(id);
        return Result.ok(paymentTypeList);
    }

    @Operation(summary = "根据id获取可选租期")
    @GetMapping("listTermByRoomId")
    public Result<List<LeaseTerm>> listTerm(@RequestParam Long id){
        List<LeaseTerm> leaseTermList=leaseTermService.listTermByRoomId(id);
        return Result.ok(leaseTermList);
    }
}
