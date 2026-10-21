---
title: Exceptions in coroutines
template: two-column
showFooter: false
codeSource: assets/kotlin/Exceptions1.kt
---

#### General Exception Handling:
If a coroutine fails with an exception other than `CancellationException` or children thereof, the following typically happens:

1. Its parent coroutine is canceled, propagating the failure upward through the coroutine hierarchy.
2. Its sibling coroutines are canceled as a consequence of the parent coroutine's cancellation.
3. The exception is propagated to the parent. A parent coroutine normally cannot handle the failure and continue; it is canceled as well.
4. At the root, the exception's handling depends on the coroutine builder and context. 
5. An uncaught exception from a root `launch` is normally reported to a `CoroutineExceptionHandler` or the thread's uncaught exception handler. 
6. An uncaught exception from `runBlocking` is rethrown to the calling thread.

Let's look at an example of how exceptions propagate in coroutines exemplified by launch builder.

<!-- column -->

```kotlin
//Exceptions1.kt
fun main() {
    runBlocking {
        val job1 = launch {
            try {
                val job11 = launch {
                    try {
                        delayAndPrint(5000, "Job 11 started ", "from Job 11 NOT CANCELED")
                    } catch (e: CancellationException) {
                        println("Job 11 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                        throw e
                    }
                }
                val job12 = launch {
                    delayAndPrint(3000, "Job 12 started ", "Done from job 12 NOT CANCELED")
                    throw IllegalArgumentException("Job 12 failed with an exception")
                }
                delayAndPrint(5000, "Job 1 started ", "Done from job 1 NOT CANCELED")
            } catch (e: CancellationException) {
                println("Job 1 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                throw e
            }
            delayAndPrint(6000, "From Run Blocking ", "from run blocking NOT CANCELED")
        }}}
```