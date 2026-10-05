---
title: Theming Details
footerVariant: dark
template: default
---
The colors and typography are defined in files `Color.kt` and `Type.kt`. 


```kotlin
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
```
```kotlin
val Typography = Typography(
bodyLarge = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.Normal,
fontSize = 16.sp,
lineHeight = 24.sp,
letterSpacing = 0.5.sp
)
```
