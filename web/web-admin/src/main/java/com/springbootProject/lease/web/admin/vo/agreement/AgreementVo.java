package com.springbootProject.lease.web.admin.vo.agreement;

import lombok.Data;
import com.springbootProject.lease.model.entity.*;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AgreementVo extends LeaseAgreement {
    // 1.租期信息
    private LeaseTerm leaseTerm;
    // 2.支付方式信息
    private PaymentType paymentType;
    // 3.签约房间信息
    private RoomInfo roomInfo;
    // 4.签约公寓信息
    private ApartmentInfo apartmentInfo;
}
