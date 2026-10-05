---
title: Theming Example
footerVariant: dark
template: default
---

First we set the parameter `dynamicColor` to false, which means that the app will not use dynamic colors based on the
wallpaper. Instead, it will use the default color scheme defined in the theme.

```kotlin
TestTheme(dynamicColor = false) {
...
}
```

In the file colors.kt, we define some new colors for the scheme.

```kotlin


val Lime80 = Color(0xFFB9F36A)
val Lavender80 = Color(0xFFBFA7FF)
val BubblegumPink80 = Color(0xFFFF91B8)

val Olive40 = Color(0xFF527A00)
val Violet40 = Color(0xFF6840A8)
val Raspberry40 = Color(0xFFB83265)

val MidnightPlumBackground = Color(0xFF21182B)
val VanillaBackground = Color(0xFFFFF8E8)
````    
      
    