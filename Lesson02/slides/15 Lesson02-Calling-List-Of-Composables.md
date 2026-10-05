---
title: Iterating composables
template: two-column
---
```kotlin
@Composable
fun StringColumn(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        text.split(" ").forEach { Text(text = it) }
    }
}

@Preview
@Composable
fun StringColumnPreview(){
    StringColumn(text = "I have my horse I have my pony")
}
```

<!-- column -->
<div class="center">

<img src="./assets/ListString.png" alt="Menus" width="80%">

</div>

