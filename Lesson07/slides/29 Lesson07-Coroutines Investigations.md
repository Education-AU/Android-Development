---
title: Coroutine Investigations
template: two-column
eyebrow: Will be demonstrated
---
#### Blocking the main thread

```kotlin
@Composable
fun BlockingFetch() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    Column {
        Button(onClick = { counter.value += 1 }) {
            Text("The Counter:${counter.value}")
        }
        Button(onClick = { fetchState.value += fetch() }) {
            Text("Blocking fetch:${fetchState.value}")
        }

    }
}
```



<!-- column -->
```kotlin
fun fetch(): String {
    Log.v(TAG_UTIL, "Starting fetch in thread ${Thread.currentThread().name}")
    doALot(4000)
    Log.v(TAG_UTIL, "Done fetching in thread ${Thread.currentThread().name}")
    return "stuff";
}
```

```kotlin
fun doALot(time: Long) {
    val timeStart = System.currentTimeMillis()
    while (System.currentTimeMillis() < timeStart + time) {
        if ((System.currentTimeMillis() - timeStart).toInt() % 2000 == 1) {
            Log.v("DOALOT", "doing stuff in thread ${Thread.currentThread().name}")
        }
    }
}
```
