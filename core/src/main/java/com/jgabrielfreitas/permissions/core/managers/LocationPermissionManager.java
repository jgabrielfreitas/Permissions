package com.jgabrielfreitas.permissions.core.managers;

import android.Manifest;
import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.jgabrielfreitas.permissions.core.models.Permissions;

/**
 * Created by JGabrielFreitas on 10/06/16.
 */
public class LocationPermissionManager extends BasePermissionManager {

    public LocationPermissionManager(Context context, OnPermissionRequest onPermissionRequest) {
        super(context, onPermissionRequest);
    }

    public void askPermission() {
        Permissions permissions = new Permissions(getContext(), getOnPermissionRequest());
        permissions.checkPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
