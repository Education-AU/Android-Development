---
title: Menus Example
template: two-column
---
```kotlin
@Composable
fun Menu(modifier: Modifier = Modifier) {
    Column(modifier: Modifier = Modifier) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            IconButton(onClick = { Log.v(TAG, "Home") }){
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")}
            Text(text = "Home")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            IconButton(onClick = { Log.v(TAG, "Search") }){
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")}
            Text(text = "Search")}
    }
}


@Preview
@Composable
fun MenuPreview() {
    Menu(modifier = Modifier.fillMaxWidth())
}
```

<!-- column -->
<div class="center">

<img src="./assets/Menus.png" alt="Menus" width="80%">

</div>

