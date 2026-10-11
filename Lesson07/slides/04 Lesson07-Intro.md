---
title: What are Coroutines
template: default
---

<div class="center-left">

A coroutine is a block of code that can be suspended and resumed later, potentially on a different thread.

Unlike a regular function, a coroutine does not have to execute from start to finish without interruption. 

It can suspend its execution and resume when it is ready to continue, without blocking the thread it was running on.

Coroutines are best understood through examples. We will begin with pure Kotlin, without introducing any
Android-specific concepts.

</div>
