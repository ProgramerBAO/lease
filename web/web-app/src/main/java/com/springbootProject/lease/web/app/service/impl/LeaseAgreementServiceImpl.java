package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.common.exception.LeaseException;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.result.ResultCodeEnum;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.model.entity.PaymentType;
import com.springbootProject.lease.model.entity.RoomInfo;
import com.springbootProject.lease.web.app.mapper.*;
import com.springbootProject.lease.web.app.service.LeaseAgreementService;
import com.springbootProject.lease.web.app.vo.agreement.AgreementDetailVo;
import com.springbootProject.lease.web.app.vo.agreement.AgreementItemVo;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;
import com.springbootProject.lease.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

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
    private ApartmentInfoMapper apartmentInfoMapper;
    @Resource
    private RoomInfoMapper roomInfoMapper;
    @Resource
    private GraphInfoMapper graphInfoMapper;
    @Resource
    private PaymentTypeMapper paymentTypeMapper;
    @Resource
    private LeaseTermMapper leaseTermMapper;

    @Override
    public List<AgreementItemVo> listAgreeVoByPhone(String username) {
        return leaseAgreementMapper.listAgreeVoByPhone(username);
    }

    @Override
    public AgreementDetailVo getAgreementDetailById(Long id) {
        //1.查询租约基本信息
        LambdaQueryWrapper<LeaseAgreement> leaseAgreementLambdaQueryWrapper = new LambdaQueryWrapper<>();
        String phone= LoginUserHolder.getLoginUser().getUsername();
        leaseAgreementLambdaQueryWrapper.eq(LeaseAgreement::getPhone,phone);
        leaseAgreementLambdaQueryWrapper.eq(LeaseAgreement::getId,id);
        LeaseAgreement leaseAgreement = super.getOne(leaseAgreementLambdaQueryWrapper);

        if(leaseAgreement==null){
            throw new LeaseException(ResultCodeEnum.APP_AGREEMNET_ID_IS_INVALID);
        }else {
            //2.查询公寓信息
            ApartmentItemVo apartment = apartmentInfoMapper.getApartmentByRoomId(leaseAgreement.getApartmentId());
            //3.查询房间信息
            RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreement.getRoomId());
            //4.查询图片信息
            List<GraphVo> graphVoList = graphInfoMapper.getGraphByRoomId(leaseAgreement.getRoomId());
            //5.查询支付方式
            PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreement.getPaymentTypeId());
            //6.查询租期
            LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreement.getLeaseTermId());

            AgreementDetailVo agreementDetailVo = new AgreementDetailVo();
            BeanUtils.copyProperties(leaseAgreement,agreementDetailVo);
            agreementDetailVo.setApartmentName(apartment.getName());
            agreementDetailVo.setApartmentgraphVoList(apartment.getGraphVoList());
            agreementDetailVo.setRoomNumber(roomInfo.getRoomNumber());
            agreementDetailVo.setRoomgraphVoList(graphVoList);
            agreementDetailVo.setPaymentTypeName(paymentType.getName());
            agreementDetailVo.setPaymentTypeId(paymentType.getId());
            agreementDetailVo.setLeaseTermMonthCount(leaseTerm.getMonthCount());
            agreementDetailVo.setLeaseTermUnit(leaseTerm.getUnit());
            return agreementDetailVo;
        }
    }
}




