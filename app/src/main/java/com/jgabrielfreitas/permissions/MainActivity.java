package com.jgabrielfreitas.permissions;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.jgabrielfreitas.layoutid.activity.InjectLayoutBaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;
import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.jgabrielfreitas.permissions.core.managers.CameraPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.ContactPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.LocationPermissionManager;
import com.karumi.dexter.PermissionToken;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends InjectLayoutBaseActivity implements OnPermissionRequest {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.contactsButton)
    public void getContacts() {

        ContactPermissionManager contactPermissionManager = new ContactPermissionManager(this, this);
        contactPermissionManager.askPermission();
    }

    @OnClick(R.id.locationButton)
    public void getLocation() {

        LocationPermissionManager locationPermissionManager = new LocationPermissionManager(this, this);
        locationPermissionManager.askPermission();
    }

    @OnClick(R.id.cameraButton)
    public void getCamera() {

        CameraPermissionManager cameraPermissionManager = new CameraPermissionManager(this, this);
        cameraPermissionManager.askPermission();
    }

    @Override
    public void onPermissionAllowed() {
        Toast.makeText(MainActivity.this, "permission Allowed - Be happy :) ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "permission Denied - Oh no... :( ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionDeniedButAskAgain(PermissionToken token) {
        token.continuePermissionRequest();
    }

}
