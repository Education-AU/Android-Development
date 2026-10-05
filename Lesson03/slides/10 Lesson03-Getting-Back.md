---
title: Getting back
template: two-column
---

But we want to get back to the `LauncherActivity`:

```kotlin
class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                Profile() {
                    finish() 
                }
            }
        }
    }
}
```

<!-- column -->

`finish()` simply destroys the newly created activity and returns to the previous one. In this case, it will return to
the `LauncherActivity`.
```kotlin
class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                Settings() {
                    finish()
                }
            }
        }
    }
}
```

