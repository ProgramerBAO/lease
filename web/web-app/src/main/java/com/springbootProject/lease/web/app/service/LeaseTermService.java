package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.LeaseTerm;

import java.util.List;

public interface LeaseTermService extends IService<LeaseTerm> {
    List<LeaseTerm> listTermByRoomId(Long id);
}
