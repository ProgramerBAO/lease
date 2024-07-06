package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.FeeValue;
import com.springbootProject.lease.web.admin.mapper.FeeValueMapper;
import com.springbootProject.lease.web.admin.service.FeeValueService;
import org.springframework.stereotype.Service;

@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue> implements FeeValueService {
}
