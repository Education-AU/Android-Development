---
title: Composables
template: two-column
---
```kotlin
@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(color = Color.Magenta)
            Text("Please wait while loading")
        }
    }
}
@Preview
@Composable
fun LoaderPreview() {
    Loader()
}
```
The application is demoed in the downloadable project in `ktorHttp.zip`.

<!-- column -->

```kotlin
@Composable
fun PostItem(post: Post) {
    Column {
        Row {
            Text("UserId:")
            Text(text = post.userId.toString())
        }
        Row {
            Text("Id:")
            Text(text = post.id.toString())
        }
        Row {
            Text("Title:")
            Text(text = post.title)
        }
        Row {
            Text("Body:")
            Text(text = post.body)
        }}}
```
