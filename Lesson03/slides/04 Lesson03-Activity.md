---
title: The Navigating Activity
template: two-column
---
The MainActivity could be a very simple activity like this:

```kotlin
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleActivitiesTheme {
                AppScaffold(
                    toProfile = {
                       
                    },
                    toSettings = {
                       
                    }
                ) {
                    Text("My Activity Stuff")
                }
            }
        }
    }
}

```
<!-- column -->
```kotlin
@Composable
fun AppScaffold(toProfile: () -> Unit, toSettings: () -> Unit, content: @Composable () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
        TopAppBar({ Text("Activities") },navigationIcon = {
                IconButton(onClick = toProfile) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
                }
        },
        actions = {IconButton(onClick = toSettings) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                  }
                })},
        ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}
```