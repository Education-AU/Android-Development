---
title: Activities
template: two-column
---


```kotlin
class PiActivity : LoggedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOfPiTheme {
                Column() {
                    Text("PI Activity")
                    Button(onClick = {
                        Log.v(this@PiActivity::class.simpleName, "Go to Tiger")
                        val intent = Intent(this@PiActivity, TigerActivity::class.java)
                        intent.putExtra("message", "Hello from PiActivity")
                        startActivity(intent)
                    }) {Text("Go to Tiger")}
                }
            }
        }
    }
}

```

<!-- column -->

```kotlin
class TigerActivity : LoggedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOfPiTheme {
                Column() {
                    Text("Tiger: ${intent.getStringExtra("message")}")
                    Button(onClick = {finish()}) {
                        Text("Back to Pi")
                    }
                }
            }
        }
    }
}
```