package com.supets.pet.supetsrouter.config;

import com.supets.pet.supetsrouter.utils.LocalHostRouter;

public class AppModuleRouterUriImpl {

    private static AppModuleRouterUri mIRouterUri = LocalHostRouter.getInstance().create(AppModuleRouterUri.class);

    public static String jumpToMain() {
        return mIRouterUri.jumpToMain();
    }

    public static String jumpToProductDetail(String id) {
        return mIRouterUri.jumpToProductDetail(id);
    }

    public static String jumpToSpecial(String id) {
        return mIRouterUri.jumpToSpecial(id);
    }

    public static String jumpToLogisticTrace(String id) {
        return mIRouterUri.jumpToLogisticTrace(id);
    }

    public static String jumpToOrderList() {
        return mIRouterUri.jumpToOrderList();
    }

    public static String jumpToServiceTerm() {
        return mIRouterUri.jumpToServiceTerm();
    }

    public static void jumpToJoinus() {
        mIRouterUri.jumpToJoinus();
    }

    public static String jumpToHelpCenter() {
        return mIRouterUri.jumpToHelpCenter();
    }

    public static String jumpToShoppingCategory(String id) {
        return mIRouterUri.jumpToShoppingCategory(id);
    }

    //app模块自定义URI导航UI界面.
    public static void jumpToModule_App_function(String request) {
        mIRouterUri.jumpToModule_App_function(request);
    }
}
