import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers

fun main() {
    runBlocking {
        val job1 = launch(Dispatchers.IO) {
            delayAndPrint(100, "Job 1 started ", "from Job 1")
        }
        val job2 = launch(Dispatchers.IO) {
            delayAndPrint(1000, "Job 2 started ", "from job 2")
        }

        delayAndPrint(100, "From Run Blocking ", "from run blocking")
        job2.cancel()
        job1.join()
        job2.join()
    }
}

suspend fun delayAndPrint(
    millis: Long,
    before: String = "Start delay and print on thread ",
    after: String = ""
) {
    println(before + Thread.currentThread().name)
    delay(millis) // non-blocking delay for millis milliseconds
    println(after + " Waited for $millis ms before executing on ${Thread.currentThread().name}")

}