import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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