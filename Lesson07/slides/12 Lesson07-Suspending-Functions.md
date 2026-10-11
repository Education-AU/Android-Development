---
title: Suspend Functions
template: two-column
---

As we saw in the previous slide the delay function was a suspending function.

Suspending functions are functions that must be called in a scope, and they can call other
suspending functions that in turn might define suspension points

We can define suspending functions ourselves. Let us look at an example

#### Output:
```text
1. Last in scope
2. Start delay and print on thread main @coroutine#2
3. Start delay and print on thread main @coroutine#3
4. Start delay and print on thread main @coroutine#4
5. Waited for 100 ms before executing on main @coroutine#4
6. Waited for 2000 ms before executing on main @coroutine#3
7. Waited for 3000 ms before executing on main @coroutine#2
8. After Block
```


<!-- column -->

```kotlin runnable
import kotlinx.coroutines.*
fun main() {
    runBlocking {
        val job1 = launch { delayAndPrint(3000) }
        val job2 = launch { delayAndPrint(2000) }
        val job3 = launch { delayAndPrint(100) }
        println("Last in scope")
    }
    println("After Block")
} //runblocking_4

suspend fun delayAndPrint(
    millis: Long,
    before: String = "Start delay and print on thread ",
    after: String = ""
) {
    println(before + Thread.currentThread().name)
    delay(millis) // non-blocking delay for millis milliseconds 
    println(after + "Waited for $millis ms before executing on ${Thread.currentThread().name}")
    
}
```

