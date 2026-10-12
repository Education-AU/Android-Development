---
title: Coroutine Builders
template: default
---

<div class="center-left">

The `runblocking` function builds a coroutine scope as mentioned and the block of code is a coroutine executing in the
scope of this **coroutine builder**.

We will get to other builders later but for now, let's see how this works.

#### Example 1

```kotlin runnable
import kotlinx.coroutines.runBlocking
fun main() {
    runBlocking {
        println("Start coroutine on Thread ${Thread.currentThread().name}")
        Thread.sleep(2000)
        println("End coroutine on Thread ${Thread.currentThread().name}")
    }
}
```

This of course is not impressive. But inside this scope we can execute new coroutines using various builders.

So we proceed with the coroutine builder `launch` which is used to launch a new coroutine without blocking the current
thread and returns a reference to the coroutine as a `Job`.

</div>
