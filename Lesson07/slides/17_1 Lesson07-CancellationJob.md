---
title: Coroutine Cancellation
template: two-column
codeSource: assets/kotlin/CancelJobs.kt

---

Coroutine scopes are also canceled by exceptions

```
#### output:
```text
1. From Run Blocking main @coroutine#1
2. Job1 started main @coroutine#2
3. Job2 started main @coroutine#3
4. Done from run blocking NOT CANCELLED Waited for 500 ms before executing on main @coroutine#1
5. Job2 Done NOT CANCELLED Waited for 1000 ms before executing on main @coroutine#3
6. Exception in thread "main" java.lang.IllegalArgumentException: Job2 failed with an exception
 at FileKt$main$1$job2$1.invokeSuspend (File.kt:13) 
 at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith (ContinuationImpl.kt:34) 
 at kotlinx.coroutines.DispatchedTaskKt.resume (DispatchedTask.kt:235) 
```

Here we observe that the exception thrown in Job2 cancels the entire runBlocking scope, and Job1 is not completed. The
output shows that Job1 was started but did not finish before the exception occurred.
<!-- column -->

#### CancelJobs.kt

```kotlin

fun main() {
    runBlocking {
        val job1 = launch {
            delayAndPrint(5000, "Job1 started ", "Job1 Done NOT CANCELLED ")
        }
        val job2 = launch {
            delayAndPrint(1000, "Job2 started ", "Job2 Done NOT CANCELLED ")
            throw IllegalArgumentException("Job2 failed with an exception")
        }

        delayAndPrint(500, "From Run Blocking ", "Done from run blocking NOT CANCELLED ")

    }
} 
```
