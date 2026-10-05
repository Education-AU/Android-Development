---
title: Overriding Back Button
template: default
---
It is also possible to override the back button if so desired.

```kotlin
@Composable
fun ThirdItemPopButton(navigate: () -> Unit) {
    BackHandler {
        navigate()
    }

    Column {
        Text("Third Item")
        Text("End of the road")
        Button(onClick = navigate) {
            Text("<- Back")
        }
    }
}
```
Now the back button will jump to first item
