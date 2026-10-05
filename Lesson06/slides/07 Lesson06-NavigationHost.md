---
title: NavHost
template: two-column
---

This composable holds the possible composables that can be navigated to. 
And the route associated with each composable. 

Also, it specifies the initial composable to render

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FirstNavigationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "firstItem"
                ) {
                    composable(route = "firstItem") { FirstItem() }
                    composable(route = "secondItem") { SecondItem() }
                    composable(route = "thirdItem") { ThirdItem() }
                }
            }
        }
    }
}
```

<!-- column -->

<div class="center">
<img src="assets/NavHost.png" alt="NavHost Test" width="50%">
</div>