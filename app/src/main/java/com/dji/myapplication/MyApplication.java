package com.dji.myapplication;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        com.secneo.sdk.Helper.install(this);
    }
}