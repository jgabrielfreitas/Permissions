package com.jgabrielfreitas.permissions.core.models;

import android.content.Context;
import android.util.Log;

import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

/**
 * Created by JGabrielFreitas on 09/06/16.
 */
public class Permissions implements PermissionListener {

    private Context context;
    private OnPermissionRequest onPermissionRequest;

    public Permissions(Context context, OnPermissionRequest onPermissionRequest) {
        this.context = context;
        this.onPermissionRequest = onPermissionRequest;
    }

    public void checkPermission(String permission) {

        if (!Dexter.isRequestOngoing())
            dexterCheckPermission(permission);
        else {
            Log.e("PERMISSIONS", "REQUEST PERMISSION ONCE!");
            onPermissionRequest.onPermissionDenied();
        }
    }

    private void dexterCheckPermission(String permission) {
        Dexter.checkPermission(this, permission);
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        onPermissionRequest.onPermissionAllowed();
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {
        onPermissionRequest.onPermissionDenied();
    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
        onPermissionRequest.onPermissionDeniedButAskAgain(token);
    }
}
