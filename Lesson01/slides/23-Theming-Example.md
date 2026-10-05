---
title: Theming Example
footerVariant: dark
template: default
---
And then we make some color adjustments to our UI.

```kotlin
setContent {
    TestTheme(dynamicColor = false) {
        Scaffold(
            modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background)
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .width(200.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.tertiary)
                    ) {
                    Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
     }
````    
      
    