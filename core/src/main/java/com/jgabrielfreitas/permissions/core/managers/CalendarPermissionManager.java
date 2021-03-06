package com.jgabrielfreitas.permissions.core.managers;

import android.Manifest;
import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;

/**
 * Created by JGabrielFreitas on 13/06/16.
 */
public class CalendarPermissionManager extends BasePermissionManager {

    public CalendarPermissionManager(Context context, OnPermissionRequest onPermissionRequest) {
        super(context, onPermissionRequest);
    }

    public String getPermission() {
        return Manifest.permission.READ_CALENDAR;
    }
}
