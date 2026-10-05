---
title: Parameter changes induce re-composition
template: two-column
---

```kotlin
@Composable
fun NonStateChildComponent(count: Int) {
    Column {
        Text("Input parameter : $count")
    }
}
```

<div class="center">
<img src="assets/Parameter1.png" alt="LifeCycle" width="40%">
<img src="assets/Parameter2.png" alt="LifeCycle" width="40%">
</div>


<!-- column -->

```kotlin
setContent {
    FirstStateTheme {
            Column {
                val state = remember { mutableIntStateOf(10) }
                Button(onClick = {
                    state.value += 1
                }) {
                    Text("Main activity Button For changing state:${state.value}")
                }
                NonStateChildComponent(state.value)
            }
        }
    }
}
```
