---
title: Manifest
template: two-column
---

```xml
<activity
    android:name=".activities.pi.PiActivity"
    android:exported="true"
    android:theme="@style/Theme.LifeOfPi">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```
<!-- column -->

```xml
<activity
android:name=".activities.pi.TigerActivity"
android:exported="true"
android:theme="@style/Theme.LifeOfPi" />
```