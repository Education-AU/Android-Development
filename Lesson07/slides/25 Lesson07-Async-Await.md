---
title: Results with async and await
template: two-column
---
#### async and await

`async` starts a child coroutine that computes a result and returns a **`Deferred<T>`**:
a job with a future result of type `T`.

- Like `launch`, it inherits the scope's context and starts immediately by default.
- The block's last expression becomes its result.
- `await()` suspends the caller until the result is ready, then returns it.
- Start multiple `async` coroutines before awaiting to let their work run concurrently.
  Parallel execution depends on the dispatcher.

**Exceptions:** `await()` rethrows a failed computation's exception.
With a regular parent job, an `async` failure also cancels its parent and siblings, even before `await()`.
A `CoroutineExceptionHandler` does not handle exceptions stored by `async`.

Unlike `withContext`, `async` returns immediately with a `Deferred`, not the computed value.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val first = async {
            delay(1000)
            21
        }
        val second = async {
            delay(1000)
            2
        }

        println("Both computations started")
        val result = first.await() * second.await()
        println("Result: $result")
    }
}
```

Both delays overlap, so the result `42` is available after roughly one second, not two.
The coroutines run concurrently even though they share the `runBlocking` thread.
