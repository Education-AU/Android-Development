---
title: Launching from Button Click
template: default
---

`LaunchedEffect` takes place in a composable scope but if you want to call 
in this scope from the outside of the launchedEffect you can get a reference to the scope using
`rememberCoroutineScope`.

This will give the same result when pressing the button and decomposing

```kotlin
@Composable
fun ApiFromButtonCancelComponent() {
    var apiResult by remember { mutableStateOf("LOADING FROM API") }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        Log.v("ApiLaunchedEffectComponent","LaunchedEffect on Thread ${Thread.currentThread().name}")
    }
    Column {
        Button(onClick = {
            scope.launch {
                apiResult = WaitService.serve(waitTime = 10000)
                delay(timeMillis = 10000)
                apiResult = WaitService.serve(waitTime = 2000)
            }}) {Text("Load from API")}
        Text("This is my api result:$apiResult")
    }
}
```

