---
title: The Drawer elements
template: default
---
#### Drawer State
```kotlin
val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
```

An object for holding the state of the drawer. When it changes the
ModalNavigationDrawer is re-rendered.

The states are: Open and Closed. The drawer is closed by default.

#### Coroutine Scope

```kotlin
val scope = rememberCoroutineScope()
```
The coroutine scope is used for changing the state of the drawer state. The drawer state can only be changed from a coroutine.

```kotlin
scope.launch {
    it.action()
    drawerState.close()
}
```