package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.AttrKey;
import com.springbootProject.lease.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author 86183
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.AttrKey
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}




