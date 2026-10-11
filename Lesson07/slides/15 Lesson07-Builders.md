---
title: Coroutine Scope Builder
template: default
---

There are other ways to create a new scope besides the runBlocking

1. Using the suspend function `coroutineScope`
2. Using the non-suspend `CouroutineScope`

The **suspend** function `coroutineScope` creates a coroutine scope tied
as a child coroutine scope to the surrounding coroutine .

And this child coroutine must finish before the surrounding coroutine proceeds, which gives the possibility of returning
a value from it

The `CouroutineScope` function creates new Coroutine Scope object and returns a reference to that scope.
To use it one should launch jobs on it. And it can easily be canceled
