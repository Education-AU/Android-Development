---
title: Calling Api in Launched Effect
template: two-column
---
A typical reason for using the `LaunchedEffect` is calling some API.

As we see in this case the call is made
on the main Thread, but it is made asynchronously
with the UI updating.
Threading problems are discussed later.
(The launched effect block is called in a
coroutine scope with context main thread)



<!-- column -->

```kotlin
@Composable
fun ApiLaunchedEffectComponent() {
    var apiResult by remember { mutableStateOf("LOADING FROM API") }

    LaunchedEffect(Unit) {
        Log.v(
            "ApiLaunchedEffectComponent",
            "LaunchedEffect on Thread ${Thread.currentThread().name}"
        )
        apiResult = WaitService.serve(waitTime = 10000)
    }

    Column {
        Text("This is my api result:$apiResult")
    }
}
```

<div class="center">
<img src="./assets/ApiLog.png" alt="Boxes" width="70%">
</div>



