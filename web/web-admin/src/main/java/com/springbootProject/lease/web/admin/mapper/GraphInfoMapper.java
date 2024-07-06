package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.GraphInfo;
import com.springbootProject.lease.model.enums.ItemType;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(Long id, ItemType apartment);

}




