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
* @author BobShen
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

    /**
     * SystemUserItemVo继承了 SystemUser
     * 因此可以直接赋值,我们可以把SystemUser当成SystemUserItemVo的基类
     * 再细化一下 SystemUserItemVo其实就是SystemUser和SystemPost的联合查询结果
     * 所以我们可以先根据用ID查询SystemUser 然后根据SystemUser的postId查询SystemPost
     * 两者结果合并 组成最终结果
     */
    @Override
    public SystemUserItemVo getSystemUserById(Long id) {

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        // SystemUser systemUser = systemUserMapper.selectById(id); 和下面的等价
        SystemUser systemUser = super.getById(id);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());

        // 复制属性
        BeanUtils.copyProperties(systemUser, systemUserItemVo);
        systemUserItemVo.setPostName(systemPost.getName());
        return systemUserItemVo;
    }
}




