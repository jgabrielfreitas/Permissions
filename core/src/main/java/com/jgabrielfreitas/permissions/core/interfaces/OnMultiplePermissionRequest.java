package com.jgabrielfreitas.permissions.core.interfaces;

/**
 * Created by cdanner on 15/06/2016.
 */
public interface OnMultiplePermissionRequest extends BaseOnPermissionRequest {

    void onPermissionDenied(String name);
}
