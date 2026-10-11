---
title: Direct catch
template: two-column
showFooter: false
eyebrow: Will be demonstrated
---

I direct catch can of course be performed in the launch itself. But remember not to catch the CancellationException.

There are many things and options to consider when catching exceptions in coroutines. The main point is that you cannot
catch exceptions thrown in a coroutine from outside the coroutine. You must catch them inside the coroutine itself or by
a handler.

Also, you must never catch the CancellationException without rethrowing it, otherwise the coroutine will not be canceled
as expected.
<!-- column -->

```kotlin

@Composable
fun DirectCatchException() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    val scope = rememberCoroutineScope()
    Column {
        Button(onClick = { counter.value += 1 }) { Text("The Counter:${counter.value}") }
        Button(onClick = {scope.launch() {
                try {
                    delay(1000);Log.v("ScopeFetchException", "before exception")
                    throw Exception("test"); fetchState.value += fetchSuspend()
                } catch (e: Exception) {
                    Log.v("Caught Directly", "Caught exception: ${e.message}")
                    if (e is CancellationException) {
                        throw e;}}}
            scope.launch() {
                delay(2000)
                fetchState.value += fetchSuspend() + "SECOND CALL"
                Log.v("ScopeFetchException", "Is never called?")}}) { Text("Scope fetch:${fetchState.value}") }}}
```

