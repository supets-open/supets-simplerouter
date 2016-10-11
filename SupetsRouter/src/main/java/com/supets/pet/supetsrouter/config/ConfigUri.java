package com.supets.pet.supetsrouter.config;

public interface ConfigUri {

    String host = "supets";
    String schema = "supets://";

    String main = schema + "main";//APP首页
    String productDetail = schema + "productDetail";//商品详情页
    String special = schema + "special";//专题详情页
    String logisticTrace = schema + "logisticTrace";//订单物流跟踪页
    String orderList = schema + "orderList";//订单列表页
    String serviceTerm = schema + "serviceTerm";//服务条款
    String joinUs = schema + "joinus";//了解疯狂桔子
    String helpCenter = schema + "helpCenter";//帮助中心
    String shoppingCategory = schema + "shoppingCategory";//商城分类页

    //webview导航
    String web = schema + "web";//web页面跳转
    //module导航
    String module_app = schema + "module_app";//app模块功能导航
    String module_data_key = "function";//app模块功能导航


}
