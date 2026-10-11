---
title: Suspend Functions
template: default
---
<div class="center-left">
The delay function is a suspending function which defines a suspension point.
Coroutines can be suspended (paused) at suspension points and then resumed later

<br><br>

```kotlin
public suspend fun delay(timeMillis: Long) {
    if (timeMillis <= 0) return // don't delay
    return suspendCancellableCoroutine sc@ { cont: CancellableContinuation<Unit> ->
        // if timeMillis == Long.MAX_VALUE then just wait forever like awaitCancellation, don't schedule.
        if (timeMillis < Long.MAX_VALUE) {
            cont.context.delay.scheduleResumeAfterDelay(timeMillis, cont)
        }
    }
}
```
<br><br>
Another way to put it is, when a suspension point is reached the scheduler takes over and decides which other coroutine(job) should be executed next.
</div>