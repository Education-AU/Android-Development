---
title: Model
template: two-column
---

Construction of such a model in Kotlin is of course done by a data class

But, we want some automatic deserialization/serialization to occur when receiving and
transmitting data from the api.

The dependencies where listed in previous slide.

<!-- column -->

```kotlin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("userId") val userId: Int,
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("body") val body: String,
)
```

The annotations `@SerialName` are used if the field names in the JSON data do not match the property names in the Kotlin
class.

The `@Serializable` annotation is used to indicate that this class can be serialized and deserialized.