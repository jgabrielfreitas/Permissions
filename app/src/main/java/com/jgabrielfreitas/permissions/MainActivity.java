package com.jgabrielfreitas.permissions;

import android.os.Bundle;
import android.widget.Toast;

import com.jgabrielfreitas.layoutid.activity.InjectLayoutBaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;
import com.jgabrielfreitas.permissions.core.interfaces.OnMultiplePermissionRequest;
import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.jgabrielfreitas.permissions.core.managers.AudioPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.BasePermissionManager;
import com.jgabrielfreitas.permissions.core.managers.BodySensorPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.CalendarPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.CameraPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.ContactPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.LocationPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.MultiplePermissionManager;
import com.jgabrielfreitas.permissions.core.managers.SmsPermissionManager;
import com.jgabrielfreitas.permissions.core.managers.StoragePermissionManager;
import com.jgabrielfreitas.permissions.core.managers.TelephonePermissionManager;
import com.karumi.dexter.PermissionToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends InjectLayoutBaseActivity implements OnPermissionRequest, OnMultiplePermissionRequest {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.contactsButton)
    public void getContacts() {

        ContactPermissionManager contactPermissionManager = new ContactPermissionManager(this, this);
        contactPermissionManager.requestPermission();
    }

    @OnClick(R.id.locationButton)
    public void getLocation() {

        LocationPermissionManager locationPermissionManager = new LocationPermissionManager(this, this);
        locationPermissionManager.requestPermission();
    }

    @OnClick(R.id.audioButton)
    public void getMicrophone() {

        AudioPermissionManager audioPermissionManager = new AudioPermissionManager(this, this);
        audioPermissionManager.requestPermission();
    }

    @OnClick(R.id.phoneInfoButton)
    public void getStorage() {

        StoragePermissionManager storagePermissionManager = new StoragePermissionManager(this, this);
        storagePermissionManager.requestPermission();
    }

    @OnClick(R.id.telephoneButton)
    public void getTelephone() {

        TelephonePermissionManager telephonePermissionManager = new TelephonePermissionManager(this, this);
        telephonePermissionManager.requestPermission();
    }

    @OnClick(R.id.cameraButton)
    public void getCamera() {

        CameraPermissionManager cameraPermissionManager = new CameraPermissionManager(this, this);
        cameraPermissionManager.requestPermission();
    }

    @OnClick(R.id.readCalendarButton)
    public void getReadCalendar() {

        CalendarPermissionManager calendarPermissionManager = new CalendarPermissionManager(this, this);
        calendarPermissionManager.requestPermission();
    }

    @OnClick(R.id.smsButton)
    public void getSmsPermision() {

        SmsPermissionManager smsPermissionManager = new SmsPermissionManager(this, this);
        smsPermissionManager.requestPermission();
    }

    @OnClick(R.id.bodySensorButton)
    public void getBodySensor() {

        BodySensorPermissionManager bodySensorPermissionManager = new BodySensorPermissionManager(this, this);
        bodySensorPermissionManager.requestPermission();
    }

    @OnClick(R.id.multipleButton)
    public void getMultiple() {
        /**
         *  Fills the managers list with the desired permissions .
         */
        List<BasePermissionManager> basePermissionManagers = new ArrayList<>();
        basePermissionManagers.add(new SmsPermissionManager(this, this));
        basePermissionManagers.add(new BodySensorPermissionManager(this, this));

        MultiplePermissionManager multiplePermissionManager = new MultiplePermissionManager(this, this);
        multiplePermissionManager.requestMultiplePermissions(basePermissionManagers);
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

    // Method in the event of denied permission to OnMultiplePermissionRequest.
    @Override
    public void onPermissionDenied(String name) {
        String permission = String.format("permission %s Denied - Oh no... :( ", name);
        Toast.makeText(MainActivity.this, permission, Toast.LENGTH_SHORT).show();
    }
}
