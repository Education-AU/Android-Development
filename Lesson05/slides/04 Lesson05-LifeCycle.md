---
title: Life Cycle of Composables
template: two-column
---

The life of a composable:

1. It enters a composition
2. It is recomposed by state change
3. It leaves the composition

This is simpler than the life of an Activity

This life-cycle can be “hacked”. 

That is, it is possible to inject code in various places under various circumstances in
this life-cycle.

This is useful for creating changes in the state that in turn recomposes the composable
https://developer.android.com/jetpack/compose/side-effects

<!-- column -->

<div class="center">
<img src="assets/LifeCycle.png" alt="LifeCycle" width="70%">
</div>


