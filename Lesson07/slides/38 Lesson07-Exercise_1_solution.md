---
title: Exercise 1
template: default
---

```kotlin runnable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..15) {
                launch() {
                    busy(i, 100)
                }
            }
        }
    }
    println("Completed in $time ms")
}

fun busy(id: Int, time: Long) {
    val startTime = System.currentTimeMillis()
    
    println("$id before spinning running on ${Thread.currentThread().name} for $time ms")
    while (startTime + time > System.currentTimeMillis()) {
        //spinning
    }
}
```
