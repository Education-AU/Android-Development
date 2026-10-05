---
title: Intent Flags
template: two-column
---

In order to control the back stack we can use intent flags. The most common ones are:

<br>

```kotlin
val intent = Intent(this, ProfileActivity::class.java)
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
```

This flag will clear the stack, and you simply create a new activity when starting the activity
Now finish will simply terminate the app (or pause it at least)

```kotlin
val intent = Intent(this, ProfileActivity::class.java)
intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
```

<!-- column -->

This will reuse an activity if is at the top already

```kotlin
val intent = Intent(this, ProfileActivity::class.java)
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
```

This flag implies:

If the activity created is on the stack already:

1. A new activity will not be created
2. All activities on the stack on top of the activity in question are removed from the stack
3. This often implies that the activities removed are destroyed.
4. The activity in question is now on top and is rendered
5. To start the new activity, we invoke: startActivity (intent)

