---
title: Suspend Functions
template: two-column
codeSource: assets/kotlin/RunBlockingOnDispatcher.kt
---
As we saw before the coroutines in the runBlocking scope were executed by the main thread.
This can be controlled by the context.
If we want the scope to use a dispatcher thread pool, we can specify that.

#### RunBlockingOnDispatcher.kt

```kotlin
fun main() {
    runBlocking(context = Dispatchers.IO) {
        val job1 = launch { delayAndPrint(1) }
        val job2 = launch { delayAndPrint(1) }
        val job3 = launch { delayAndPrint(1) }
        val job4 = launch { delayAndPrint(1) }
        val job5 = launch { delayAndPrint(1) }
        val job6 = launch { delayAndPrint(1) }
        println("Last in scope")
    }
    println("After Block")
} //runBlockingThreads
```


<!-- column -->

```text
1. Start delay and print on thread DefaultDispatcher-worker-3 @coroutine#2
2. Start delay and print on thread DefaultDispatcher-worker-4 @coroutine#4
3. Start delay and print on thread DefaultDispatcher-worker-2 @coroutine#3
4. Start delay and print on thread DefaultDispatcher-worker-2 @coroutine#5
5. Start delay and print on thread DefaultDispatcher-worker-2 @coroutine#6
6. Last in scope
7. Start delay and print on thread DefaultDispatcher-worker-3 @coroutine#7
8. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#2
9. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#4
10. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#3
11. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#5
12. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#6
13. Waited for 1 ms before executing on DefaultDispatcher-worker-6 @coroutine#7
14. After Block
```
