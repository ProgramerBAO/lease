package com.springbootProject.lease.web.app.vo.graph;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "图片信息")
public class GraphVo implements Serializable {
    @Schema(description = "图片名称")
    private String name;

    @Schema(description = "图片名称")
    private String url;
}
