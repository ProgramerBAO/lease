package com.springbootProject.lease.web.app.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.FacilityInfo;
import com.springbootProject.lease.model.entity.GraphInfo;
import com.springbootProject.lease.model.entity.LabelInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "App端公寓信息详情")
public class ApartmentDetailVo extends ApartmentInfo implements Serializable {
    @Schema(description = "配套信息列表")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "图片信息列表")
    private List<GraphInfo> graphInfoList;

    @Schema(description = "标签信息列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "租金最小值")
    private BigDecimal minRent;
}
