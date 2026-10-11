import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.delay
fun main() {
    val delays = mutableListOf<Long>()
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..10) {
                launch() {
                    val delayTime = (0..1000).random().toLong()
                    delays.add(delayTime)
                    busy(i, delayTime)
                }
            }
        }
    }
    println("Completed in $time ms")
    println("Max delay: ${delays.maxOrNull()} ms")
    println("Average delay: ${delays.average()} ms")
    println("Sum of delays: ${delays.sum()} ms")
}

suspend fun busy(id: Int, time: Long) {
    println("$id running on ${Thread.currentThread().name} with delay $time ms")
    delay(time)
}