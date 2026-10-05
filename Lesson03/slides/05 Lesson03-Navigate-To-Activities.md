---
title: The Activities to Navigate to
template: two-column
---
What we potentially want to do is navigate to other activities. The other activities could be

```kotlin
class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                Profile() {
                    // Do something
                }
            }
        }
    }
}
```
<!-- column -->
```kotlin
class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                Settings() {
                    // Do something
                }
            }
        }
    }
}
```