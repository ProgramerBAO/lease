package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.web.app.vo.agreement.AgreementDetailVo;
import com.springbootProject.lease.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    List<AgreementItemVo> listAgreeVoByPhone(String username);

    AgreementDetailVo getAgreementDetailById(Long id);
}
