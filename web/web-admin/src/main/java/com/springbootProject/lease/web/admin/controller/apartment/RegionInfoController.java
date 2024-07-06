package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.CityInfo;
import com.springbootProject.lease.model.entity.DistrictInfo;
import com.springbootProject.lease.model.entity.ProvinceInfo;
import com.springbootProject.lease.web.admin.service.CityInfoService;
import com.springbootProject.lease.web.admin.service.DistrictInfoService;
import com.springbootProject.lease.web.admin.service.ProvinceInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/region")
@Tag(name="地区信息管理")
public class RegionInfoController {

    @Resource
    private ProvinceInfoService provinceInfoService;
    @Resource
    private CityInfoService cityInfoService;
    @Resource
    private DistrictInfoService districtInfoService;


    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince(){
        List<ProvinceInfo> list = provinceInfoService.list();
        return Result.ok(list);
    }

    @Operation(summary = "根据省份ID查询城市信息列表")
    @GetMapping("city/listByProvinceId/{provinceId}")
    public Result<List<CityInfo>> listByProvinceId(@PathVariable(required = true) Long provinceId){
        LambdaQueryWrapper<CityInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CityInfo::getProvinceId,provinceId);
        List<CityInfo> list = cityInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "根据城市ID查询区县信息列表")
    @GetMapping("districe/listByCityId/{cityId}")
    public Result<List<DistrictInfo>> listByCityId(@PathVariable(required = true) Long cityId){
        LambdaQueryWrapper<DistrictInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DistrictInfo::getCityId,cityId);
        List<DistrictInfo> list = districtInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }
}
