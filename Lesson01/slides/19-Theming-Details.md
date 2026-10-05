---
title: Theming Details
footerVariant: dark
template: default
---

If the parameter dynamic color is true (the default value) the app will use the system's dynamic color scheme.

The dynamic color scheme is derived from the wallpaper colors on Android 12 and above.

If you actively set `dynamicColor=false`, it will use the `DarkColorScheme` or `LightColorScheme` defined in the top of
the file.

```kotlin
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)
```

The `primary`, `secondary`, and `tertiary` colors are used to color the app's UI elements. You can change these colors
to customize the app's appearance.

Many more colors can be overridden, such as `background`, `surface`, `onPrimary`, `onSecondary`, etc. See
the [Material Design color system](https://m3.material.io/styles/color/the-color-system/overview) for more details.

