![InjectLayout](imgs/permissions-header.png)

## About Permissions for Android
[Runtime permissions](https://developer.android.com/training/permissions/requesting.html) beginning in Android 6.0 (API level 23), users grant permissions to apps while the app is running, not when they install the app. This approach streamlines the app install process, since the user does not need to grant permissions when they install or update the app. It also gives the user more control over the app's functionality; for example, a user could choose to give a camera app access to the camera but not to the device location. The user can revoke the permissions at any time, by going to the app's Settings screen.

Permissions is a library to make all easier permissions calls on Android.
> This library use [Dexter library](https://github.com/Karumi/Dexter) under the hood.


## How to
**Step 1.** Add the JitPack repository to your build file
```gradle
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

**Step 2.** Add the dependency
```gradle
dependencies {
		compile 'com.github.jgabrielfreitas:Permissions:1.1.0'
}
```

## Usage

> Check the `app` module for a sample

#### First of all
In your `Application` extends `CorePermissionsApplication` to initialize [Dexter library](https://github.com/Karumi/Dexter)

```java
public class CustomApplication extends CorePermissionsApplication {
	/*
	 * the only thing this class does is call Dexter.initialize(context); in onCreate
	 */
}
```

#### In your `.java` implements `OnPermissionRequest`
Your class will implement the following methods:

+ `onPermissionAllowed()` - Permission allowed, be happy :grimacing:
+ `onPermissionDenied()` - Permission denied, this is not good :fire:
+ `onPermissionDeniedButAskAgain(PermissionToken token)` - The user don't allow your request permission, but you can ask again using `token.continuePermissionRequest();` until they click `never ask again`

#### Request Permission

A location example


```java

// create a PermissionManager passing a Context and a OnPermissionRequest
LocationPermissionManager locationPermissionManager = new LocationPermissionManager(this, this);

// here, you request user location permission
locationPermissionManager.requestPermission();

```

The Dialog asking permission appears at this moment and you'll be called back when user tap at **DENY** or **ALLOW**.

#### All managers

Type | Manager
--- | ---
Audio | AudioPermissionManager
BodySensor | BodySensorPermissionManager
Calendar | CalendarPermissionManager
Camera | CameraPermissionManager
Contact | ContactPermissionManager
Location | LocationPermissionManager
Sms | SmsPermissionManager
Storage | StoragePermissionManager
Telephone | TelephonePermissionManager


---

### License
```
The MIT License (MIT)

Copyright (c) 2016 João Gabriel de Freitas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
---

```
Copyright 2015 Karumi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


