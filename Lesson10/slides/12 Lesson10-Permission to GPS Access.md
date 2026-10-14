---
title: GPS Access Permissions
template: two-column

---

The first block:

Remembers a state of whether the app has permission to access the device's GPS. 

The Second block:

Sets up a launcher for requesting the permission. When the user responds to the permission request, the `granted` state is updated accordingly.

The third block:

In LauncedEffect, it checks if the permission is not granted and launches the permission request if needed.
<!-- column -->

```kotlin
val context = LocalContext.current
val granted = remember {
    mutableStateOf(
        PackageManager.PERMISSION_GRANTED ==
            ContextCompat.checkSelfPermission(context, PERMISSION)
    )
}
```

```kotlin
val launcher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
) { isGranted: Boolean ->
    granted.value = isGranted
}
```

```kotlin
LaunchedEffect(Unit) {
    if (!granted.value) {
        launcher.launch("android.permission.ACCESS_FINE_LOCATION")
    }
}
```