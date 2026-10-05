---
title: NavController
template: default
---

The nav controller is a data structure keeping track of the back stack of composables and their states

To use the nav controller it must be saved in a state with

```kotlin
val navController = rememberNavController ()
```

The nav controller state must be visible to all composables, that can interact with it
Therefore, the nav controller must be instantiated in the top of the hierarchy where it is used
 
