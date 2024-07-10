package com.springbootProject.lease.web.admin.controller.lease;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.model.enums.AppointmentStatus;
import com.springbootProject.lease.web.admin.service.ViewAppointmentService;
import com.springbootProject.lease.web.admin.vo.appointment.AppointmentVo;
import com.springbootProject.lease.web.admin.vo.lease.AppointmentQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/appointment")
@Tag(name = "预约看房管理")
public class ViewAppointmentController {
    @Resource
    private ViewAppointmentService viewAppointmentService;

    @Operation(summary = "根据条件分页查询预约信息")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam Long current,
                                             @RequestParam Long size,
                                             @ParameterObject AppointmentQueryVo queryVo) {
        IPage<AppointmentVo> page = new Page<>(current, size);
        IPage<AppointmentVo> result = viewAppointmentService.pageAppointmentByQuery(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "根据Id更新预约状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        LambdaUpdateWrapper<ViewAppointment> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ViewAppointment::getId, id).set(ViewAppointment::getAppointmentStatus, status);
        viewAppointmentService.update(wrapper);
        return Result.ok();
    }
}
