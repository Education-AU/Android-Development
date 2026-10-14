---
title: Models 
template: two-column
---

```kotlin
data class User(
    val id: UserId,
    val email: Email,
    val name: String?,
    val age: Int?
)
```
```kotlin
data class UserId(
    val id: String
)
```
<!-- column -->
#### Service

```kotlin
sealed class SignUpResult {
    data class Success(val user: UserId) : SignUpResult()

    sealed class Failure(open val status: String) : SignUpResult() {
        data class InvalidCredentials(override val status: String) : Failure(status)
        data object UserExists : Failure("User exists")
        data object Network : Failure("Network error")
        data object General : Failure("General error")
    }
}

sealed class SignInResult {
    data class Success(val user: UserId) : SignInResult()

    sealed class Failure(open val status: String) : SignInResult() {
        data class InvalidCredentials(override val status: String) : Failure(status)
        data object Network : Failure("Network error")
        data object General : Failure("General error")
    }
}
```
