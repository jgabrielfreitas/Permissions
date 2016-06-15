package com.jgabrielfreitas.permissions.core.managers;

import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnMultiplePermissionRequest;
import com.jgabrielfreitas.permissions.core.models.MultiplePermissions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdanner on 15/06/2016.
 */
public abstract class BaseMultiplePermissionManager {

    private Context context;
    private OnMultiplePermissionRequest onMultiplePermissionRequest;

    public BaseMultiplePermissionManager(Context context, OnMultiplePermissionRequest onMultiplePermissionRequest) {
        this.context = context;
        this.onMultiplePermissionRequest = onMultiplePermissionRequest;
    }

    public Context getContext() {
        return context;
    }

    public OnMultiplePermissionRequest getOnMultiplePermissionRequest() {
        return onMultiplePermissionRequest;
    }

    public void requestMultiplePermissions(List<BasePermissionManager> permissionManagers) {
        List<String> permissions = new ArrayList<>();
        /**
         * Fills the list of permissions, according to the
         * managers passed by parameter.
         */
        for (BasePermissionManager permissionManager : permissionManagers) {
            permissions.add(permissionManager.getPermission());
        }
        /**
         * If the permission list is not empty , check for multiple permissions
         * is instantiated and called.
         */
        if (!permissions.isEmpty()) {
            new MultiplePermissions(getContext(), getOnMultiplePermissionRequest()).checkPermissions(permissions);
        }
    }
}