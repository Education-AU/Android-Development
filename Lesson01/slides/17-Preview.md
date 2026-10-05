---
title: Preview
footerVariant: dark
template: default
---

The last element in the *MainActivity* is the preview

```kotlin
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("Android")
    }
}
```

This is a way to preview the composable function in the IDE without running the app on a device or emulator. The
`@Preview` annotation indicates that this function is meant for previewing, and the `showBackground` parameter adds a
background to the preview for better visibility. The `TestTheme` is applied to ensure that the preview reflects the
app's theme.


<div class="center">
    <img src="assets/Preview.png" alt="Preview" width="350">
</div>

