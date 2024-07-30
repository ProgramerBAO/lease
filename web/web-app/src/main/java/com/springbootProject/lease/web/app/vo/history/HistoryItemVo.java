package com.springbootProject.lease.web.app.vo.history;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.BrowsingHistory;
import com.springbootProject.lease.model.entity.GraphInfo;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "浏览历史实体")
public class HistoryItemVo extends BrowsingHistory {
    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "租金")
    private BigDecimal rent;

    @Schema(description = "房间图片列表")
    private List<GraphInfo> graphInfoList;

    @Schema(description = "公寓名称")
    private String apartmentName;

    @Schema(description = "省份名称")
    private String provinceName;

    @Schema(description = "城市名称")
    private String cityName;

    @Schema(description = "区县名称")
    private String districtName;

}
