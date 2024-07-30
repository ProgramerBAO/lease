package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.web.app.mapper.LeaseTermMapper;
import com.springbootProject.lease.web.app.service.LeaseTermService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper,LeaseTerm> implements LeaseTermService {
    @Resource
    private LeaseTermMapper leaseTermMapper;


    @Override
    public List<LeaseTerm> listTermByRoomId(Long id) {
        return leaseTermMapper.getLeaseTermByRoomId(id);
    }
}
