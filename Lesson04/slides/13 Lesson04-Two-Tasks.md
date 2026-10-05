---
title: More Than One Task
template: default
---

<div class="text-image-row">
<img src="assets/PiStack.png" alt="Pi Stack" width="10%">
<p>$\leftarrow$ Jump between stacks $\rightarrow$</p>
<img src="assets/BrianStack.png" alt="Brian Stack" width="10%">
</div>
In order to make this work we need the two activities in the manifest, and we need to create a new task.

```xml
<activity
android:name=".activities.brian.BrianActivity"
android:exported="true"
android:theme="@style/Theme.LifeOfPi"
android:taskAffinity="LifeOgBrian.task"
/>
<activity
android:name=".activities.brian.BiggusDickusActivity"
android:exported="true"
android:theme="@style/Theme.LifeOfPi" />
```