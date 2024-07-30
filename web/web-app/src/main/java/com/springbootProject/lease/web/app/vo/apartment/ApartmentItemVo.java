package com.springbootProject.lease.web.app.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.GraphInfo;
import com.springbootProject.lease.model.entity.LabelInfo;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentItemVo extends ApartmentInfo implements Serializable {
    @Schema(description = "公寓图片列表")
    private List<GraphInfo> graphVoList;
    @Schema(description = "公寓标签信息列表")
    private List<LabelInfo> labelInfoList;
    @Schema(description = "公寓最小租金")
    private BigDecimal minRent;
}
