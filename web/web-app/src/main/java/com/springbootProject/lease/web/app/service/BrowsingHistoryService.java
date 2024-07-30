package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.BrowsingHistory;
import com.springbootProject.lease.web.app.vo.history.HistoryItemVo;

/**
* @author 86183
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {

    IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId);

    void saveHistory(Long userId, Long id);
}
