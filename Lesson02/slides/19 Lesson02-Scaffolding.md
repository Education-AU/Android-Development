---
title: Scaffolds
template: two-column
---

First step is to use the scaffold composable

The scaffold takes a lot a parameters as seen from the source code

On should notice that the content parameter is a composable function that takes a PaddingValues parameter. This is the
padding that should be applied to the content of the scaffold. The innerPadding parameter is passed to the content
composable function and can be used to apply padding to the content.

But also the topBar and bottomBar are composable parameters, and they are the two other parameters, 
besides content obviously, that we will focus on
<!-- column -->

```kotlin
@Composable
fun FirstScaffold() {
    Scaffold{innerPadding->
        Box(modifier= Modifier.padding(innerPadding)) {
            //some content
        }
    }
}
```

```kotlin
@Composable
fun Scaffold(
modifier: Modifier = Modifier,
topBar: @Composable () -> Unit = {},
bottomBar: @Composable () -> Unit = {},
snackbarHost: @Composable () -> Unit = {},
floatingActionButton: @Composable () -> Unit = {},
floatingActionButtonPosition: FabPosition = FabPosition.End,
containerColor: Color = MaterialTheme.colorScheme.background,
contentColor: Color = contentColorFor(containerColor),
contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
content: @Composable (PaddingValues) -> Unit,
) 
```