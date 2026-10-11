import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
fun main() {
    runBlocking() {
        val job1 = launch(context = newSingleThreadContext("Thread-one")) { delayAndPrint(1L) }
        val job2 = launch(context = newSingleThreadContext("Thread-two")) { delayAndPrint(1L) }
        val job3 = launch(context = Dispatchers.Default) { delayAndPrint(400L) }
        val job4 = launch(context = Dispatchers.Unconfined) { delayAndPrint(20L) }
        val job5 = launch(context = Dispatchers.Unconfined) { delayAndPrint(20L) }
        val job6 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
        val job7 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
        val job8 = launch(context = Dispatchers.IO) { delayAndPrint(10L) }
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