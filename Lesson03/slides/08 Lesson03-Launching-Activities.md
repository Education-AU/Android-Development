---
title: Launch Activity Programmatically
template: default
---
Next question:

How to launch those new activities programmatically from the `LauncherActivity`?

```kotlin
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                AppScaffold(
                    toProfile = {
                         val intent = Intent(this, ProfileActivity::class.java)
                         startActivity(intent)
                    },
                    toSettings = {
                       val intent = Intent(this, SettingsActivity::class.java)
                       startActivity(intent)
                    }
                ) {
                    Text("My Activity Stuff")
                }
            }}}}

```
