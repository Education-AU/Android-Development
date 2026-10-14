---
title: Models 
template: two-column
---

```kotlin
data class Password(val value: String) {
    init {
        if (!validate(value)) {
            throw IllegalArgumentException("ILLEGAL_PASSWORD")
        }
    }
    companion object {
        private val regexPattern =
            Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}$")

        fun validate(password: String): Boolean {
            return regexPattern.matches(password)
        }
    }
}
```
<!-- column -->

```kotlin
data class Email(val value: String) {
    init {
        if (!validate(value)) {
            throw IllegalArgumentException("ILLEGAL_EMAIL")
        }
    }
    companion object {
        private val regex =
            Regex("^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")

        fun validate(email: String): Boolean {
            return email.matches(regex)
        }
    }
}
```