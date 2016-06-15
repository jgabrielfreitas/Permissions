package com.jgabrielfreitas.permissions.core.models;

import android.content.Context;
import android.util.Log;

import com.jgabrielfreitas.permissions.core.interfaces.OnMultiplePermissionRequest;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

/**
 * Created by cdanner on 15/06/2016.
 */
public class MultiplePermissions implements MultiplePermissionsListener {

    private Context context;
    private OnMultiplePermissionRequest onMultiplePermissionRequest;

    public MultiplePermissions(Context context, OnMultiplePermissionRequest onMultiplePermissionRequest) {
        this.context = context;
        this.onMultiplePermissionRequest = onMultiplePermissionRequest;
    }

    public void checkPermissions(List<String> permissions) {

        if (!Dexter.isRequestOngoing())
            dexterCheckPermissions(permissions);
        else {
            for (String permission : permissions) {
                Log.e("PERMISSIONS", "REQUEST PERMISSION ONCE!");
                onMultiplePermissionRequest.onPermissionDenied(permission);
            }
        }
    }

    private void dexterCheckPermissions(List<String> permissions) {
        Dexter.checkPermissions(this, permissions);
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport report) {
        for (int i = 0; i < report.getGrantedPermissionResponses().size(); i++) {
            onMultiplePermissionRequest.onPermissionAllowed();
        }

        for (PermissionDeniedResponse response : report.getDeniedPermissionResponses()) {
            onMultiplePermissionRequest.onPermissionDenied(response.getPermissionName());
        }
    }

    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
        onMultiplePermissionRequest.onPermissionDeniedButAskAgain(token);
    }
}