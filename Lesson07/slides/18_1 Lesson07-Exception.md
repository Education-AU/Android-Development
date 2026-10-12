---
title: Exceptions in coroutines
template: two-column
codeSource: assets/kotlin/Exceptions1.kt
---

#### First experiment

```text
1. From Run Blocking main @coroutine#1
2. Job 1 started main @coroutine#2
3. Job 11 started main @coroutine#3
4. Job 12 started main @coroutine#4
5. Done from job 12 NOT CANCELEDWaited for 3000 ms before executing on main @coroutine#4
6. Job 11 failed with an exception of type JobCancellationException: Parent job is Cancelling
7. Job 1 failed with an exception of type JobCancellationException: StandaloneCoroutine is cancelling
Exception in thread "main" java.lang.IllegalArgumentException: Job 12 failed with an exception
 at FileKt$main$1$job1$1$job12$1.invokeSuspend (File.kt:21) 
 at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith (ContinuationImpl.kt:34) 
 at kotlinx.coroutines.DispatchedTaskKt.resume (DispatchedTask.kt:235)    
```

<!-- column -->

We see that

1. The `RunBlocking` start its `delayAndPrint` nothing happened yet
2. The `Job 1` started, and it started its child jobs `Job 11` and `Job 12` nothing happened yet
3. The child job `Job 11` started
4. The child job `Job 12` started
5. The `Job 12` finished its delay and printed the message. Now the exception is thrown from Job12
6. The exception is propagated to its parent `Job1` which cancels sibling `Job 11`, which can be seen by catch and
   rethrow of `CancellationException` in `Job 11`
7. The parent job `Job1` is canceled,which can be seen by catch and rethrow of `CancellationException` in `Job 1`
8. The exception thrown propagates to calling thread

**Here we make a very important observation:**

`CancellationException` is a special exception that is used by the framework for
cancellation of coroutines it should **NOT be caught without rethrow**