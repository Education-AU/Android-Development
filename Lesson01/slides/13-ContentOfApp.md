---
title: Code Content
footerVariant: dark
template: two-column
---


The method *onCreate* is one of the hooks into the lifecycle of an activity


<div class="center">
    <img src="assets/LifeCycle.png" alt="LifeCycle" width="350">
</div>






<!-- column -->


```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
```