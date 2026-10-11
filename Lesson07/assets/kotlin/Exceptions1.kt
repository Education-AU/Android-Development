import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CancellationException

fun main() {
    runBlocking {
        val job1 = launch {
            try {
                val job11 = launch {
                    try {
                        delayAndPrint(5000, "Job 11 started ", "from Job 11 NOT CANCELED")
                    } catch (e: CancellationException) {
                        println("Job 11 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                        throw e
                    }
                }
                val job12 = launch {
                    delayAndPrint(3000, "Job 12 started ", "Done from job 12 NOT CANCELED")
                    throw IllegalArgumentException("Job 12 failed with an exception")
                }
                delayAndPrint(5000, "Job 1 started ", "Done from job 1 NOT CANCELED")
            } catch (e: CancellationException) {
                println("Job 1 failed with an exception of type ${e::class.simpleName}: ${e.message}")
                throw e
            }
        }
        delayAndPrint(6000, "From Run Blocking ", "from run blocking NOT CANCELED")
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