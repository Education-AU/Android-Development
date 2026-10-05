---
title: Manifest
template: two-column
---

The manifest is information to the operating system about the application.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools">
    <application
            android:allowBackup="true"
            android:dataExtractionRules="@xml/data_extraction_rules"
            android:fullBackupContent="@xml/backup_rules"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.Test">

```

The thing to notice the specification of the activity.Which refers the relevant class in the application and the intent
filter.

The intent filter specifies that this activity is the main entry point of the application and should be launched when
the application icon is activated.
<!-- column -->

```xml

<activity
        android:name=".LauncherActivity"
        android:exported="true"
        android:label="@string/app_name"
        android:theme="@style/Theme.Test"
        android:windowSoftInputMode="adjustResize">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>

        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>
        </application>

        </manifest>
```