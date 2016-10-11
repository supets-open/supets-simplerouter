package com.supets.pet.router.router;

import android.net.Uri;
import android.os.Bundle;

import com.supets.pet.router.activity.BaseActivity;
import com.supets.pet.supetsrouter.config.AppModuleRouterUriImpl;
import com.supets.pet.supetsrouter.config.AppModuleUriData;
import com.supets.pet.supetsrouter.config.ConfigUri;
import com.supets.pet.supetsrouter.utils.NavigationUriData;
import com.supets.pet.supetsrouter.utils.OnUriDataListener;
import com.supets.pet.supetsrouter.utils.UINavigation;


/**
 * @ 自定义URL 统一调度到本地接口，和LocalUINavigation
 * @ 自定义URL 设置到具体的Activity上面
 */
public class LocalURIReceiverActivity extends BaseActivity implements OnUriDataListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        if (isSchema(uri) && ConfigUri.module_app.equals(ConfigUri.schema + uri.getHost())) {
            String function = UINavigation.parseDataString(getIntent(), ConfigUri.module_data_key);
            AppModuleUriData navigationUriData = new AppModuleUriData(function);
            navigationUriData.setOnUriDataListener(this);
            navigationUriData.execate();
        }
        finish();
    }

    private boolean isSchema(Uri uri) {
        if (uri != null) {
            String scheme = uri.getScheme();
            if (scheme != null && scheme.equals(ConfigUri.host)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onUriData(NavigationUriData data) {

        if (AppModuleUriData.module_app_orderlist.equals(data.functionName)) {
            LocalUINavigation.startOrderListActivity(this,data.functionData);
        }
        if (AppModuleUriData.module_app_joinus.equals(data.functionName)) {
            AppModuleRouterUriImpl.jumpToJoinus();
        }
    }
}
