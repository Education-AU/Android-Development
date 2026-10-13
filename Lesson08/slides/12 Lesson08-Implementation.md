---
title: Implementation of PostsService
template: two-column
---
```kotlin
override suspend fun get(): List<Post> {
    return try {
        client.get {
            url(BASE_URL)
        }.body()
    } catch (e: Exception) {
        Log.v("POSTS SERVICE", e.toString())
        emptyList()
    }
}

override suspend fun post(post: Post) {
    client.post {
        url(BASE_URL)
        setBody(post)
    }
}

fun close() {
    client.close()
}
```

<!-- column -->

```kotlin
override suspend fun get(id: Int): Post? {
    return try {
        client.get {
            url("$BASE_URL/$id")
        }.body()
    } catch (e: Exception) {
        Log.v("POSTS SERVICE", e.toString())
        null
    }
}

override suspend fun getBy(title: String): List<Post> {
    return try {
        client.get {
            url(BASE_URL)
            parameter("title", title)
        }.body()
    } catch (e: Exception) {
        Log.v("POSTS SERVICE", e.toString())
        emptyList()
    }
}
```
