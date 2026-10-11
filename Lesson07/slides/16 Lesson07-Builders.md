---
title: Coroutine Scope Builders
template: two-column
codeSource: assets/kotlin/CoroutinScopeBuider.kt
---
#### CoroutineScopeBuilder.kt
```kotlin
fun main() {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            delayAndPrint(1000, "From independent Scope 1 ")
            val result = coroutineScope {
                launch { delayAndPrint(5000, "From child Scope 1 ","Done ") }
                launch { delayAndPrint(5000, "Form child Scope 2 ","Done ") }
                return@coroutineScope "Child Done"
            }
            println(result)
            delayAndPrint(1000, "From independent Scope 2 ")

        }
        job.join()
    }
}
```
<!-- column -->
```text
1. From independent Scope 1 DefaultDispatcher-worker-1 @coroutine#2
2. Waited for 1000 ms before executing on DefaultDispatcher-worker-1 @coroutine#2
3. From child Scope 1 DefaultDispatcher-worker-2 @coroutine#3
4. Form child Scope 2 DefaultDispatcher-worker-2 @coroutine#4
5. Done Waited for 5000 ms before executing on DefaultDispatcher-worker-1 @coroutine#3
6. Done Waited for 5000 ms before executing on DefaultDispatcher-worker-1 @coroutine#4
7. Child Done
8. From independent Scope 2 DefaultDispatcher-worker-1 @coroutine#2
9. Waited for 1000 ms before executing on DefaultDispatcher-worker-1 @coroutine#2
```