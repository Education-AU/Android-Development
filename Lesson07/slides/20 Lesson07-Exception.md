---
title: Exceptions in coroutines
showFooter: false
template: two-column
---

#### Exceptions in Independent CoroutineScope

`CoroutineScope(Dispatchers.Default + handler)` creates an independent scope with an automatically added `Job`.

Access this job with `scope.coroutineContext.job`. Here, the child failure cancels it,
so `join()` returns after all children finish. Without failure, the scope job remains active even after its children finish.

- A child failure cancels the scope and its siblings, but not the unrelated `runBlocking`.
- The handler reports uncaught `launch` exceptions; it does not recover the coroutine or make the canceled scope reusable.
- Without a handler, an uncaught exception can crash the app, even on a background dispatcher.

Here, Job 1 fails, Job 2 is canceled, and `runBlocking` continues after waiting for both coroutines.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught: ${exception.message}")
    }
    val scope = CoroutineScope(Dispatchers.Default + handler)

    scope.launch {
        try {
            delay(1000)
            println("Job 2 completed")
        } finally {
            println("Job 2 finished; active = $isActive")
        }
    }
    scope.launch {
        delay(100)
        throw IllegalArgumentException("Job 1 failed")
    }

    scope.coroutineContext.job.join()
    println("runBlocking continues; active = $isActive")
}
```
