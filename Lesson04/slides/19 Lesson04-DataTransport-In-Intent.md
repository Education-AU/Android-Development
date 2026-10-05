---
title: Data transport Serializable data
template: default
---


#### PutExtra Serializable Class data
If you have an object of some class **that implements interface Serializable** you can pass it to another activity using the method `putExtra`:
```kotlin
data class Cat(val tagNumber:Long,val name:String):Serializable
intent.putExtra("Cat",Cat(1,"Fluffy")
```
And retrieve it by using the method `getSerializableExtra`:

```kotlin
if(intent.extras.?containsKey("Cat")==true){
    val cat =intent.getSerializableExtra("Cat",Cat::class.java)
}

```
