package com.springbootProject.lease.web.app.vo.room;

import lombok.Data;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;
import com.springbootProject.lease.web.app.vo.attrvalue.AttrValueVo;
import com.springbootProject.lease.web.app.vo.feevalue.FeeValueVo;
import com.springbootProject.lease.web.app.vo.graph.GraphVo;

import java.io.Serializable;
import java.util.List;

@Data
public class RoomDetailVo extends RoomInfo implements Serializable {
    //1.房间基本信息 从父类继承

    //2.房间所属公寓信息
    private ApartmentItemVo apartmentItemVo;
    //3.房间租期信息
    private List<LeaseTerm> leaseTermList;
    //4.房间支付类型信息
    private List<PaymentType> paymentTypeList;
    //5.房间属性值信息
    private List<AttrValueVo> attrValueVoList;
    //6.房间标签信息
    private List<LabelInfo> labelInfoList;
    //7.房间配套信息
    private List<FacilityInfo> facilityInfoList;
    //8.房间图片信息
    private List<GraphVo> graphVoList;
    //9.杂费列表
    private List<FeeValueVo> feeValueVoList;
}
