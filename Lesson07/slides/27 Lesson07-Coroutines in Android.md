---
title: Coroutines in Composables
template: two-column
---

#### rememberCoroutineScope

`rememberCoroutineScope()` returns a scope tied to the composable's place in the composition.

- The same scope is retained across recompositions.
- Its coroutines are cancelled when that composable leaves the composition.
- On Android, it uses the main/UI dispatcher by default.
- Use it to launch work from **callbacks**, such as button clicks.
  Do not call `launch` directly in the composable body: recomposition could start the work repeatedly.

Use `LaunchedEffect` instead for work that should start when entering the composition and restart when its keys change.
Use `viewModelScope` for work that should outlive the composable.

<!-- column -->

```kotlin
@Composable
fun MessageButton() {
    val scope = rememberCoroutineScope()
    val snackbar = remember { SnackbarHostState() }

    androidx.compose.foundation.layout.Column {
        Button(onClick = {
            scope.launch {
            //make some calculations or fetch data from the network
                snackbar.showSnackbar("Hello!")
            }
        }) {
            Text("Show message")
        }
        SnackbarHost(hostState = snackbar)
    }
}
```

`showSnackbar()` suspends without blocking the UI thread. Leaving the composition cancels the coroutine if it is still running.
