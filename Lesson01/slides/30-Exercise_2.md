---
title: Exercise 2
template: default
---

Construct a list view of person cards based on all files in the drawable folder
By using

```kotlin
fun getAllPersonResources(): List<Person> {
    return R.drawable::class.java.fields.filter { it.name.startsWith("pic_") }.map {
        val split = it.name.split("_")
        return@map Person(it.getInt(null), split[1], split[2], split[3])
    }
}

```
And the Person model is defined as

```kotlin
data class Person(
    val imageId: Int,
    val firstName: String,
    val lastName: String,
    val occupation: String
)
```
This assumes that all files have format: `pic_firstname_lastname_occupation.type`


