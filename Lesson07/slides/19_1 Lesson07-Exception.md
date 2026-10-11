---
title: Exceptions in coroutines
showFooter: false
template: two-column
---

#### Exception handlers in launch using supervisorScope

`supervisorScope` is similar to `coroutineScope`: both create a child scope and wait for all their children to finish.
The key difference is **failure isolation**.

- In `coroutineScope`, a child's failure fails the scope and cancels its other children.
- In `supervisorScope`, a child's failure does not fail the scope, cancel its other children, or fail the parent.

A normal child `launch` delegates its failure to its parent, so a `CoroutineExceptionHandler` attached to that child is not used.
A direct child `launch` of `supervisorScope` reports its own uncaught exception through its handler.
The handler reports the failure; it does not recover or restart the failed coroutine.

In this example, `supervisorScope` waits for the failed child to finish, including its handler,
before `runBlocking continues` is printed.

**Supervision isolates child failures, not failures in the scope's own block.**
An exception thrown directly in the `supervisorScope` block still cancels its children and propagates to the caller.
Cancelling the parent also cancels the scope and its children.
<!-- column -->

```kotlin runnable
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.ContinuationInterceptor

fun main() {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught ${exception::class.simpleName}: ${exception.message}")
    }
    runBlocking {
        supervisorScope {
            launch(handler) {
                throw IllegalArgumentException("Job 1 failed")
            }
        launch(handler) {
                delay(1000)
                println("Job 2 is running successfully")
            }
        }
        println("runBlocking continues")
    }
}
```
