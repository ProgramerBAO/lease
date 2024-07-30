package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.BrowsingHistory;
import com.springbootProject.lease.web.app.mapper.BrowsingHistoryMapper;
import com.springbootProject.lease.web.app.service.BrowsingHistoryService;
import com.springbootProject.lease.web.app.vo.history.HistoryItemVo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Date;

/**
* @author 86183
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
    implements BrowsingHistoryService {

    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

    @Override
    public IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId) {

        return browsingHistoryMapper.pageHistoryItmeByUserId(page,userId);
    }
    @Async
    @Override
    public void saveHistory(Long userId, Long id) {
        //1.保存历史前先查询是否有当前房间的浏览历史，如果有，更新查看时间，如果没有，进行插入
        LambdaQueryWrapper<BrowsingHistory> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BrowsingHistory::getUserId,userId);
        lambdaQueryWrapper.eq(BrowsingHistory::getRoomId,id);
        BrowsingHistory browsingHistory = browsingHistoryMapper.selectOne(lambdaQueryWrapper);

        if(browsingHistory==null){//如果没有，进行插入
            BrowsingHistory history = new BrowsingHistory();
            history.setUserId(userId);
            history.setRoomId(id);
            history.setBrowseTime(new Date());
            browsingHistoryMapper.insert(history);
        }else{//如果有，更新查看时间
            browsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.updateById(browsingHistory);
        }
    }
}




