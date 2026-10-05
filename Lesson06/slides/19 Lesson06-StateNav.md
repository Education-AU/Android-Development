---
title: Save state
template: default
---
The lack of state preservation is due to the decomposition of the items
So, to preserve the state over decompositions we must use savable states.

This is very simple as it turns out using

rememberSavable instead of remember

This will work as long as the composable is on the stack but has been decomposed

So exchange 
```kotlin
val state = remember { mutableIntStateOf(0) }
``` 
for

```kotlin
val state = rememberSavable { mutableIntStateOf(0) }    
```

