---
title: The Composables
template: two-column
---
Where the `Profile()` and `Settings()` are two simple composables

```kotlin
@Composable
fun Profile(back: () -> Unit) {
    Box(modifier = Modifier.padding(top = 50.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(50.dp)) {
            IconButton(onClick = back) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "back"
                )
            }
            Text("MyProfile")
        }
    }
}
```
<!-- column -->
```kotlin
@Composable
fun Settings(back:()->Unit){
    Box(modifier = Modifier.padding(top = 50.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(50.dp)) {
            IconButton(onClick = back) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "back"
                )
            }
            Text("MySettings")
        }
    }
}
```