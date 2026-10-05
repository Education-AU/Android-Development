---
title: Navigation functions
template: two-column
---

Call back function parameters added to the composable function can be used to navigate between different composables.

And use these new itmes in the `NavHost` to navigate between them.
<!-- column -->

```kotlin
@Composable
fun FirstItem(navigate:()->Unit) {
    Column {
        Text("First Item")
        Button(onClick = navigate) {
            Text("Navigate to Second Item")
        }
    }
}
```

```kotlin

@Composable
fun SecondItem(navigate:()->Unit) {
    Column {
        Text("Second Item")
        Button(onClick = navigate) {
            Text("Navigate to Third Item")
        }
    }
}
```
