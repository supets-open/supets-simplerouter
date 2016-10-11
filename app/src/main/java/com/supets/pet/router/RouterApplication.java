package com.supets.pet.router;

import android.app.Application;

import com.supets.pet.supetsrouter.utils.LocalHostRouter;

public class RouterApplication  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        LocalHostRouter.register(this);
    }
}
