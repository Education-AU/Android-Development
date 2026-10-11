---
title: Global Scope
template: two-column
---

`GlobalScope` works in both Kotlin/JVM programs and Android apps. It launches coroutines without a parent job;
the caller neither waits for them nor automatically cancels them.

**Kotlin/JVM program:** global coroutines do not keep the process alive. A command-line program can exit when
`main` returns, before their work finishes. Use `join()` to wait explicitly.

**Android app:** the process can remain alive after an Activity is destroyed, so global work can continue.
It is not cancelled when an Activity is destroyed or a ViewModel is cleared. If Android kills the process,
the work stops without guaranteed cleanup.

`GlobalScope` is process-wide, **not lifecycle-managed**. Prefer a managed `CoroutineScope` in Kotlin/JVM,
or `lifecycleScope` / `viewModelScope` for Android lifecycle-bound work. Use this delicate API only for intentionally process-wide work.

**Avoid `GlobalScope` in normal application code, on both JVM and Android.**
An explicitly managed scope provides cancellation and shutdown control; `GlobalScope` is reserved for rare, intentionally process-wide tasks.

<!-- column -->

```kotlin runnable
import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(100)
        println("Global coroutine finished")
    }

    job.join()
    println("Caller continues")
}
```

Here, `join()` explicitly waits for the global coroutine. Without it, this program could exit before the coroutine finishes.
