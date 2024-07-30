package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
* @author 86183
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    List<AgreementItemVo> listAgreeVoByPhone(String username);
}




