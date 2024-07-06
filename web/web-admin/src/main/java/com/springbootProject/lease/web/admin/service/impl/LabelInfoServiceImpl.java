package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.LabelInfo;
import com.springbootProject.lease.web.admin.mapper.LabelInfoMapper;
import com.springbootProject.lease.web.admin.service.LabelInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper,LabelInfo> implements LabelInfoService {
    @Resource
    private LabelInfoMapper labelInfoMapper;

    @Override
    public List<LabelInfo> getLabelInfoByType(int type) {
        QueryWrapper<LabelInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type);
        List<LabelInfo> labelInfos = labelInfoMapper.selectList(queryWrapper);
        return labelInfos;
    }
}
