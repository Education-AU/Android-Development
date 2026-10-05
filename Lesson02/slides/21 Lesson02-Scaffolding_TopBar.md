---
title: TopAppBar Navigation Icon
template: two-column
---

Then the navigation icon. You may need to add dependency for Material3 in your toml 
and build.gradle file:
```toml
androidx-compose-material-icons-core = { group = "androidx.compose.material", name = "material-icons-core" }
```
```kotlin
@OptIn(ExperimentalMaterial3Api::class)
    Scaffold(
        topBar = {TopAppBar(
                title = { Text(text = "Test") },
                navigationIcon = {
                    IconButton({ Log.v("TopBar", "clicked") }) {
                        Icon(imageVector = Icons.Default.Menu,contentDescription = "Icon")}},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary))}
    ) 
}   
```

<!-- column -->
When the burger menu is clicked the message is logged 
<div class="center">

<img src="./assets/TopBar2.png" alt="TopAppBar" width="30%">

</div>

```text
2026-10-03 14:06:30.247 11721-11721 TopBar  com.howard.test   V  clicked
```