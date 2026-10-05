---
title: TopAppBar Actions
template: default
---

We can make a custom app bar of course.

```kotlin
@Composable
fun CustomTopBar(menu: () -> Unit, add: () -> Unit, search: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(width = 2.dp, color = Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = menu)
        {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }
        IconButton(onClick = add)
        {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
        IconButton(onClick = search)
        {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        }
    }
}
```

