---
title: Activities
template: Default
---
The whole process can be visualized on the backstack

<div class="center">
<img src="assets/StackView.png" alt="Drawer 1" width="70%">
</div>

We might be interested in reordering on the stack instead of popping and destroying the TigerActivity 

For this as mentioned earlier we use the intent-flag FLAG_ACTIVITY_REORDER_TO_FRONT.

```kotlin
intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
```
