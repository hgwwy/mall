package com.young.generator.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.young.common.enums.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Users", description = "用户实体")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private UserSexEnum sex;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "0 正常  1 删除")
    @TableField("del_flag")
    @TableLogic
    private Boolean delFlag;

    @TableField("birthday")
    private Date birthday;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_time")
    private Date updateTime;

    @TableField("update_by")
    private Long updateBy;
}