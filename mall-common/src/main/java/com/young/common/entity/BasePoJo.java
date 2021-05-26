package com.young.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePoJo implements Serializable {
    public final static String DEFAULT_USERNAME = "system";
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableLogic
    private Boolean delFlag;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}