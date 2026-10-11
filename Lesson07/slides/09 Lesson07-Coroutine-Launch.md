---
title: Coroutine Order
template: two-column
codeSource: assets/kotlin/LaunchOrder.kt
---

#### LaunchOrder.kt

```kotlin
fun main() {
    runBlocking {
        val job1 = launch {
            println("Job 1 before suspending")
            delay(3000L)
            println("Finished job 1 on Thread ${Thread.currentThread().name}")
        }
        val job2 = launch {
            println("Job 2 before suspending")
            delay(2000L)
            println("Finished job 2 on Thread ${Thread.currentThread().name}")
        }
        val job3 = launch {
            println("Job 3 before suspending")
            delay(1000L)
            println("Finished job 3 on Thread ${Thread.currentThread().name}")
        }
        println("Last in scope")
    }
    println("After Block")
}
```

<!-- column -->

1. Last in scope
2. Job 1 before suspending
3. Job 2 before suspending
4. Job 3 before suspending
5. Finished job 3 on Thread main @coroutine#4
6. Finished job 2 on Thread main @coroutine#3
7. Finished job 1 on Thread main @coroutine#2
8. After Block

If we suspend the coroutines by the delay suspend function
The order is changed because the coroutines that are suspended for the shortest time finish executing first.
