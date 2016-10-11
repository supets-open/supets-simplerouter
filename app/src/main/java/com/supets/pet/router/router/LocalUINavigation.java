package com.supets.pet.router.router;

import android.content.Context;
import android.content.Intent;

import com.supets.pet.router.activity.CleanTopActivity;
import com.supets.pet.supetsrouter.utils.UINavigation;

public class LocalUINavigation {

    public static void startOrderListActivity(Context context,String data) {
        Intent intent = new Intent(context, CleanTopActivity.class);
        intent.putExtra("id",data);
        UINavigation.pushCleanTop(context, intent);
    }

    private static void startWebViewActivity(Context context, String uri) {
        Intent intent = new Intent(context, LocalWebViewActivity.class);
        intent.putExtra("url", uri);
        UINavigation.pushStandard(context, intent);
    }

}
