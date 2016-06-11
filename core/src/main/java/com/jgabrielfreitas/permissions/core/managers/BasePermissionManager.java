package com.jgabrielfreitas.permissions.core.managers;

import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;

/**
 * Created by JGabrielFreitas on 09/06/16.
 */
public abstract class BasePermissionManager {

    private Context context;
    private OnPermissionRequest onPermissionRequest;

    public BasePermissionManager(Context context, OnPermissionRequest onPermissionRequest) {
        this.context = context;
        this.onPermissionRequest = onPermissionRequest;
    }

    public Context getContext() {
        return context;
    }

    public OnPermissionRequest getOnPermissionRequest() {
        return onPermissionRequest;
    }

    public abstract void askPermission();

}
