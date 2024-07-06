package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.web.admin.mapper.LeaseTermMapper;
import com.springbootProject.lease.web.admin.service.LeaseTermService;
import org.springframework.stereotype.Service;

@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper,LeaseTerm> implements LeaseTermService {

}
