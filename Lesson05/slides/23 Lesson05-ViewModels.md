---
title: ViewModels
template: default
---

As seen, the view model inherits from ViewModel.

The view model is a class so no `remember` is needed

And the View model is remembered in the composable once instantiated in the composable

```kotlin
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    private val counterState = mutableIntStateOf(0)

    fun counter(): Int {
        return counterState.value
    }

    fun increaseCounter() {
        counterState.value += 1
    }
}
```
