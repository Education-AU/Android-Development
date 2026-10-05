---
title: State in navigation
template: two-column
---
Let us equip the items with some state enabling us to experiment with this
But first let generalize the item composable to make things easier.
 
```kotlin
@Composable
fun NavigationItem(
    title: String,
    navigationText: String,
    isBackHandlerActive: Boolean = false,
    back: () -> Unit = {},
    navigate: () -> Unit
) {
    val state = remember { mutableIntStateOf(0) }
    DisposableEffect(key1 = state.intValue) {
        Log.v(TAG, "Disposable effect in $title State is ${state.intValue}")
        onDispose {
            Log.v(TAG, "Maybe Disposing $title")
        }
    }
    BackHandler {
        if (isBackHandlerActive) {
            back()
        }}}
```
<!-- column -->

```kotlin

Column {
    IconButton(onClick = back) {
        Icon(Icons.AutoMirrored.Default.ArrowBack,contentDescription = "Back")
    }
    Text(title)
    Button(onClick = navigate) {Text(navigationText)}
    Button(onClick = { state.intValue += 1 }) {
        Text("Change state ${state.value}")
    }
}

```