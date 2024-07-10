package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.enums.ReleaseStatus;
import com.springbootProject.lease.web.admin.service.ApartmentInfoService;
import com.springbootProject.lease.web.admin.vo.ApartmentItemVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "公寓信息管理")
@RequestMapping("/admin/apartment")
@RestController
public class ApartmentController {

    @Resource
    private ApartmentInfoService apartmentInfoService;

    @Operation(summary = "保存或更新公寓信息")
    @PostMapping("saveOrUpdate")
    @Transactional
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        apartmentInfoService.saveOrUpdateApartment(apartmentSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "根据条件分页查询公寓列表")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current,
                                                   @RequestParam long size,
                                                   @ParameterObject ApartmentQueryVo apartmentQueryVo) {
        IPage<ApartmentItemVo> page = new Page<>(current, size); // 创建分页对象
        // apartmentQueryVo 更像是一种查询条件
        IPage<ApartmentItemVo> result = apartmentInfoService.pageApartmentListByQuery(page, apartmentQueryVo);
        return Result.ok(result);
    }

    @Operation(summary = "根据ID获取公寓详细信息")
    @GetMapping("getDetailById/{id}")
    @Transactional
    public Result<ApartmentDetailVo> getDetailById(@PathVariable(required = true) Long id) {
        ApartmentDetailVo apartmentDetailVo = apartmentInfoService.getApartmentDetailById(id);
        return Result.ok(apartmentDetailVo);
    }

    @Operation(summary = "根据ID删除公寓信息")
    @DeleteMapping("removeById/{id}")
    public Result removeById(@PathVariable(required = true) Long id) {
        apartmentInfoService.removeApartmentById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID修改公寓发布状态")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        LambdaUpdateWrapper<ApartmentInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(ApartmentInfo::getIsRelease, status);
        lambdaUpdateWrapper.eq(ApartmentInfo::getId, id);
        apartmentInfoService.update(lambdaUpdateWrapper);
        return Result.ok();
    }

    @Operation(summary = "根据区县ID查询公寓信息列表")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        LambdaQueryWrapper<ApartmentInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ApartmentInfo::getDistrictId, id);
        List<ApartmentInfo> list = apartmentInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }

}
