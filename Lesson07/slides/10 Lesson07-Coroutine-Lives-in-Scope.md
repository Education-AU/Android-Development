---
title: Coroutine Must Execute in Scope
template: default
---
The Launch builder **must** be called from a coroutine scope

```kotlin runnable
import kotlinx.coroutines.launch
fun main() {
    val job1 = launch {
        println("Wait three seconds") // print after delay
        println("Executed on Thread ${Thread.currentThread().name}")
    }
}
```

Even with `kotlinx.coroutines.launch` imported, this does not compile: there is no `CoroutineScope` receiver for the `launch` extension.

