---
title: Implementation of PostsService
template: two-column
---

The implementation of the `PostsService` interface uses Ktor to fetch posts from a REST API. 
The service is configured with url, logging, content negotiation for JSON, and default request headers.


The method implementations are shown on the next slide
<!-- column -->

```kotlin
class KtorPostsService : PostsService {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/posts"
    }

    private val client = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
}
```
