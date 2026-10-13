---
title: Service Interface
template: two-column
showFooter: false
---

The response from the NASA API is handled in a more elaborate manner to avoid unnecessary exception handling down
stream,and return a response object instead.

<!-- column -->

```kotlin
override suspend fun get(date: LocalDate): NasaResponse {
    try {
        val url = "$BASE_URL&date=${date.format(DateTimeFormatter.ISO_LOCAL_DATE)}"
        val response = client.get {
            url(url)
        }
        return NasaResponse.Success(response.body())
    } catch (e: ResponseException) {
        val status = e.response.status
        return when (status) {
            HttpStatusCode.BadRequest ->
                NasaResponse.Failure.BadRequestError(e.message.toString())
            HttpStatusCode.ServiceUnavailable ->
                NasaResponse.Failure.UnAvailable
            else ->
                NasaResponse.Failure.GeneralError(e.message.toString())
        }
    } catch (e: ConnectTimeoutException) {
        return NasaResponse.Failure.NetworkError
    } catch (e: IOException) {
        return NasaResponse.Failure.GeneralError(e.message.toString())
    }
}

fun close() {
    client.close()
}
```
