package com.springbootProject.lease.web.app.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.GraphInfo;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.web.app.vo.graph.GraphVo;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "租约详细信息")
public class AgreementDetailVo extends LeaseAgreement {

    @Schema(description = "租约id")
    private Long id;

    @Schema(description = "公寓名称")
    private String apartmentName;

    @Schema(description = "公寓图片列表")
    private List<GraphInfo> apartmentgraphVoList;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "房间图片列表")
    private List<GraphVo> roomgraphVoList;

    @Schema(description = "支付方式名称")
    private String paymentTypeName;

    @Schema(description = "租期月数")
    private Integer leaseTermMonthCount;

    @Schema(description = "租期单位")
    private String leaseTermUnit;
}
