---
title: State in navigation
template: two-column
---

```kotlin
@Composable
fun Navigation1() {
    val controller = rememberNavController()

    Column {
        NavHost(navController = controller, startDestination = "First") {
            composable(route = "First") {
                NavigationItem(
                    title = "First",
                    navigationText = "Navigate to Second"
                ) {
                    controller.navigate(route = "Second")
                }
            }
            composable(route = "Second") {
                NavigationItem(
                    title = "Second",
                    navigationText = "Navigate to Third",
                ) {
                    controller.navigate(route = "Third")
                }
            }
}
```

<!-- column -->

```kotlin
composable(route = "Third") {
    NavigationItem(title = "Third",
        navigationText = "Navigate to first by popping",
        back = { controller.popBackStack(route = "First", inclusive = false) }
     ) {
        controller.popBackStack(route = "First", inclusive = false)
        }
    }
    BackStackListener(controller)
```
