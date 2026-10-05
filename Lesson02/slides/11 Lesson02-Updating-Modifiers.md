---
title: Configuring Modifier
template: default
---
The invocation of functions on Modifier generates new objects of type Modifier


```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onBackground)
            .padding(16.dp),
    )
}
```
