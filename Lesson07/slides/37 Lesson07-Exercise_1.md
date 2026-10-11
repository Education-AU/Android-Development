---
title: Exercise 1
template: default
eyebrow: Pure Kotlin Exercise
---
Construct a function

```kotlin
busy(int id,time:Long)
```

The function should “spin” in a while loop for time milliseconds. Furthermore, it should print

```text
<id> before spinning running on <threadName> for <time> ms
```

In the main function, in a runBlocking block

1. Make 15 Launch calls executing the busy function with busy time 100 ms
2. Measure the time for the whole block to finish. (use measureTimeMillis{calls})
3. Measure the time with no dispatcher set in launch and discuss if the time passed is reasonable
4. Measure the time with Dispatchers.IO set in launch and discuss if the time passed is reasonable.
5. Measure the time with Dispatchers.Default set in launch and discuss if the time passed is reasonable.

**Solution is on next page do not look at it until you have tried to solve the exercise yourself.**