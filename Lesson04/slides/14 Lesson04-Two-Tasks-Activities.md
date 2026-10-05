---
title: More Than One Task
template: default
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
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            startActivity(intent)
                        }) {
                            Text("Go to Tiger")
                        }}}}}}


```