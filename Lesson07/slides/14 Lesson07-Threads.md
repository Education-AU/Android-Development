---
title: Setting Context
template: two-column
codeSource: assets/kotlin/ControlDispatcherInLaunch.kt
---
We can also control context on launch.

#### ControlDispatcherInLaunch.kt
```kotlin
fun main() {
    runBlocking() {
        val job1 = launch(context = newSingleThreadContext("Thread-one")) { delayAndPrint(1L) }
        val job2 = launch(context = newSingleThreadContext("Thread-two")) { delayAndPrint(1L) }
        val job3 = launch(context = Dispatchers.Default) { delayAndPrint(400L) }
        val job4 = launch(context = Dispatchers.Unconfined) { delayAndPrint(20L) }
        val job5 = launch(context = Dispatchers.Unconfined) { delayAndPrint(20L) }
        val job6 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
        val job7 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
        val job8 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
        println("Last in scope")
    }
    println("After Block")
}
```


<!-- column -->

```text
1. Start delay and print on thread Thread-one @coroutine#2
2. Start delay and print on thread Thread-two @coroutine#3
3. Waited for 1 ms before executing on Thread-one @coroutine#2
4. Start delay and print on thread DefaultDispatcher-worker-1 @coroutine#4
5. Waited for 1 ms before executing on Thread-two @coroutine#3
6. Start delay and print on thread main @coroutine#5
7. Start delay and print on thread main @coroutine#6
8. Start delay and print on thread DefaultDispatcher-worker-1 @coroutine#7
9. Start delay and print on thread DefaultDispatcher-worker-2 @coroutine#8
10. Start delay and print on thread DefaultDispatcher-worker-1 @coroutine#9
11. Last in scope
12. Waited for 10 ms before executing on DefaultDispatcher-worker-2 @coroutine#7
13. Waited for 10 ms before executing on DefaultDispatcher-worker-1 @coroutine#8
14. Waited for 10 ms before executing on DefaultDispatcher-worker-1 @coroutine#9
15. Waited for 20 ms before executing on kotlinx.coroutines.DefaultExecutor @coroutine#5
16. Waited for 20 ms before executing on kotlinx.coroutines.DefaultExecutor @coroutine#6
17. Waited for 400 ms before executing on DefaultDispatcher-worker-2 @coroutine#4
18. After Block
```
