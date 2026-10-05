---
title: Disposable effect in online awareness
template: two-column
---
```kotlin
@Composable
fun DisposableEffectComposable() {
    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(false) }

    val networkCallback = remember {
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                isOnline = true
            }

            override fun onLost(network: Network) {
                isOnline = false
            }
        }
    }
}
```
We have to write this in the manifest file to get the network state:

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

This will be demonstrated in class 
<!-- column -->

```kotlin
DisposableEffect(Unit) {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    connectivityManager.registerDefaultNetworkCallback(networkCallback)

    // Unregister the callback when the composable leaves the composition
    onDispose {
        Log.v("DisposableEffectComposable", "Unregister connectivity Listener")
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}

Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = if (isOnline) "Online" else "Offline",
        color = if (isOnline) Color.Green else Color.Red
    )
}
```