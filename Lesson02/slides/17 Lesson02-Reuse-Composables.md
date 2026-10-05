---
title: Reuse Composables
template: two-column
---
And the new refactored menu will look like

<div class="center">

<img src="./assets/NewMenu.png" alt="Menus" width="80%">

</div>

<!-- column -->
```kotlin
@Composable
fun NewMenu(models: List<MenuModel>, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        models.forEach { MenuItem(menuModel = it, modifier = modifier) }
    }
}

@Preview
@Composable
fun NewMenuPreview() {
    val menuItemModels = listOf(
        MenuModel(imageVector = Icons.Default.Home, 
                  text="Home",action={/*TODO*/}),
        MenuModel(imageVector = Icons.Default.DateRange, 
                  text="Calendar",action={/*TODO*/})
    )
    NewMenu(models = menuItemModels, modifier = Modifier.fillMaxWidth())
}
```
