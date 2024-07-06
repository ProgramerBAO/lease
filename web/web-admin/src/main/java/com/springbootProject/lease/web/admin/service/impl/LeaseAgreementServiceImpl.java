package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.admin.mapper.*;
import com.springbootProject.lease.web.admin.service.LeaseAgreementService;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.springbootProject.lease.web.admin.vo.agreement.AgreementVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



/**
* @author 86183
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService {

    @Resource
    private LeaseAgreementMapper leaseAgreementMapper;
    @Resource
    private RoomInfoMapper roomInfoMapper;
    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;
    @Resource
    private LeaseTermMapper leaseTermMapper;
    @Resource
    private PaymentTypeMapper paymentTypeMapper;

    @Override
    public IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo) {
        return leaseAgreementMapper.pageAgreementByQuery(page,queryVo);
    }

    @Override
    public AgreementVo getAgreementById(Long id) {
        //1.查询租约基本信息
        LeaseAgreement leaseAgreement = leaseAgreementMapper.selectById(id);

        //2.查询租约房间信息
        RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreement.getRoomId());
        //3.查询租约公寓信息
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(leaseAgreement.getApartmentId());
        //4.查询租约租期信息
        LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreement.getLeaseTermId());
        //5.查询租约支付类型信息
        PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreement.getPaymentTypeId());

        AgreementVo agreementVo = new AgreementVo();
        BeanUtils.copyProperties(leaseAgreement,agreementVo);
        agreementVo.setApartmentInfo(apartmentInfo);//设置公寓信息
        agreementVo.setRoomInfo(roomInfo);//设置房间信息
        agreementVo.setLeaseTerm(leaseTerm);//设置租期信息
        agreementVo.setPaymentType(paymentType);//设置支付类型信息
        return agreementVo;
    }
}




