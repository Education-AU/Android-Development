---
title: Gradle Files
template: default
---

Gradle is a build and package manager tool like NuGet or Npm

The Gradle files are written in Kotlin

There are at least two Gradle files one for the project and one for the app module

We will not implement more than one module in an app.

The project Gradle file specifies global dependencies

```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
```

In the top-level gradle-file two plugins for building android applications are specified but not applied. The plugins are applied in the module
gradle-file. So the files are downloaded to gradle-cache, but not applied to the project.

The specification of the actual repository ids of the plugins are made in the `lib.versions.toml` file

The gradle-file refers to the aliases in this file