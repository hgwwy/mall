package com.young.gateway.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.young.common.entity.BasePoJo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("gateway_route")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "GatewayRoute", description = "网关路由")
public class GatewayRoute extends BasePoJo {

    @ApiModelProperty("uri路径")
    private String uri;

    @ApiModelProperty("路由id")
    private String routeId;

    @ApiModelProperty("判定器")
    private String predicates;

    @ApiModelProperty("过滤器")
    private String filters;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private Integer orders = 0;

    @ApiModelProperty("状态：Y-有效，N-无效")
    private String status = "Y";

}