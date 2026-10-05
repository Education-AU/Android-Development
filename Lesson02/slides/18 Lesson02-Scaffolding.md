---
title: Scaffolds
template: two-column
---


Scaffold is a built-in composable that offers the easy construction of top and bottom bars.
It is by default present in the empty-activity template

```kotlin
setContent {
    TestTheme(dynamicColor = false) {
        Scaffold(modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
        ) { innerPadding ->
        // some content
}}
```
<!-- column -->

<div class="center">

<img src="./assets/Scaffold_Ex1.png" alt="Menus" width="50%">

</div>
