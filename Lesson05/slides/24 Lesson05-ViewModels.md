---
title: ViewModel in Composable
template: default
---
The view model is defined by using the factory method viewModel()

```kotlin
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SimpleViewModelComponent() {
    val viewModel: SimpleViewModel = viewModel() 
    // Done by reflection from type; must have default constructor

    Column {
        Text("Counter:${viewModel.counter()}")
        Button(onClick = {
            viewModel.increaseCounter()
        }) {
            Text("Increase Counter")
        }
    }
}
```
