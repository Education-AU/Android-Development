---
title: Using Launched Effect
template: two-column
showFooter: false
eyebrow: Will be demonstrated
---
In order to launch a coroutine in a composable, we can use the `LaunchedEffect` composable. This allows us to run
**suspend** functions and perform side effects in response to state changes. But now we need `fetch` to be a suspend
function. And also it should still execute in an appropriate context.

```kotlin
@Composable
fun ScopeFetchContext() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    val scope = rememberCoroutineScope()
    Column {
        Button(onClick = { counter.value += 1 }) {
            Text("The Counter:${counter.value}")
        }
        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                fetchState.value += fetch()
            }
        }) {
            Text("Scope fetch context:${fetchState.value}")
        }}}
```


<!-- column -->


```kotlin
suspend fun fetchSuspend(doThrow: Boolean = false): String {
    return withContext(Dispatchers.IO) {
        Log.v(TAG_UTIL, "Starting fetch suspend in thread ${Thread.currentThread().name}")
        if (doThrow) {
            throw Exception("Throw from fetchSuspend")
        }
        doALot(6000)
        Log.v(TAG_UTIL, "Done fetching suspend in thread ${Thread.currentThread().name}")
        return@withContext "suspend stuff";
    }
}
```