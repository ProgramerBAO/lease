package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.FeeKey;
import com.springbootProject.lease.web.admin.mapper.FeekeyMapper;
import com.springbootProject.lease.web.admin.service.FeeKeyService;
import com.springbootProject.lease.web.admin.vo.fee.FeeKeyVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeekeyMapper, FeeKey> implements FeeKeyService {
    @Resource
    private FeekeyMapper feekeyMapper;


    @Override
    public List<FeeKeyVo> feeInfoList() {
        return feekeyMapper.feeInfoList();
    }
}
