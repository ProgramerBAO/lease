package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.LeaseTerm;

import java.util.List;

/**
* @author 86183
* @description 针对表【lease_term(租期)】的数据库操作Mapper
* @createDate 2024-06-15 17:14:56
* @Entity LeaseTerm
*/
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    List<LeaseTerm> getLeaseTermByRoomId(Long id);
}




