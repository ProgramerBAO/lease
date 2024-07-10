package com.springbootProject.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.model.entity.RoomInfo;
import com.springbootProject.lease.model.enums.LeaseStatus;
import com.springbootProject.lease.model.enums.ReleaseStatus;
import com.springbootProject.lease.web.admin.service.RoomInfoService;
import com.springbootProject.lease.web.admin.vo.room.RoomDetailVo;
import com.springbootProject.lease.web.admin.vo.room.RoomItemVo;
import com.springbootProject.lease.web.admin.vo.room.RoomQueryVo;
import com.springbootProject.lease.web.admin.vo.room.RoomSubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间信息管理")
@RestController
@RequestMapping("/admin/room")
public class RoomController {
    @Resource
    private RoomInfoService roomInfoService;
    //1.保存或更新房间信息
    @Operation(summary = "保存或更新房间信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody  RoomSubmitVo roomSubmitVo) {
        roomInfoService.saveOrUpdateRoom(roomSubmitVo);
        return Result.ok();
    }
    //2.根据条件分页查询房间列表
    @Operation(summary = "根据条件分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam Long current, @RequestParam Long size,@ParameterObject RoomQueryVo roomQueryVo) {
        IPage<RoomItemVo> page=new Page<>(current,size);
        IPage<RoomItemVo> result=roomInfoService.pageRoomItemByQuery(page,roomQueryVo);
        return Result.ok(result);
    }
    //3.根据ID获取房间详细信息
    @Operation(summary = "根据ID获取房间详细信息")
    @GetMapping("getDetailById/{id}")
    public Result<RoomDetailVo> getDetailById(@PathVariable Long id){
        RoomDetailVo result = roomInfoService.getRoomDetailById(id);
        return Result.ok(result);
    }
    //4.根据ID删除房间信息
    @Operation(summary = "根据ID删除房间信息")
    @GetMapping("removeById/{id}")
    public Result removeById(@PathVariable(required = true) Long id) {
        roomInfoService.removeRoomById(id);
        return Result.ok();
    }
    //5.根据ID修改房间发布状态
    @Operation(summary = "根据ID修改房间发布状态")
    @GetMapping("updateReleaseById/{id}/{isRelease}")
    public Result updateReleaseById(@PathVariable(required = true) Long id,@PathVariable(required = true) LeaseStatus isRelease) {
        LambdaUpdateWrapper<RoomInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(RoomInfo::getId,id);
        lambdaUpdateWrapper.set(RoomInfo::getIsRelease, isRelease);
        roomInfoService.update(lambdaUpdateWrapper);
        return Result.ok();
    }
    //6.根据公寓ID查询房间信息列表
    @Operation(summary = "根据公寓ID查询房间信息列表")
    @GetMapping("listBasicByApartmentId")
    public Result<List<RoomInfo>> listBasicByApartmentId(@RequestParam Long id) {
        LambdaQueryWrapper<RoomInfo> roomInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomInfoLambdaQueryWrapper.eq(RoomInfo::getApartmentId,id);
        roomInfoLambdaQueryWrapper.eq(RoomInfo::getIsRelease, ReleaseStatus.RELEASED);
        List<RoomInfo> result=roomInfoService.list(roomInfoLambdaQueryWrapper);
        return Result.ok(result);
    }
}
