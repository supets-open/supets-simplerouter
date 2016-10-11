package com.supets.pet.supetsrouter.config;

import com.supets.pet.supetsrouter.utils.RouterParam;
import com.supets.pet.supetsrouter.utils.RouterUri;

public interface AppModuleRouterUri  {


    @RouterUri(routerUri = ConfigUri.main)
    String jumpToMain();

    /**
     * 商品详情页
     **/
    @RouterUri(routerUri = ConfigUri.productDetail)
    String jumpToProductDetail(@RouterParam("id") String id);

    /**
     * 专题详情页
     *
     * @param id
     **/
    @RouterUri(routerUri = ConfigUri.special)
    String jumpToSpecial(@RouterParam("id") String id);

    /**
     * 订单物流跟踪页
     **/
    @RouterUri(routerUri = ConfigUri.logisticTrace)
    String jumpToLogisticTrace(@RouterParam("id") String id);

    /**
     * 订单列表页
     **/
    @RouterUri(routerUri = ConfigUri.orderList)
    String jumpToOrderList();

    /**
     * 服务条款
     **/
    @RouterUri(routerUri = ConfigUri.serviceTerm)
    String jumpToServiceTerm();

    /**
     * 了解疯狂桔子
     **/
    @RouterUri(routerUri = ConfigUri.joinUs)
    void jumpToJoinus();

    /**
     * 帮助中心
     **/
    @RouterUri(routerUri = ConfigUri.helpCenter)
    String jumpToHelpCenter();

    /**
     * 商城分类页
     **/
    @RouterUri(routerUri = ConfigUri.shoppingCategory)
    String jumpToShoppingCategory(@RouterParam("id") String id);

    /**
     * app模块功能导航
     **/
    @RouterUri(routerUri = ConfigUri.module_app)
    void jumpToModule_App_function(@RouterParam( ConfigUri.module_data_key) String function);

}
