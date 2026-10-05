---
title: Navigation Composables
template: two-column
---
So a new clean App and some navigation items:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstNavigationTheme {

            }
        }
    }
}
```
```kotlin
@Composable
fun FirstItem() {
    Column {
        Text("First Item")
        Button(onClick = { /*TODO*/ }) {
            Text("Navigate to Second Item")
        }
    }
}
```
<!-- column -->
And make some navigation items:

```kotlin

@Composable
fun SecondItem() {
    Column {
        Text("Second Item")
        Button(onClick = { /*TODO*/ }) {
            Text("Navigate to Third Item")
        }
    }
}
```

```kotlin
@Composable
fun ThirdItem() {
    Column {
        Text("Third Item")
        Text("End of the road")
    }
}
``` 