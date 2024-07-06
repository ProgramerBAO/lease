package com.springbootProject.lease.web.admin.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "公寓信息")
// 继承ApartmentInfo 即使是一张被连表查询出来的表也有主次之分
public class ApartmentSubmitVo extends ApartmentInfo {
    @Schema(description = "公寓配套ID列表")
    private List<Long> facilityInfoIds;

    @Schema(description = "公寓标签ID列表")
    private List<Long> labelIds;

    @Schema(description = "公寓杂费值ID列表")
    private List<Long> feeValueIds;

    @Schema(description = "公寓图片列表")
    private List<GraphVo> graphVoList;

}
