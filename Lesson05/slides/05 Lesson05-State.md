---
title: Life Cycle of Composables
template: default
---

<div class="center-left">
Composable state:
If a composable needs to save some state
States are stored by objects of

```kotlin
 MutableState
 ```

The build in function remember is used to remember the state that is being defined in a **function**

The syntax can be defined in three ways

```kotlin
val mutableState=remember{mutableStateOf(initial)}
var value by remember{mutableStateOf(initial)}
val (value,setValue)=remember{mutableStateOf(initial)}
```

where `initial` is the initial state.

If the remember function is used on an ordinary value, it is not mutable
Such as remember (2);
Let us look at an example


</div>