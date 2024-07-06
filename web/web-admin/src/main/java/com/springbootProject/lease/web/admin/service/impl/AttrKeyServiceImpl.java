package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.AttrKey;
import com.springbootProject.lease.web.admin.mapper.AttrKeyMapper;
import com.springbootProject.lease.web.admin.service.AttrKeyService;
import com.springbootProject.lease.web.admin.vo.attr.AttrKeyVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86183
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

    @Resource
    private AttrKeyMapper attrKeyMapper; // 因为我们要使用mapper中的方法，所以需要注入 mybatis-plus不支持连表查询

    @Override
    public List<AttrKeyVo> listAttrInfo() {
        return attrKeyMapper.listAttrInfo();
    }
}




