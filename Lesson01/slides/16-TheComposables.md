---
title: Custom Composable Greeting
footerVariant: dark
template: default
---

#### The Third composable Greeting

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
```

This is a custom composable function that takes a parameter name of type String as a parameter and displays a greeting
message by using a library composable *Text*

The second parameter of type `Modifier` is optional and has a default value of `Modifier`, which is a rudimentary
Modifier object.

The `modifier` parameter allows for a modifier object to be passed from the parent composable.

The *Modifier* is a collection of elements that decorate or add behavior to composables.

For example, you can use a modifier to change the layout, add padding, or handle click events. It is similar to CSS in
web development, where you can apply styles to HTML elements.

