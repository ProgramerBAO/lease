package com.springbootProject.lease.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;

import java.util.List;

@Schema(description = "房间详情展示实体")
@Data
public class RoomDetailVo extends RoomInfo {
    @Schema(description = "所属公寓信息")
    private ApartmentInfo apartmentInfo;

    //房间租期列表
    @Schema(description = "房间租期列表")
    private List<LeaseTerm> leaseTermList;

    //房间付款方式列表
    @Schema(description = "房间付款方式列表")
    private List<PaymentType> paymentTypeList;

    //房间属性列表
    @Schema(description = "房间属性列表")
    private List<AttrValueVo> roomAttrValueList;

    //房间标签列表
    @Schema(description = "房间标签列表")
    private List<LabelInfo> roomLabelList;

    //房间配套列表
    @Schema(description = "房间配套列表")
    private List<FacilityInfo> facilityInfoList;

    //房间图片列表
    @Schema(description = "房间图片列表")
    private List<GraphVo> graphInfoList;

}
