package com.springbootProject.lease.web.app.controller.apartment;

import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.app.service.ApartmentInfoService;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentDetailVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "公寓信息管理")
@RequestMapping("/app/apartment")
@RestController
public class ApartmentController {

    @Resource
    private ApartmentInfoService apartmentInfoService;

    @Operation(summary = "根据ID查询公寓详细信息")
    @GetMapping("getApartmentDetailById")
    public Result<ApartmentDetailVo> getApartmentDetailById(@RequestParam Long id){
        ApartmentDetailVo apartmentDetailVo=apartmentInfoService.getApartmentDetailById(id);
        return Result.ok(apartmentDetailVo);
    }
}
