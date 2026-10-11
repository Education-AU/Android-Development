---
title: Coroutines
template: default
---
<div class="center-left">
Coroutines is a tool heavily used in asynchronous programming, which is essential in most applications.


The use of asynchronous methods is obvious in frontend parts of an application in order not to block the user, but also in backend applications 
not to block too many threads.

Coroutines are not a part of Kotlin as such and should be included as a dependency (not in Android projects here, where it is implicit).

```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
```
</div>
