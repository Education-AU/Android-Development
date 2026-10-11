import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CancellationException

fun main() {
    runBlocking {
        try {
            val job1 = launch {
                throw IllegalArgumentException("Job 1 failed with an exception")
            }
        } catch (e: IllegalArgumentException) {
            println("Caught exception: ${e.message}")
        }
    }
}