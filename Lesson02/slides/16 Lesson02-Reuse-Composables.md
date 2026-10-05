---
title: Reuse Composables
template: two-column
---
We saw in the menu composable that there was a lot of code repetition
And custom composables are exactly for getting this repetition down to a minimum

It is obvious that the row elements are duplicated for each menu item, 
so this is a candidate for a separate composable. 

Also, the parameters should be structured


<!-- column -->
```kotlin
@Composable
fun MenuItem(menuModel: MenuModel, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(start = 5.dp, end = 5.dp)
        .background(color = MaterialTheme.colorScheme.onSurface)
        .fillMaxWidth()
        .height(48.dp)
        .clickable { menuModel.action() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Icon(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.3f),
                imageVector = menuModel.imageVector,
                contentDescription = menuModel.text, 
                tint = MaterialTheme.colorScheme.surface)   
        Text(modifier = Modifier.fillMaxWidth(),text = menuModel.text,
                style = TextStyle(fontSize = 24.sp, 
                color = MaterialTheme.colorScheme.surface))
    }
}
data class MenuModel(
    val imageVector: ImageVector,
    val text: String,
    val action: () -> Unit = {}
)
```
