---
title: Using the  service
template: two-column
---
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HttpClientAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        PostList()
                    }
                }
            }
        }
    }
}
```


<!-- column -->

```kotlin
@Composable
fun PostList() {
    val postsService = remember { KtorPostsService() }
    val data = remember { mutableStateOf<List<Post>>(emptyList()) }
    val isLoading = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        isLoading.value = true
        data.value = postsService.get()
        isLoading.value = false
    }
    DisposableEffect(Unit) {
        onDispose {postsService.close()}
    }
    if (isLoading.value) {
        Loader()
    } else {
        LazyColumn {
            items(data.value) {
                PostItem(post = it)
            }
        }}}
```
