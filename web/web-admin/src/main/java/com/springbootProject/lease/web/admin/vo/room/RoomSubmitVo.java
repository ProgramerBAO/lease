package com.springbootProject.lease.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;

import java.util.List;

@Data
@Schema(description = "房间信息提交实体")
public class RoomSubmitVo extends RoomInfo {
    //1.房间租期列表
    @Schema(description = "房间租期列表")
    private List<Long> roomLeaseTermIds;
    //2.房间支付方式列表
    @Schema(description = "房间支付方式列表")
    private List<Long> roomPaymentTypeIds;
    //3.房间属性列表
    @Schema(description = "房间属性列表")
    private List<Long> roomAttrValueIds;
    //4.房间标签列表
    @Schema(description = "房间标签列表")
    private List<Long> roomLabelIds;
    //5.房间配套列表
    @Schema(description = "房间配套列表")
    private List<Long> roomFacilityIds;
    //6.房间图片列表
    @Schema(description = "房间图片列表")
    private List<GraphVo> graphVoList;
}
