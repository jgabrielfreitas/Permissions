package com.jgabrielfreitas.permissions.core.interfaces;

import com.karumi.dexter.PermissionToken;

/**
 * Created by cdanner on 15/06/2016.
 */
public interface BaseOnPermissionRequest {

    void onPermissionAllowed();

    void onPermissionDeniedButAskAgain(PermissionToken token);
}
