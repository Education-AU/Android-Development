---
title: Exceptions and Scopes
template: two-column
showFooter: false
eyebrow: Will be demonstrated
---

As we saw, exception handling can be somewhat involved. Let's look at an example using the composable scope.

In the previous discussion we observed that if a child coroutine fails with an exception, the parent coroutine is
canceled, propagating the failure upward through the coroutine hierarchy. This will lead to sibling coroutines being
canceled as well. And the exception handler wil not be activated at all. This is because the exception handler is only
activated for uncaught exceptions in the root coroutine.

If we want this to work we could use a `SupervisorJob` in the parent scope. This will allow the child coroutine to fail without
canceling the parent and siblings.

<!-- column -->

```kotlin
@Composable
fun ScopeFetchException() {
    val counter = remember { mutableStateOf(0) }
    val fetchState = remember { mutableStateOf("Initial") }
    val handle = CoroutineExceptionHandler { _, exc ->Log.v("HANDLER", exc.message.toString())}
    val scope = rememberCoroutineScope()
    Column {
        Button(onClick = {counter.value += 1}) {Text("The Counter:${counter.value}")}
        Button(onClick = {
            scope.launch(Dispatchers.IO+handle) {// not enough
                delay(1000)
                Log.v("ScopeFetchException", "before exception")
                throw Exception("test")
                fetchState.value += fetchSuspend()
            }
            scope.launch {
                delay(2000)
                fetchState.value += fetchSuspend() + "SECOND CALL";
                Log.v("ScopeFetchException", "Is never called?")
            }
        }) {
            Text("Scope fetch:${fetchState.value}")
        }}}
```

