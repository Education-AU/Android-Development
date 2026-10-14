---
title: Dependencies
template: two-column
---

```toml
[versions]
agp = "8.7.1"
kotlin = "2.0.0"
coreKtx = "1.13.1"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
lifecycleRuntimeKtx = "2.8.6"
activityCompose = "1.9.3"
composeBom = "2024.10.00"
googleGms = "4.4.2"
googlefirebase = "33.5.1"
googleplayserviceauth = "21.2.0"
```

```toml
[libraries]
google-firebase-bom = { group = "com.google.firebase", name = "firebase-bom", version.ref = "googlefirebase" }
google-firebase-firestore = { group = "com.google.firebase", name = "firebase-firestore" }
google-firebase-auth = { group = "com.google.firebase", name = "firebase-auth" }
google-android-gms-play-services = { group = "com.google.android.gms", name = "play-services-auth", version.ref = "googleplayserviceauth" }
google-firebase-storage = { group = "com.google.firebase", name = "firebase-storage" }
```
<!-- column -->

```toml
[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
google-gms-services = { id = "com.google.gms.google-services", version.ref = "googleGms" }
google-secrets={id="com.google.android.libraries.mapsplatform.secrets-gradle-plugin",version.ref="googleSecrets"}

```
And apply these dependencies in gradle-files. The bom should be applied correctly as platform

```kotlin
dependencies {
    // Firebase BoM aligns Firebase library versions.
    implementation(platform(libs.google.firebase.bom))
    implementation(libs.google.firebase.firestore)
    implementation(libs.google.firebase.auth)
    implementation(libs.google.android.gms.play.services)
    implementation(libs.google.firebase.storage)
}
```