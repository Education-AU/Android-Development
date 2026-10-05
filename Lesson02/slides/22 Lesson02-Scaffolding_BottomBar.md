---
title: BottomBar 
template: two-column
---
We can add further icons by actions:

```kotlin
TopAppBar(title = { Text(text = "Test") },
    navigationIcon = {
        IconButton({ Log.v("TopBar", "Navigation clicked") }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Navigation Icon"
                        )
                    }
                },
    actions = {IconButton({ Log.v("TopBar", "Build clicked") }) {
               Icon(imageVector = Icons.Default.Build,
               contentDescription = "Build Icon")
               }
               IconButton({ Log.v("TopBar", "Account clicked") }) {
               Icon(imageVector = Icons.Default.AccountCircle,
               contentDescription = "Account Icon")
               }
}   
```

<!-- column -->
 
<div class="center">

<img src="./assets/TopBar3.png" alt="TopAppBar" width="30%">

</div>

