---
title: Coroutine Investigations
template: two-column
eyebrow: Will be demonstrated
---

#### Using scope on main thread

This will not improve since the long-running code is still running on the main thread.

The main thread is blocked and the UI is not responsive. The counter button will not update until the long-running code
is finished.


<!-- column -->

```kotlin
@Composable
fun ScopeFetch() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    val scope = rememberCoroutineScope()
    Column {
        Button(onClick = { counter.value += 1 }) {
            Text("The Counter:${counter.value}")
        }
        Button(onClick = {
            scope.launch {
                fetchState.value += fetch()
            }
        }) {
            Text("Scope fetch:${fetchState.value}")
        }

    }
}
```
