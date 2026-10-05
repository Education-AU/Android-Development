---
title: Extended Manifest
template: default
---
In order to do this we must add the two new activities to the manifest. 
Notice that no intent filters are needed here since these activities will not be launched directly from the launcher.

```xml
<activity
            android:name=".activities.LauncherActivity"
            android:exported="true"
            android:theme="@style/Theme.SimpleActivities">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name=".activities.ProfileActivity"
            android:exported="true"
            android:theme="@style/Theme.SimpleActivities">

        </activity>
        <activity
            android:name=".activities.SettingsActivity"
            android:exported="true"
            android:theme="@style/Theme.SimpleActivities">

        </activity>

```
