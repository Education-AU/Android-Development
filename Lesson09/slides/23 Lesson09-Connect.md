---
title: Connecting to FireStore From App
template: default
---

Before connecting to firebase/firestore we need some models

Models for handling firestore data directly:


```kotlin
import com.google.firebase.firestore.DocumentId

data class HorseFS(var id: String = "", val Name: String? = null)

data class CreateHorseFS(val Name:String)
```

