package com.jgabrielfreitas.permissions.core.managers;

import android.Manifest;
import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.jgabrielfreitas.permissions.core.models.Permissions;

/**
 * Created by JGabrielFreitas on 09/06/16.
 */
public class ContactPermissionManager extends BasePermissionManager {


    public ContactPermissionManager(Context context, OnPermissionRequest onPermissionRequest) {
        super(context, onPermissionRequest);
    }

    public void askPermission() {
        Permissions permissions = new Permissions(getContext(), getOnPermissionRequest());
        permissions.checkPermission(Manifest.permission.READ_CONTACTS);
    }
}
