---
title: ViewModels
template: default
---

A generalization of handling the state and logic in the composable you have seen so far is the
done by introducing the *View Model*

A view model is a **Class** that is defined outside the composable containing the state and logic you that you need in
the composable.

This separates the state and logic from the UI

And very important view models often survive decomposition depending on “owner”

First add

`("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")`

to dependencies

This dependency *might* be already present in your project by default in latest versions, if not add it to the
dependencies in the toml and build.gradle file
