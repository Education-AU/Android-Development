---
title: Coroutine Scopes
template: default
---

<div class="center-left">

Coroutines are launched in a **coroutine scope**

A coroutine scope organizes related coroutines under a common context and lifecycle. Conceptually, it keeps a set of coroutines together so that their execution can be managed collectively.

A scope provides, among other things:

* **Execution context:** A dispatcher determines which thread or threads are used to execute the coroutines.
* **Lifecycle management:** Coroutines can be cancelled collectively when their scope is cancelled.
* **Structured concurrency:** Coroutines can be organized into a hierarchy, allowing their lifecycles to be managed in relation to one another.

Each coroutine maintains the state needed to suspend and resume its execution. The coroutine machinery manages when and where the coroutines execute.

</div>
