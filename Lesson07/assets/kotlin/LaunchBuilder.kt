import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
fun main() {
    runBlocking {
        println("Start coroutine ${Thread.currentThread().name}")
        val job1 = launch {
            println("first launch ${Thread.currentThread().name}")
            delay(1000)
            println("first launch Done ${Thread.currentThread().name}")
        }

        val job2 = launch {
            println("second launch ${Thread.currentThread().name}")
            delay(1000)
            println("Second launch Done ${Thread.currentThread().name}")
        }

        println("End coroutine ${Thread.currentThread().name}")
    }
    println("Run blocking done ${Thread.currentThread().name}")
}