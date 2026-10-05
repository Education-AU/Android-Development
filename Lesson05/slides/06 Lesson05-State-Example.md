---
title: Life Cycle of Composables
template: two-column
---
This is a Composable it contains two “states”.

One mutable state `countState`
And one “fixed immutable” `countFixedState`.

It is equipped with two buttons increasing each state in their respective onclick handlers.

When the onclick handlers are activated, the state is attempted to be changed.

When a mutable state is updated, it triggers a re-composition and therefore the composable is  re-rendered

<!-- column -->

```kotlin
@Composable
fun StateComponent(start: Int) {
    var countState = remember { mutableIntStateOf(start) }
    var countFixedState = remember { start }

    Column {
        Button(onClick = {
            countState.value += 1
        }) {
            Text("Button For Count State: ${countState.value}")
        }

        Button(onClick = {
            countFixedState += 1
        }) {
            Text("Button For Count Fixed State: $countFixedState")
        }
    }
}
```