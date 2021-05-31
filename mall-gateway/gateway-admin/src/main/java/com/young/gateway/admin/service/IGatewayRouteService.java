package com.young.gateway.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.young.gateway.admin.entity.GatewayRoute;
import com.young.gateway.admin.vo.GatewayRouteQueryVo;
import com.young.gateway.admin.vo.GatewayRouteVo;

import java.util.List;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 服务类
 */
public interface IGatewayRouteService extends IService<GatewayRoute> {

    /**
     * 获取网关路由
     *
     * @param id
     * @return
     */
    GatewayRoute get(String id);

    /**
     * 新增网关路由
     *
     * @param gatewayRoute
     * @return
     */
    boolean add(GatewayRoute gatewayRoute);

    /**
     * 查询网关路由
     *
     * @return
     */
    List<GatewayRouteVo> query(GatewayRouteQueryVo gatewayRouteQueryVo);

    /**
     * 更新网关路由信息
     *
     * @param gatewayRoute
     */
    boolean update(GatewayRoute gatewayRoute);

    /**
     * 根据id删除网关路由
     *
     * @param id
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     *
     * @return 成功返回true
     */
    boolean overload();

}
