package com.app;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by archirayan on 13-Apr-17.
 */

public class PreSchooler extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
    }
}
