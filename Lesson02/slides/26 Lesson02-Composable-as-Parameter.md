---
title: Composable as Parameter
template: default
---

Sometimes it is desirable to implement a composable that can take another composable as parameter. In scaffolding
composables say.

```kotlin
@Composable
fun ThirdScaffold(content: @Composable () -> Unit) {
    Scaffold(
        topBar = {...},
        bottomBar = {...}
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}

```

