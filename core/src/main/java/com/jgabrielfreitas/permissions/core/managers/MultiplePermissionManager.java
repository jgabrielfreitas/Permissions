package com.jgabrielfreitas.permissions.core.managers;

import android.content.Context;

import com.jgabrielfreitas.permissions.core.interfaces.OnMultiplePermissionRequest;

/**
 * Created by cdanner on 15/06/2016.
 */
public class MultiplePermissionManager extends BaseMultiplePermissionManager {

    public MultiplePermissionManager(Context context, OnMultiplePermissionRequest onMultiplePermissionRequest) {
        super(context, onMultiplePermissionRequest);
    }
}
