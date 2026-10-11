---
title: Run Blocking
template: Default
---

<div class="center-left">

* A **coroutine builder** that creates a coroutine and a scope for launching additional coroutines.
* Blocks the calling thread until the coroutine and its children complete.
* By default, executes on the calling thread.
* Coroutines can suspend and resume, so their completion order may differ from their start order.
* An unhandled exception can cause cancellation to propagate through the coroutine hierarchy.

**Typical use:** Bridging synchronous code and coroutines, especially at the program's entry point and in tests.

</div>
