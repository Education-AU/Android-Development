---
title: Conditional Rendering
template: default
---

Instead of creating new activities for each condition, we can use conditional rendering to show or hide elements based
on certain conditions. This allows us to create more dynamic and interactive user interfaces.

This is more convenient if the change of UI is simple and does not require a new activity. For example, we can use
conditional rendering to show or hide three screens `Home`, `Settings`, and `Profile`.

```kotlin
class LauncherActivity : ComponentActivity() {
    private val state = mutableStateOf("HOME")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                AppScaffold(toProfile = {state.value = "PROFILE"},
                    toSettings = {state.value = "SETTINGS"}) {
                    when (state.value) {
                        "HOME" -> {Home()}
                        "PROFILE" -> {Profile {state.value = "HOME"}}
                        "SETTINGS" -> {Settings {state.value = "HOME"}}
                        else -> {
                            state.value = "HOME"
                        }
                    }}}}}}

```