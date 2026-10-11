import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
fun main() {
    runBlocking {
        val job1 = launch {
            println("Job 1 before suspending")
            delay(3000L)
            println("Finished job 1 on Thread ${Thread.currentThread().name}")
        }
        val job2 = launch {
            println("Job 2 before suspending")
            delay(2000L)
            println("Finished job 2 on Thread ${Thread.currentThread().name}")
        }
        val job3 = launch {
            println("Job 3 before suspending")
            delay(1000L)
            println("Finished job 3 on Thread ${Thread.currentThread().name}")
        }
        println("Last in scope")
    }
    println("After Block")
}