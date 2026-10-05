---
title: Used in Activity
template: default
---

```kotlin
class YetAnotherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicExamplesTheme(dynamicColor = false) {
                val state = remember {mutableStateOf("Home")}
                val models = listOf(
                    MenuModel(Icons.Default.Home,"Home") {state.value = "Home"},
                    MenuModel(Icons.Default.Search, "Search") {
                        state.value = "Search"
                    },
                )
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Drawer(models) {
                            when (state.value) {
                                "Home" -> Horse(modifier = Modifier.fillMaxSize())
                                "Search" -> Earth(modifier = Modifier.fillMaxSize())
                            }}}}}}}
```        
