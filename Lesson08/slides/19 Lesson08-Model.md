---
title: Service Interface
template: two-column
---

In this implementation we implement a more complex response to avoid exceptions.



<!-- column -->

```kotlin
interface NasaApod {
    suspend fun get(date: LocalDate): NasaResponse
}
```

```kotlin
sealed class NasaResponse {
  data class Success(val apod: APod) : NasaResponse()
    sealed class Failure(open val message: String) : NasaResponse() {
      data class AuthenticationError(override val message: String) : Failure(message)
      data class BadRequestError(override val message: String) : Failure(message)
      data object NetworkError : Failure("Network Error: Check your Internet connection")
      data object UnAvailable : Failure("Service Error: Service down try later")
      data class GeneralError(override val message: String) : Failure(message)
    }
}
```
