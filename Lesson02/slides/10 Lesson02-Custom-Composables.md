---
title: Custom Composables
template: default
---

Jetpack consists of a lot of predefined composables.

But to make anything useful you must construct your own composables.

Composables are functions!

They are annotated with `@Composable` which turns a function into a composable

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(text = "Hello $name!",modifier = modifier)
}
```

This example of a composable takes two parameters the text and a modifier that defaults to a “static” immutable Modifier
this modifier is set in the text also.

The modifier is an important object.

It is the styling object in compose, and it is equipped with a host of properties that style individual predefined
components

We will encounter this object again and again in the future

