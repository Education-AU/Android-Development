---
title: TopAppBar
template: two-column
---

We want to put in a top bar in the scaffold

The `TopAppBar` is a composable function that allows us to create a top app bar
with a title, navigation icon, actions and other parameters such as colors.Notice the optin annotation for the
experimental material3 api. This is because the top app bar is still in experimental stage and may change in future
releases.

First we start simple with a title and no navigation icon or actions.

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScaffold() {
    Scaffold(
        topBar = {TopAppBar(
                title = { Text(text = "Test") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary))}
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }
}
```

<!-- column -->

```kotlin
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
)
```

<div class="center">

<img src="./assets/TopBar1.png" alt="TopAppBar" width="30%">

</div>
