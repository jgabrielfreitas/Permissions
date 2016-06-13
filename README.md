![InjectLayout](imgs/permissions-header.png)

## About
Permissions is a library to make all easier permissions calls on Android.

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
		compile 'com.github.jgabrielfreitas:Permissions:1.0.0'
}
```

#### Usage

> Check the `app` module for a sample


#### First of all implements `OnPermissionRequest`
+ `onPermissionAllowed()` - Permission allowed, be happy :grimacing:
+ `onPermissionDenied()` - Permission denied, this is not good :fire:
+ `onPermissionDeniedButAskAgain(PermissionToken token)` - The user don't allow your request permission, but you can ask again using `token.continuePermissionRequest();` until they click `never ask again`

### Request Permission

A location example


```java

// create a PermissionManager passing a Context and a OnPermissionRequest
LocationPermissionManager locationPermissionManager = new LocationPermissionManager(this, this);

// here, you request user location permission
locationPermissionManager.requestPermission();

```

The Dialog asking permission appears at this moment and you'll be called back when user tap at **DENY** or **ALLOW**.

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


