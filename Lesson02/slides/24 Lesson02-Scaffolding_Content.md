---
title: TopAppBar Actions
template: two-column
---

We also need some content in the Scaffold.

```kotlin
@Composable
fun Horse(modifier: Modifier = Modifier) {
Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.horse),
        contentDescription = "Horse"
    )
}
```

And this is put into the Scaffold content:

```kotlin
@Composable
fun FirstScaffold() {
    Scaffold(
        topBar = {TopAppBar(
                title = { Text(text = "Test") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary))}
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){Horse()}
    }
}
```

<!-- column -->

<div class="center">

<img src="./assets/Horse.png" alt="Horse" width="30%">

</div>

