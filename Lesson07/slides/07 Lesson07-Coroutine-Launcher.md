---
title: Launch builder
template: two-column
codeSource: assets/kotlin/LaunchBuilder.kt
---

#### LaunchBuilder.kt

```kotlin
fun main() {
    runBlocking {
        println("Start coroutine ${Thread.currentThread().name}")
        val job1 = launch {
            println("first launch ${Thread.currentThread().name}")
            delay(1000)
            println("first launch Done ${Thread.currentThread().name}")
        }

        val job2 = launch {
            println("second launch ${Thread.currentThread().name}")
            delay(1000)
            println("Second launch Done ${Thread.currentThread().name}")
        }

        println("End coroutine ${Thread.currentThread().name}")
    }
    println("Run blocking done ${Thread.currentThread().name}")
}
```

<!-- column -->

#### Output:

1. Start coroutine main @coroutine#1
2. End coroutine main @coroutine#1
3. first launch main @coroutine#2
4. second launch main @coroutine#3
5. first launch Done main @coroutine#2
6. Second launch Done main @coroutine#3
7. Run blocking done main

The launch coroutine builder starts a coroutine in the enclosing scope and returns a reference to the coroutine as a
job.
It is important to understand how these coroutines (jobs) are scheduled, here specifically on the main thread



```kotlin
public fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job
```
