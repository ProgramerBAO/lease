package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementVo;

/**
* @author 86183
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}
