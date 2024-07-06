package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 浏览历史
 * @TableName browsing_history
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="browsing_history")
@Data
public class BrowsingHistory extends BaseEntity {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 浏览房间id
     */
    private Long roomId;

    /**
     * 
     */
    private Date browseTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}