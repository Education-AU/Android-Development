---
title: Decompose cancels coroutine
template: two-column
---

Decomposition cancels coroutines. 

This means operation not started in the coroutine are canceled.

To demonstrate this first a wrapper Composable is created that can remove a child Composable from the composition.
```kotlin
@Composable
fun DecomposingWrapper(content: @Composable () -> Unit) {
    val showComponent = remember { mutableStateOf(true) }
    Column {
        Button(onClick = {
            showComponent.value = !showComponent.value
        }) {
            Text("Decompose Component")
        }
        if (showComponent.value) {
            content()
        }
    }
}
```

<!-- column -->
Then a launched effect is calling twice with delay in between. We demonstrate cancellation of the second call.

```kotlin
@Composable
fun ApiLaunchedEffectCancelComponent() {
    var apiResult by remember { mutableStateOf("LOADING FROM API") }

    LaunchedEffect(Unit) {
        Log.v(
            "ApiLaunchedEffectComponent",
            "LaunchedEffect on Thread ${Thread.currentThread().name}"
        )
        apiResult = WaitService.serve(waitTime = 10000)
        delay(timeMillis = 10000)
        apiResult = WaitService.serve(waitTime = 2000)
    }

    Column {
        Text("This is my api result:$apiResult")
    }
}
```
