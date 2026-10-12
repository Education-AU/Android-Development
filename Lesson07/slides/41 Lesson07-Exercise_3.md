---
title: Exercise 3
template: default
eyebrow: Pure Kotlin Exercise
---

Construct a suspend function with input parameters `(text:String,delay:Long)`

That delays the call with delay milliseconds and returns the input text + the delay

In runBlocking

1. launch the suspend function with(text=“I should be first”,10000)
2. launch the suspend function with(text=“I should be second”,1000)

Clearly the shortest time finishes first because the launch is used
Now make the text should be first be printed first by using async await
