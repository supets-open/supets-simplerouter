package com.supets.pet.router.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.supets.pet.supetsrouter.model.NavigationStack;
import com.supets.pet.supetsrouter.utils.UINavigation;

/**
 * router
 *
 * @user lihongjiang
 * @description
 * @date 2016/10/8
 * @updatetime 2016/10/8
 */

public class BaseActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count++;
        NavigationStack  mBackStack = UINavigation.parseNavigationBackStack(getIntent());
        String name=mBackStack!=null?mBackStack.getClassType().getSimpleName():"  ";
        NavigationStack  mBackStack2 = UINavigation.parseNavigationStartStack(getIntent());
        String name2=mBackStack2!=null?mBackStack2.getClassType().getSimpleName():"  ";
        Toast.makeText(this, "BackStack--> " + name+"  StartStack--> " + name2, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "onNewIntent" + count++, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "onActivityResult" + count++, Toast.LENGTH_SHORT).show();
    }
}
