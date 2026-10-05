---
title: Manually Popping
template: two-column
---
As we saw the back button seems to pop from the stack. This is indeed what it does
We could do this ourselves by introducing a special  Third Item version

The third item is now able to navigate
But say we want not to go back just to
second item BUT first item.

<!-- column -->

```kotlin
composable(route = "thirdItem") {
    ThirdItemPopButton {
        navController.popBackStack(
            route = "firstItem",
            inclusive = false
        )
    }
}
```

```kotlin
@Composable
fun ThirdItemPopButton(navigate: () -> Unit) {
    Column {
        Text("Third Item")
        Text("End of the road")
        Button(onClick = navigate) {
            Text("<- Back")
        }
    }
}
```
