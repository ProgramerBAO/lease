package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.FeeKey;
import com.springbootProject.lease.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

public interface FeekeyMapper extends BaseMapper<FeeKey> {
    List<FeeKeyVo> feeInfoList();
}
