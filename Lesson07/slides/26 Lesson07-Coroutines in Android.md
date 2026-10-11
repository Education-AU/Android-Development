---
title: Coroutines in Android
template: default
---
#### Keep the main thread responsive

Android handles UI updates and user input on the **main thread**.
Code called directly from UI callbacks also runs there unless you explicitly move the work elsewhere.

- Blocking I/O or long calculations on the main thread freeze the UI and can cause an **Application Not Responding (ANR)**.
- Coroutines let you suspend while waiting without blocking the thread, but **launching a coroutine does not automatically move work to a background thread**.
- Use `withContext(Dispatchers.IO)` for blocking I/O and `withContext(Dispatchers.Default)` for CPU-intensive work.
- After `withContext` finishes, a coroutine launched on `Dispatchers.Main` resumes there and can update the UI.

Choose a scope that matches the work's owner:

- **Compose:** `rememberCoroutineScope()` for work launched from callbacks, such as button clicks; cancelled when its composable leaves the composition.
- **ViewModel:** `viewModelScope` for ViewModel-owned work; cancelled when the ViewModel is cleared.
- **Activity / Fragment:** `lifecycleScope` for lifecycle-owned work; cancelled when that Lifecycle is destroyed.

These scopes use the main/UI dispatcher by default on Android; move blocking or CPU-intensive work to an appropriate background dispatcher.
