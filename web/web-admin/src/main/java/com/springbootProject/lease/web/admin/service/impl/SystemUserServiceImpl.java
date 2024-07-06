package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.SystemPost;
import com.springbootProject.lease.model.entity.SystemUser;
import com.springbootProject.lease.web.admin.mapper.SystemPostMapper;
import com.springbootProject.lease.web.admin.mapper.SystemUserMapper;
import com.springbootProject.lease.web.admin.service.SystemUserService;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserItemVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserQueryVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



/**
* @author 86183
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Resource
    private SystemPostMapper systemPostMapper;

    @Override
    public IPage<SystemUserItemVo> getPageListByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.getPageListByQuery(page,queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        SystemUser systemUser = super.getById(id);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());

        if (systemUser != null){
            BeanUtils.copyProperties(systemUser,systemUserItemVo);
            systemUserItemVo.setPostName(systemPost.getName());
        }
        return systemUserItemVo;
    }
}




