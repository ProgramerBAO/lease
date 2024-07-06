package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.LabelInfo;

import java.util.List;

public interface LabelInfoService extends IService<LabelInfo> {
    List<LabelInfo> getLabelInfoByType(int type);
}
