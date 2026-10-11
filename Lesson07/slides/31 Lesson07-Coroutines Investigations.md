---
title: Coroutine Investigations
template: two-column
eyebrow: Will be demonstrated
---

#### Using scope on Dispatchers.IO context

This **will** improve since the long-running code is now running on different threads.

The main thread is ** not** blocked and the UI is responsive. 


<!-- column -->

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
        }
    }
}
```
