---
title: Data transport Parcelable data
template: default
---
First of all you need an additional plugin

<div class="center">
<img src="assets/Plugins.png" alt="Drawer 2" width="20%">
</div>

The class  must implement the interface **Parcelable** and be equipped with an annotation `@Parcelize` to be able to be passed as an extra in an intent.

```kotlin
@Parcelize
data class Cat(val tagNumber:Long,val name:String):Parcelable
```
Send is the same as for Serializable data types:

And retrieve it by using the method `getParcelableExtra`:

```kotlin
if(intent.extras?.containsKey("Cat")==true){
    val cat =intent.getParcelableExtra("Cat",Cat::class.java)
}

```
