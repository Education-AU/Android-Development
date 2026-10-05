---
title: Disposable Effect
template: default
---
It is possible that you need to clean up after an effect and additionally, clean up after the composable leaves the composition.

The lifecycle method used for this is `DisposableEffect`

It works as `LaunchedEffect` but with an **additional function as return value**

