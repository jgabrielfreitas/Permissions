package com.jgabrielfreitas.permissions.core.application;

import android.app.Application;

import com.karumi.dexter.Dexter;

/**
 * Created by JGabrielFreitas on 09/06/16.
 */
public class CorePermissionsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Dexter.initialize(this);
    }
}
