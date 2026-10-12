import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers

fun main() {
    runBlocking {
        val job1 = launch {
            delayAndPrint(5000, "Job1 started ", "Job1 Done NOT CANCELLED ")
        }
        val job2 = launch {
            delayAndPrint(1000, "Job2 started ", "Job2 Done NOT CANCELLED ")
            throw IllegalArgumentException("Job2 failed with an exception")
        }

        delayAndPrint(500, "From Run Blocking ", "Done from run blocking NOT CANCELLED ")

    }
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