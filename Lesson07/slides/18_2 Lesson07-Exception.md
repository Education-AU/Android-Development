---
title: Exceptions in coroutines
template: two-column
showFooter: false
codeSource: assets/kotlin/Exceptions2.kt
---

We must not catch `CancellationExceptions` without rethrowing them, because they are used to cancel coroutines. If
we catch them and do not rethrow them, the coroutine will not be canceled as expected.

This is seen from this example:
```text
From Run Blocking main @coroutine#1
Job 1 started main @coroutine#2
Job 11 started main @coroutine#3
Job 12 started main @coroutine#4
Done from job 12 NOT CANCELEDWaited for 3000 ms before executing on main @coroutine#4
Job 11 failed with an exception of type JobCancellationException: Parent job is Cancelling
Job 11 completed successfully
Job 1 failed with an exception of type JobCancellationException: StandaloneCoroutine is cancelling
Exception in thread "main" java.lang.IllegalArgumentException: Job 12 failed with an exception
at FileKt$main$1$job1$1$job12$1.invokeSuspend (File.kt:22)
at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith (ContinuationImpl.kt:34)
at kotlinx.coroutines.DispatchedTaskKt.resume (DispatchedTask.kt:235)
```
<!-- column -->

```kotlin
    runBlocking {// main removed for presentation size but not in executable code
        val job1 = launch {
            try {
                val job11 = launch {
                    try {
                        delayAndPrint(5000, "Job 11 started ", "from Job 11 NOT CANCELED")
                    } catch (e: CancellationException) {
                        println("Job 11 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                        //throw e
                    }
                    println("Job 11 completed successfully")
                }
                val job12 = launch {
                    delayAndPrint(3000, "Job 12 started ", "Done from job 12 NOT CANCELED")
                    throw IllegalArgumentException("Job 12 failed with an exception")
                }
                delayAndPrint(5000, "Job 1 started ", "Done from job 1 NOT CANCELED")
            } catch (e: CancellationException) {
                println("Job 1 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                throw e
            }
        }
        delayAndPrint(6000, "From Run Blocking ", "from run blocking NOT CANCELED")
    }
```