---
title: Conditional Rendering
template: default
---

The state  
```kotlin
private val state = mutableStateOf("HOME")
```

Is a special data type that has the effect that if it changes the component re-renders


This will make the `when`  switch render the composable that is determined by the state

```kotlin
when (state.value) {
    "HOME" -> {Home()}
    "PROFILE" -> {Profile {state.value = "HOME"}}
    "SETTINGS" -> {Settings {state.value = "HOME"}}
    else -> {
        state.value = "HOME"
    }
}
```

This VERY SIMPLE example is the inspiration/motivation for navigation


Navigation is a framework that handles this kind of conditional-rendering in a much more general setting!
