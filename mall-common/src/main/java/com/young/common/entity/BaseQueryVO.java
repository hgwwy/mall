package com.young.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BaseQueryVO", description = "通用查询实体")
public class BaseQueryVO {

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 0;

    @ApiModelProperty(value = "条数")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "开始创建时间")
    private String createdTimeS;

    @ApiModelProperty(value = "结束创建时间")
    private String createdTimeE;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;
}
