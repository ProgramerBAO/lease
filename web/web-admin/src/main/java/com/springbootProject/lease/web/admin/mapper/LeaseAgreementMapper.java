package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementVo;

/**
* @author 86183
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




