package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.FeeValue;
import com.springbootProject.lease.web.app.vo.feevalue.FeeValueVo;

import java.util.List;

public interface FeeValueMapper extends BaseMapper<FeeValue> {
    List<FeeValueVo> getFeeValueByRoomId(Long id);
}
