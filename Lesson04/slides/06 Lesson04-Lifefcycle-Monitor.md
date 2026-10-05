---
title: Lifecycle Monitor
template: two-column
---

In order to follow the lifecycle of the activities we construct a base activity that logs the lifecycle events. The base
activity is then extended by the other activities.

```kotlin
open class LoggedActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(this::class.simpleName, "CREATING")
        }

    override fun onStart() {
        super.onStart()
        Log.v(this::class.simpleName, "STARTING")
        }

    override fun onResume() {
        super.onResume()
        Log.v(this::class.simpleName, "RESUMING")
        }

    
}
```

<!-- column -->

```kotlin
       override fun onRestart() {
        super.onRestart()
        Log.v(this::class.simpleName, "RESTARTING")
        }

        override fun onPause() {
        super.onPause()
        Log.v(this::class.simpleName, "PAUSEING")
        }

        override fun onStop() {
        super.onStop()
        Log.v(this::class.simpleName, "STOPPING")
        }

        override fun onDestroy() {
        super.onDestroy()
        Log.v(this::class.simpleName, "Destroying")
        }

        override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.v(this::class.simpleName, "OnNewIntent ${intent?.extras?.keySet()}")
        }

```