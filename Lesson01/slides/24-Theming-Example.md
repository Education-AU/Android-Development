---
title: Theming Example
footerVariant: dark
template: default
---


```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        style = TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        ),
        text = "Hello $name!",
        modifier = modifier
    )
}
````    
<div class="text-image-row">
  <img src="assets/Dark.png" alt="Open DeviceManager" width="150">
  <img src="assets/Light.png" alt="Add Device" width="150">
</div>      
    