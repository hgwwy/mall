package com.young.gateway.admin.vo;

import com.young.common.entity.BaseQueryVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRouteQueryVo extends BaseQueryVO {
    private String uri;
}
