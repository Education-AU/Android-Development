---
title: More Than One Task
template: default
---

```kotlin
class TigerActivity : LoggedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOfPiTheme {
                    Column() {
                        Text("Tiger")
                        Button(onClick = {
                            val intent=Intent(this@TigerActivity,PiActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            Log.v(this::class.simpleName, "Back to Pi")
                            startActivity(intent)
                        }) {Text("Back to Pi")}
                        Button(onClick = {
                            Log.v(
                                this@TigerActivity::class.simpleName,
                                "Create Important LifeOfBrian task")
                            val intent = Intent(this@TigerActivity, BrianActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }) {
                            Text("Go to Important Brian task")
                        }
                    }}}}}

```