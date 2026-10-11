import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
fun main() {
    runBlocking(context = Dispatchers.IO) {
        val job1 = launch { delayAndPrint(1) }
        val job2 = launch { delayAndPrint(1) }
        val job3 = launch { delayAndPrint(1) }
        val job4 = launch { delayAndPrint(1) }
        val job5 = launch { delayAndPrint(1) }
        val job6 = launch { delayAndPrint(1) }
        println("Last in scope")
    }
    println("After Block")
}

suspend fun delayAndPrint(
    millis: Long,
    before: String = "Start delay and print on thread ",
    after: String = ""
) {
    println(before + Thread.currentThread().name)
    delay(millis) // non-blocking delay for millis milliseconds
    println(after + "Waited for $millis ms before executing on ${Thread.currentThread().name}")

}