package com.supets.pet.supetsrouter.config;


import com.supets.pet.supetsrouter.utils.RouterParam;
import com.supets.pet.supetsrouter.utils.RouterUri;

public interface BaseModuleRouterUri {

    /**
     * web页面跳转
     **/
    @RouterUri(routerUri = ConfigUri.web)
    void jumpToWeb(@RouterParam("url") String url);

}

