import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

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

suspend fun delayAndPrint(
    millis: Long,
    before: String = "Start delay and print on thread ",
    after: String = ""
) {
    println(before + Thread.currentThread().name)
    delay(millis) // non-blocking delay for millis milliseconds
    println(after + "Waited for $millis ms before executing on ${Thread.currentThread().name}")

}