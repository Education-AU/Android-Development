---
title: Exercise 1
template: default
---

The signature of your composable could be

```kotlin
@Composable
fun PersonCard(imageId:Int,firstName:String,lastName:String,occupation:String){
}
```

Use the composables: *Card*, *Row* and *Column*. Look up documentation for these composables if you are not familiar
with them.

In the first test of the composable you can hard code name and occupation

The column and Row composables are used as:

```kotlin
Column{
composable1
composable2
}//composable1 and composable2 are aligned in a colum
Row{
composable1
composable2
}//composable1 and composable2 are aligned in a row
```

And you can of course use columns in rows and vice versa


