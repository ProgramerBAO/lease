package com.springbootProject.lease.web.admin.mapper;

import com.springbootProject.lease.model.entity.LabelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 86183
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2024-06-15 17:14:56
* @Entity LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

     List<LabelInfo> selectListByRoomId(Long id) ;
}




