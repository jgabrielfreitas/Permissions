package com.jgabrielfreitas.permissions.core.interfaces;

import com.karumi.dexter.PermissionToken;

/**
 * Created by JGabrielFreitas on 09/06/16.
 */
public interface OnPermissionRequest {

    void onPermissionAllowed();

    void onPermissionDenied();

    void onPermissionDeniedButAskAgain(PermissionToken token);

}
