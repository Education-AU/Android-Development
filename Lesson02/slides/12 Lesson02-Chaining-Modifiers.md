---
title: Chaining modifiers
template: two-column
---


```kotlin
@Composable
fun FirstBox(modifier:Modifier){
    Box(modifier=modifier){}
}
```
```kotlin
@Composable
fun SecondBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.then(
            Modifier.height(60.dp)
                .width(60.dp)
                .background(color = Color.Red)
                .border(width = 20.dp, color = Color.Blue)))
}
```

<!-- column -->

```kotlin
@Preview
@Composable
fun BoxesPreview() {
    BasicExamplesTheme(dynamicColor = false) {
        val modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .background(color = Color.Blue)
            .border(width = 10.dp, color = Color.Red)
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FirstBox(modifier)
            SecondBox(modifier)
        }
    }
}

```
