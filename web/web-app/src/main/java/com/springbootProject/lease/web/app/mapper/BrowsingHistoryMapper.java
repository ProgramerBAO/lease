package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.BrowsingHistory;
import com.springbootProject.lease.web.app.vo.history.HistoryItemVo;

/**
* @author BobShen
* @description 针对表【browsing_history(浏览历史)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.BrowsingHistory
*/
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId);
}




