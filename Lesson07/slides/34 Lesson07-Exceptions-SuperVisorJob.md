---
title: Exceptions and SupervisorJob
template: two-column
showFooter: false
eyebrow: Will be demonstrated
---

In this example we equip a coroutine scope with a `SupervisorJob` and a `CoroutineExceptionHandler`. The first launched
coroutine throws an exception, but the second launched coroutine is not affected by the first one. The second coroutine
completes successfully.

And also the scope is kept alive after the first coroutine fails, so we can launch a new coroutine in the same scope.

<!-- column -->

```kotlin
@Composable
fun SuperVisorScopeFetchException() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    val handle = CoroutineExceptionHandler { _, exc ->Log.v("HANDLER", exc.message.toString())}
    val supervisorJob = SupervisorJob()
    val scope = rememberCoroutineScope() + supervisorJob
    Column {
        Button(onClick = {counter.value += 1}) {Text("The Counter:${counter.value}")}
        Button(onClick = {scope.launch(handle) {// not enough
                delay(1000)
                Log.v("ScopeFetchException", "before exception")
                throw Exception("test")
                fetchState.value += fetchSuspend()}
            scope.launch(handle) {
                delay(2000)
                fetchState.value += fetchSuspend() + "SECOND CALL"
                Log.v("ScopeFetchException", "Is never called?")}
        }) {Text("Scope fetch:${fetchState.value}")}}}
```

