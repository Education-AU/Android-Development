---
title: Theming Example
footerVariant: dark
template: default
---

We could also change the greeting to a button

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Button(onClick = { /* Do something */ },
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.secondary)
            .width(200.dp)
            .height(100.dp)) {
        Text(style = TextStyle(color = MaterialTheme.colorScheme.onPrimary,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            text = "Hello $name!",
        )    }}
````    

<div class="text-image-row">
  <img src="assets/ButtonDark.png" alt="Open DeviceManager" width="150">
  <img src="assets/ButtonLight.png" alt="Add Device" width="150">
</div>      
    