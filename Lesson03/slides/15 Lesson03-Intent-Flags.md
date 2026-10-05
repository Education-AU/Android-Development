---
title: Intent Flags
template: default
---

```kotlin
val intent = Intent(this, ProfileActivity::class.java)
intent.addFlags(Intent.REORDER_TO_FRONT)
```

If the activity you are launching already exists in the current task's back stack, this flag will move it to the front
of the stack. All the activities above it in the stack will be kept intact.

**This could be a good choice in the current case if profile is called many times**

**Notice that you can ADD flags (uses bitwise or). And it may create conflicts that is handled by some rule.**

