package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.AttrKey;
import com.springbootProject.lease.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface AttrKeyService extends IService<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}
