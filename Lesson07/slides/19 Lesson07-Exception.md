---
title: Exceptions in coroutines
template: two-column
---

1. `launch` starts a coroutine and returns a `Job`; it does not return a result.
2. `try`/`catch` around the call to `launch` does not catch exceptions thrown inside the launched coroutine.
3. To handle an exception locally, catch it inside the `launch` block. Alternatively, use an appropriate coroutine exception-handling mechanism.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.CancellationException
fun main() {
    runBlocking {
        try {
            val job1 = launch {
                throw IllegalArgumentException("Job 1 failed with an exception")
            }
        } catch (e: IllegalArgumentException) {
            println("Caught exception: ${e.message}")
        }
    }
}
```