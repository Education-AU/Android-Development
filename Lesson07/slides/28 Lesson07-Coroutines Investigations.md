---
title: Coroutine Investigations
eyebrow: Will be demonstrated
template: default
---

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutineInvestigationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlockingFetch()
                    //ScopeFetch()
                    //ScopeFetchContext()
                    //FetchLaunchedEffectContext()
                }
            }
        }
    }
}
```
