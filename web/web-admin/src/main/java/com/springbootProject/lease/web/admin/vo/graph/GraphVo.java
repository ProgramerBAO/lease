package com.springbootProject.lease.web.admin.vo.graph;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "图片信息")
public class GraphVo{
    @Schema(description = "图片名称")
    private String name;

    @Schema(description = "图片名称")
    private String url;
}
