---
title: Composables
template: two-column
---

#### Single Horse Composable
```kotlin
@Composable
fun Horse(horse: Horse) {
    Column {
        Text(horse.id)
        Text(horse.name)
    }
}
```

<!-- column -->

#### List composable


```kotlin
@Composable
fun Horses() {
    val service = HorseService()
    var horses by remember { mutableStateOf<List<Horse>>(emptyList()) }
    LaunchedEffect(Unit) {
        horses = service.getAllHorses()
    }

    Column {
        horses.map { Horse(it) }
    }
}
```
