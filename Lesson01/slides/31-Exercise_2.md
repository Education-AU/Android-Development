---
title: Exercise 2
template: default
---

The signature of the PersonCard composable is now


```kotlin
@Composable
fun PersonCard(person: Person) {
}
```
And the properties of the model are accessed by the usual . operator

Instantiation of a data class in Kotlin is `Person(…)` no `new` operator required.

To call all Person models by your PersonCards composable, you can use:



```kotlin
getPersons().forEach { p ->
    PersonCard(person = p)
}
```
or
```kotlin
getPersons().forEach {
    PersonCard(person = it)// using implicit parameter which is named it
}
```
