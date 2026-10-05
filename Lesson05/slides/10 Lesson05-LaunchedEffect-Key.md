---
title: Launched Effect Key Change
template: two-column
---

```kotlin
LaunchedEffect(Unit){ 
    //supplies a coroutine scope for 
    //executing statements when the composable composes or re-composes 
}
```

If no keys are given as input, that is key is set to `Unit`. The effect only fires once

<div class="center">
<img src="./assets/LaunchLog1.png" alt="Boxes" width="50%">
</div>




<!-- column -->

```kotlin
@Composable
fun LaunchedEffectComponent() {
    var count by remember { mutableIntStateOf(1) }

    LaunchedEffect(key1 = count) {
        Log.v("LaunchedEffectComponent", "LaunchedEffect")
    }

    Column {
        Button(onClick = { count += 1 }) {
            Text("Button increasing state:$count")
        }
    }
}
```

We can still use button, but now the key changes and launched effect is re-executed. The log shows that the effect is
executed again when the state changes.
<div class="text-image-row">
<img src="./assets/Launch1.png" alt="Boxes" width="20%">
<img src="./assets/Launch2.png" alt="Boxes" width="20%">
<img src="./assets/Launch3.png" alt="Boxes" width="20%">
</div>
