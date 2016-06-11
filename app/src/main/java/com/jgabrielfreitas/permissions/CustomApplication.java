package com.jgabrielfreitas.permissions;

import android.util.Log;

import com.jgabrielfreitas.permissions.core.application.CorePermissionsApplication;

/**
 * Created by JGabrielFreitas on 10/06/16.
 */
public class CustomApplication extends CorePermissionsApplication {

    public void onCreate() {
        super.onCreate();
        Log.e("DEXTER", ">>> DEXTER INITIALIZED");
    }
}
