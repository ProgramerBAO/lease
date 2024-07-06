package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 公寓信息表
 * @TableName apartment_info
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "公寓信息表")
@TableName(value ="apartment_info")
@Data
public class ApartmentInfo extends BaseEntity {
    /**
     * 公寓名称
     */
    @Schema(description = "公寓名称")
    private String name;

    /**
     * 公寓介绍
     */
    @Schema(description = "公寓介绍")
    private String introduction;

    /**
     * 所处区域id
     */
    @Schema(description = "所处区域id")
    private Long districtId;

    /**
     * 区域名称
     */
    @Schema(description = "所处区域名称")
    private String districtName;

    /**
     * 所处城市id
     */
    @Schema(description = "所处城市id")
    private Long cityId;

    /**
     * 城市名称
     */
    @Schema(description = "所处城市名称")
    private String cityName;

    /**
     * 所处省份id
     */
    @Schema(description = "所处省份id")
    private Long provinceId;

    /**
     * 省份名称
     */
    @Schema(description = "所处省份名称")
    private String provinceName;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String addressDetail;

    /**
     * 经度
     */
    @Schema(description = "经度")
    private String latitude;

    /**
     * 纬度
     */
    @Schema(description = "纬度")
    private String longitude;

    /**
     * 公寓前台电话
     */
    @Schema(description = "公寓前台电话")
    private String phone;

    /**
     * 是否发布（1:发布，0:未发布）
     */
    @Schema(description = "是否发布（1:发布，0:未发布）")
    private Integer isRelease;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}