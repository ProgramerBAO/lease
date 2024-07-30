package com.springbootProject.lease.web.app.controller.appointment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.app.service.ViewAppointmentService;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentDetailVo;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentVo;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name = "预约看房")
@RestController
@RequestMapping("/app/appointment")
public class ViewAppointmentController {
    @Resource
    private ViewAppointmentService viewAppointmentService;

    @Operation(summary = "查询个人预约看房列表")
    @GetMapping("listItem")
    public Result<List<ViewAppointmentVo>> listItem(){
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        List<ViewAppointmentVo> list=viewAppointmentService.listAppointmentByUserId(userId);
        return Result.ok(list);
    }


    @Operation(summary = "保存或更新看房预约")
    @PostMapping("saveOrUpdate")
    public Result saveOrupdate(@RequestBody ViewAppointment viewAppointment){
        viewAppointment.setUserId(LoginUserHolder.getLoginUser().getUserId());
        viewAppointmentService.saveOrUpdate(viewAppointment);
        return Result.ok();
    }


    @Operation(summary = "根据id查询预约详情信息")
    @GetMapping("getDetailById")
    public Result<ViewAppointmentDetailVo> getAppointmentDetail(Long id){
        ViewAppointmentDetailVo viewAppointmentDetailVo=viewAppointmentService.getAppointmentDetailById(id);
        return Result.ok(viewAppointmentDetailVo);
    }

}
