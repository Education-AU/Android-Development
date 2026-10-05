---
title: The Drawer Elements
template: default
---
#### Drawer Sheet

```kotlin
drawerContent = {
            ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.7f)) {
                Button(onClick = { scope.launch { drawerState.close() } }) {
                    Text("Close")
                }
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    models.forEach {
                        MenuItem(
                            menuModel = it.copy(action = {
                                scope.launch {
                                    it.action()
                                    drawerState.close()
                                 }
                             })}}}
```        
        
The drawer sheet is built in composable for constructing/configuring a sheet