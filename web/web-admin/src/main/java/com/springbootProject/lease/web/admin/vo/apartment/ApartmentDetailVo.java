package com.springbootProject.lease.web.admin.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.FacilityInfo;
import com.springbootProject.lease.model.entity.LabelInfo;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;

import java.util.List;

@Data
@Schema(description = "公寓信息")
public class ApartmentDetailVo extends ApartmentInfo {
    @Schema(description = "图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "标签列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "配套列表")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "杂费列表")
    private List<FeeValueVo> feeValueVoList;
}
