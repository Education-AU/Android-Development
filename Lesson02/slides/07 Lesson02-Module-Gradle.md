---
title: Module Gradle File dependencies
template: two-column
---

Further configuration is:

The SDK compiled to
The minimal SDK it can run on
Target SDK usually=Compile SDK.

Target SDK is the SDK the app is intended and designed for

And some other configurations we will not get into.

<!-- column -->

```kotlin
android {
    namespace = "com.howard.test"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.howard.test"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

```