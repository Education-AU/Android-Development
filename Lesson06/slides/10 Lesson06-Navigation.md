---
title: Navigation Setup
template: default
---
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstNavigationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "firstItem",
                ) {
                    composable(route = "firstItem") {
                        FirstItem {
                            navController.navigate(route = "secondItem")
                        }
                    }
                    composable(route = "secondItem") {
                        SecondItem {
                            navController.navigate(route = "thirdItem")
                        }
                    }
                    composable(route = "thirdItem") {
                        ThirdItem()
                    }
                }}}}}
```
