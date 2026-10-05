---
title: Intent
template: default
---

Activities are launched using Intents.

Intents are objects that carry information to the Android system about what you want to do. You can use an Intent to
start a new activity, send a broadcast, or communicate with a service.

In this case we simply state that we want to start an **explicit** activity, which is an activity that we have defined
in our application.

```kotlin
 val intent = Intent(this, ProfileActivity::class.java)
 startActivity(intent)
```

The method `startActivity()` is inherited from ComponentActivity