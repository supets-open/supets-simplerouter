package com.supets.pet.supetsrouter.config;

import com.supets.pet.supetsrouter.utils.NavigationUriData;
//定义模块---功能页面
public class AppModuleUriData extends NavigationUriData {

    public static final String module_app_orderlist = "module_app_orderlist";
    public static final String module_app_joinus = "module_app_joinus";

    public AppModuleUriData(String functionName, String functionData) {
        super(functionName, functionData);
    }

    public AppModuleUriData(String json) {
        super(json);
    }
}
