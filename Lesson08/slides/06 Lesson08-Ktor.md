---
title: Permissions for Internet Access
template: default
---
To use the internet access from android the permissions must be introduced in the manifest file

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
```
And if *https* is not used, that is only *http* an additional permission must be introduced
```xml
    <application
        android:usesCleartextTraffic="true"
        
```