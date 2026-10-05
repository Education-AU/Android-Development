---
title: Data transport Primitive data
template: default
---

There are basically three ways to transport data between activities:

1. Send a “primitive” piece of data Int, Long, String,….
2. Send a self-made object using Serializable technique
3. Send a self-made object using Parcelable technique

All three techniques use the Intent and the method `putExtra` to transport data.

The first two techniques are easy to implement, but the third technique is more efficient and is the recommended way to
transport data between activities.

#### PutExtra primitive data
```kotlin
intent.putExtra("Key","value")
intent.putExtra("SomeInteger",1000)
```
Retrieving the data in the second activity is done by using the method `getStringExtra` or `getIntExtra`:
```kotlin   
val value = intent.getStringExtra("Key")
val someInteger = intent.getIntExtra("SomeInteger",0)
```