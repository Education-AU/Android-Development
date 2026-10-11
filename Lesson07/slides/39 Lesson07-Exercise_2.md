---
title: Exercise 2
template: default
eyebrow: Pure Kotlin Exercise
---

Construct a **suspend** function with parameters: `(id:Int , delay:Long)`

Which:

1. Prints the id and the thread name of the executing thread.
2. Delays the call with delay milliseconds

In a `runBlocking` block launch the function say 10 times with respective ten ids and delay being a random time between
0 and 1000 ms

Measure the time for executing the runBlocking block
and compare this time with the max random delay the average delay and the sum of all delays

Discuss the result
