---
title: Service Interface
template: two-column
---

As before we configure the client and provide base url for the service.

```kotlin
class KtorAPodService : NasaApod {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("yyMMdd")
        private const val BASE_URL =
            "https://science.nasa.gov/wp-json/wp/v2/apod-basic/"
    }
```


**Notice:** The `expectSuccess = true` configuration ensures that the client will throw an exception for HTTP responses
with status codes outside the 2xx range, which we handle in the `get` method to return appropriate `NasaResponse`
objects.

<!-- column -->

```kotlin
private val client = HttpClient(Android) {
     expectSuccess = true
    install(ResponseObserver) {
        onResponse {
            Log.v("APOD SERVICE", it.status.value.toString())
            Log.v("APOD SERVICE", it.body())
        }
    }

    install(Logging) {
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        header(HttpHeaders.UserAgent, "NasaApp/1.0")
    }
}
```