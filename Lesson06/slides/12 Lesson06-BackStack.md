---
title: BackStack Listener
template: two-column
---

The navHost constructs the graph of navigation and the NavController holds the graph and a stack
that keeps track of the composables that have been “visited” a history.

Let us track the back stack of the Nav Controller.

This is done in the code to the left which is a bit of a hack, but it works.
The code is a composable that takes the NavController as an argument and adds a listener to the controller that is
called whenever the destination changes. The listener updates two state variables, one for the current destination and
one for the back stack.

This is not for production code, but it is useful for debugging and understanding how the back stack works.

<!-- column -->

```kotlin
@SuppressLint("RestrictedApi")
@Composable
fun BackStackListener(navController: NavController) {
    val stack = remember { mutableStateOf("") }
    val destinationState = remember { mutableStateOf("") }

    navController.addOnDestinationChangedListener { controller, destination, _ ->
        destinationState.value = destination.route.toString()
        val routes = controller.currentBackStack.value.map {
            it.destination.route.toString()
        }.joinToString(",")
        stack.value = routes
        Log.v("BackStackListener", "BackStack $routes")
    }

    Spacer(modifier = Modifier.height(100.dp))
    Text("Destination: ${destinationState.value}")
    Text("BackStack: ${stack.value}")
}
```
