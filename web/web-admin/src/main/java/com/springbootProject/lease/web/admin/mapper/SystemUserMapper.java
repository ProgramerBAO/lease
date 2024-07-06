package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.SystemUser;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserItemVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserQueryVo;

/**
* @author BobShen
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {


    IPage<SystemUserItemVo> getPageListByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUser selectOneByUsername(String usename);
}




