package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.SystemUser;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserItemVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserQueryVo;

/**
* @author 86183
* @description 针对表【system_user(员工信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:28
*/
public interface SystemUserService extends IService<SystemUser> {

    IPage<SystemUserItemVo> getPageListByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getSystemUserById(Long id);
}
