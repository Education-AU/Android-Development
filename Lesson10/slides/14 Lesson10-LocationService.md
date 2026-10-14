---
title: The Location Service
template: default
---

```kotlin
class MapsService(private val locationProvider: FusedLocationProviderClient) {

    suspend fun getCurrentLocation(): Location? {
        try {
            val res =
                locationProvider.getCurrentLocation(LocationRequest.QUALITY_HIGH_ACCURACY, null)
                    .await()
            Log.v(this::class.qualifiedName, res.toString())
            return res
        } catch (ex: SecurityException) {
            Log.v(this::class.qualifiedName, ex.message.toString())
            return null
        }
    }
}
```

This is just a suspend function service that uses the FusedLocationProviderClient to get the current location. It uses a
try/catch block to handle any SecurityException that may occur if the app does not have the necessary permissions to
access the location. If the location is successfully retrieved, it is logged and returned; otherwise, null is returned.

The exception handling could and should of course be extended and improved