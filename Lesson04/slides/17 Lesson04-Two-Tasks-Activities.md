---
title: More Than One Task
template: default
---

```kotlin

class BiggusDickusActivity : LoggedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOfPiTheme {
                    Column() {
                        Text("Biggus Dickus")
                        Button(onClick = {
                            val intent =
                                Intent(this@BiggusDickusActivity, BrianActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            Log.v(this::class.simpleName, "BACK to Brian")
                            startActivity(intent)
                        }) {
                            Text("Back To Brian")
                        }
                        Button(onClick = {
                            Log.v(this::class.simpleName, "Return to Pi/Tiger")
                            val intent = Intent(this@BiggusDickusActivity, PiActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            intent.action = Intent.ACTION_MAIN
                            intent.addCategory(Intent.CATEGORY_LAUNCHER)
                            startActivity(intent)
                        }) {
                            Text("GO TO PI MAIN TASK")
                        }}}}}}

```