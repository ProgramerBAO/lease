package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.FeeKey;
import com.springbootProject.lease.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

public interface FeeKeyService extends IService<FeeKey> {
    List<FeeKeyVo> feeInfoList();
}
