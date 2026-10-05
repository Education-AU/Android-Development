---
title: More Than One Task
template: default
---

```kotlin
class BrianActivity : LoggedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOfPiTheme {
                    Column() {
                        Text("Life of brian")
                        Button(onClick = {
                            Log.v(this::class.simpleName, "BACK clicked")
                            val intent =
                                Intent(this@BrianActivity, BiggusDickusActivity::class.java)
                            startActivity(intent)
                        }) {
                            Text("Go to Biggus Dickus")
                        }}}}}}

```