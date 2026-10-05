---
title: Navigation and Arguments
template: default
---

<div class="center-left">

When navigating you can also pass arguments(parameters)

And arguments in this way can be passed to the composable

```kotlin
composable(route = "details/{friendId}") {
    val friendId = it.arguments?.getString("friendId")
    Details(getFriend = { repository.getFriend(friendId) }) {
        navController.popBackStack(route = "listView", inclusive = false)
    }
}
```

This is essential in a detail's scenario, where the details depend on some id
</div>