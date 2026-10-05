---
title: Lifecycle hook Launched Effect
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
<img src="./assets/LaunchLog.png" alt="Boxes" width="50%">
</div>




<!-- column -->

```kotlin
@Composable
fun OneShotLaunchedEffectComponent() {
    var count by remember { mutableIntStateOf(1) }

    LaunchedEffect(Unit) {
        Log.v("LaunchedEffectComponent", "LaunchedEffect")
    }

    Column {
        Button(onClick = { count += 1 }) {
            Text("Button increasing state:$count")
        }
    }
}

```

And we can of course still use buttons to change state and recompose the composable. But the LaunchedEffect will not be
called again since it is only called once when the composable is first composed.
<div class="text-image-row">
<img src="./assets/Launch1.png" alt="Boxes" width="20%">
<img src="./assets/Launch2.png" alt="Boxes" width="20%">
<img src="./assets/Launch3.png" alt="Boxes" width="20%">
</div>
