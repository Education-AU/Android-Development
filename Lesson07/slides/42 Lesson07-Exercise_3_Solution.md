---
title: Exercise 3 Solution
template: default
showFooter: false
codeSource: assets/kotlin/Excercise_3_Solution.kt
---

#### Exercise_3_Solution.kt
```kotlin

fun main() {
    runBlocking {
        /*launch() {
            println(busy("I should be first", 100))
        }
        launch() {
            println(busy("I should be second", 300))
        }*/
        val res1 = async() {
            busy("I should be first", 100)
        }
        val res2 = async() {
            busy("I should be second", 300)
        }
        println(res2.await())
        println(res1.await())
    }
}
suspend fun busy(text: String, time: Long): String {
    delay(time)
    return "$text running on ${Thread.currentThread().name} with delay $time ms"
}
```

