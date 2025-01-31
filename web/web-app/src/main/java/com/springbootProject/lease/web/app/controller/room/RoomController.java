package com.springbootProject.lease.web.app.controller.room;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.app.service.RoomInfoService;
import com.springbootProject.lease.web.app.vo.room.RoomDetailVo;
import com.springbootProject.lease.web.app.vo.room.RoomItemVo;
import com.springbootProject.lease.web.app.vo.room.RoomQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "房间信息")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Resource
    private RoomInfoService roomInfoService;

    @Operation(summary = "根据条件分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam Long current, @RequestParam Long size,@ParameterObject RoomQueryVo queryVo){
        IPage<RoomItemVo> page=new Page<>(current,size);
        IPage<RoomItemVo> result=roomInfoService.pageRoomItemByQuery(page,queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "根据id查询房间详情")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id){
        RoomDetailVo result=roomInfoService.getRoomDetailById(id);
        return Result.ok(result);
    }

    @Operation(summary = "根据公寓id分页查询房间列表")
    @GetMapping("pageItemByApartmentId")
    public Result<IPage<RoomItemVo>> pageItemByApartmentId(@RequestParam Long current,
           @RequestParam Long size,@RequestParam Long apartmentId){
        IPage<RoomItemVo> page=new Page<>(current,size);
        IPage<RoomItemVo> list=roomInfoService.pageRoomItemByApartmentId(page,apartmentId);
        return Result.ok(list);
    }

}





























