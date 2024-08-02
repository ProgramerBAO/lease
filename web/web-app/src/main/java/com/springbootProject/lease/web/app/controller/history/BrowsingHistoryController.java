package com.springbootProject.lease.web.app.controller.history;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.app.service.BrowsingHistoryService;
import com.springbootProject.lease.web.app.vo.history.HistoryItemVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

@Tag(name = "用户浏览历史")
@RestController
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    @Resource
    private BrowsingHistoryService browsingHistoryService;

    @Operation(summary = "分页查询用户浏览历史")
    @GetMapping("pageItemRoom")
    public Result<IPage<HistoryItemVo>> pageItemRoom(@RequestParam Long current, @RequestParam Long size){
        IPage<HistoryItemVo> page=new Page<>(current,size); // 创建分页对象
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        IPage<HistoryItemVo> historyItemVoIPage=browsingHistoryService.pageHistoryItemByUserId(page,userId);
        return Result.ok(historyItemVoIPage);
    }
}
