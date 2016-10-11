package com.supets.pet.supetsrouter.config;

import com.supets.pet.supetsrouter.utils.LocalHostRouter;

public class BaseModuleRouterUriImpl {

    private static BaseModuleRouterUri mIRouterUri = LocalHostRouter.getInstance().create(BaseModuleRouterUri.class);

    //URL统一导航
    public static void jumpToWeb(String url) {
        mIRouterUri.jumpToWeb(url);
    }

}
