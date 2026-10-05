---
title: ViewModel Life Cycle
template: default
---

<div class="center-left">
The lifecycle of a view model is **NOT** tied to the composable.

It is tied to the **ViewModelStoreOwner**.

The components that can be such owners are **Activities**, **Fragments** and **NavigationStack** objects

So, the best bet is that the **activity** life cycle is the controller of the view model.

This means that as for now the view model is **NOT** destroyed when the composable is de-composed.

This has the benefit that screen rotations and such do not remove the state of the view model.

But if you want to clear the view model state on de-compose it must be done manually.

Verifying this is left as an exercise!
</div>