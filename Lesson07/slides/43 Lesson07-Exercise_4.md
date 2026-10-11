---
title: Exercise 2
template: default
eyebrow: Android Exercise
---
This function factorizes a number into primes which will be a long-lasting function for big numbers such as 10877683870

```kotlin runnable
fun main(){
    println(factorize(123))
}
fun factorize(n: Long): List<Long> {
    val factors = mutableListOf<Long>()
    var remaining = n
    var divisor = 2L
    while (remaining > 1) {
        while (remaining % divisor == 0L) {
            factors.add(divisor)
            remaining /= divisor
        }
        divisor++
    }
    return factors
}
```
It is to be used in an Android App described in next slide.