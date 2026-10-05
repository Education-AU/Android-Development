---
title: Modal Navigation Drawer
template: default
---

```kotlin
@Composable
fun Drawer(models: List<MenuModel>, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
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
                                }}))}}}}) {
        Column {
            Button(onClick = { scope.launch { drawerState.open() } }) {Text("Open")}
            content()
        }}}
```