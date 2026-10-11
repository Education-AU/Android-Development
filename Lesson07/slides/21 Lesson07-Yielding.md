---
title: Suspension by yield
template: two-column
---

#### Yielding during long-running calculations

- `yield()` gives other coroutines on the dispatcher a chance to run and checks for cancellation.
- Unlike `delay()`, it does not wait for a specified time. It may return immediately if there is no other work to run.
- Long CPU-bound loops should yield periodically to stay cooperative, rather than monopolizing a thread.
  Run CPU-intensive work on `Dispatchers.Default`, not the main/UI thread.

```kotlin
repeat(1_000_000) { i ->
    calculateStep(i)
    if (i % 1000 == 0) yield()
}
```

Here, `calculateStep` represents one step of your calculation. If you only need cancellation checks,
use `ensureActive()` instead of yielding.

In the runnable example, `yield()` lets Launch 2 start before Launch 1 continues with its second print.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlinx.coroutines.delay

fun main() {
    runBlocking {
        launch() {
            println("Thread ${Thread.currentThread().name}")
        }
        launch() {
            println("Launch 1 a Thread ${Thread.currentThread().name}")
            yield()
            println("Launch 1 b Thread ${Thread.currentThread().name}")
        }
        launch() {
            println("Launch 2 a Thread ${Thread.currentThread().name}")
            delay(1000)
            println("Launch 2 b Thread ${Thread.currentThread().name}")
        }
    }
}
```
