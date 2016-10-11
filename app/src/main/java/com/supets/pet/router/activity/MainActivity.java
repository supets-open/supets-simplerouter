package com.supets.pet.router.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.supets.pet.router.R;
import com.supets.pet.supetsrouter.config.AppModuleRouterUriImpl;
import com.supets.pet.supetsrouter.config.AppModuleUriData;
import com.supets.pet.supetsrouter.config.ConfigUri;
import com.supets.pet.supetsrouter.utils.UINavigation;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mTextView = (TextView) findViewById(R.id.test);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

        mTextView.setText(R.string.test);

        //直接调用
        AppModuleRouterUriImpl.jumpToHelpCenter();

        UINavigation.pushUri(this, "supets://main");
        UINavigation.pushUri(this,"http://www.baidu.com");

        String routerJson=new AppModuleUriData(
                AppModuleUriData.module_app_orderlist,getString(R.string.test2)).toString();

        AppModuleRouterUriImpl.jumpToModule_App_function(routerJson);

        UINavigation. pushUri(this, ConfigUri.module_app+"?"+ ConfigUri.module_data_key +"="+routerJson);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            Intent intent = new Intent(this, StandLandActivity.class);
            UINavigation.setNavigationStartStack(getIntent(),intent,this);
            UINavigation.pushStandard(this, intent);
        }
        if (v.getId() == R.id.btn1) {
            Intent intent = new Intent(this, SingleTaskActivity.class);
            UINavigation.pushStandard(this, intent);
        }
        if (v.getId() == R.id.btn2) {
            Intent intent = new Intent(this, SingleInstanceActivity.class);
            UINavigation.pushStandard(this, intent);
        }
        if (v.getId() == R.id.btn3) {
            Intent intent = new Intent(this, SingleTopActivity.class);
            UINavigation.pushStandard(this, intent);
        }
        if (v.getId() == R.id.btn4) {
            Intent intent = new Intent(this, CleanTopActivity.class);
            UINavigation.pushStandard(this, intent);
        }
    }


}
