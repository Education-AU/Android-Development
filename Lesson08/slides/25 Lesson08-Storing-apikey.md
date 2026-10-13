---
title: Storing API-Key
template: two-column
showFooter: false
---

For storing secrets, I use the Google plugin

```toml
[plugins]
google-secrets = { id = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin", version.ref = "googleSecrets" }
```

And in build file:


```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.secrets)
}
secrets {
    propertiesFileName = "secrets.properties"
    defaultPropertiesFileName = "local.defaults.properties"
    ignoreList.add("keyToIgnore")
    ignoreList.add("sdk.*")
}
```
Which makes secret available in code as 

<!-- column -->
<img src="assets/images/SecretFiles.png" alt="NASA API key page" style="max-height: 50%; object-fit: contain;">

The `secrets.properties` file contains the secret and is in `.gitIgnore` (NASA_API_KEY=your_api_key).

The `local.defaults.properties` contains (not in `.gitIgnore`) (NASA_API_KEY=DEFAULT_VALUE)

```kotlin
private const val BASE_URL =
    "https://api.nasa.gov/planetary/apod?api_key=${BuildConfig.NASA_API_KEY}"
```
