---
title: Switching context with withContext
showFooter: false
template: two-column
---
#### withContext

`withContext` runs a block in a specified coroutine context, commonly to change its dispatcher.
It creates a **child scope**, not independent work.

- It suspends the caller until the block and all its children finish, then returns the block's result.
- With a dispatcher change, the block runs on that dispatcher; afterward, the caller resumes in its original context.
- Parent cancellation cancels the child; uncaught exceptions propagate to the caller.
- Use `Dispatchers.Default` for CPU-intensive work and `Dispatchers.IO` for blocking I/O.

Like `coroutineScope`, `withContext` returns the block's **last expression** as its result.
Unlike `launch`, it returns that value directly, not a `Job`; no `await()` is needed.
Changing the dispatcher does not make blocking or CPU-intensive code automatically cancellation-cooperative.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            println("Before: ${Thread.currentThread().name}")

            val number = withContext(Dispatchers.IO) {
                println("IO block: ${Thread.currentThread().name}")
                21
            }
            println("IO result: $number")
            println("After IO: ${Thread.currentThread().name}")

            val doubled = withContext(Dispatchers.Default) {
                println("Default block: ${Thread.currentThread().name}")
                number * 2
            }

            println("Default result: $doubled")
            println("After Default: ${Thread.currentThread().name}")
        }
    }
}
```
