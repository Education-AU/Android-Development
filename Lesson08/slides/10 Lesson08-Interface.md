---
title: Interface
template: two-column
---

To make the code flexible we implement the calls to the API in an interface. This allows us to change the implementation
of the API calls without changing the code that uses it.
<!-- column -->

```kotlin

interface PostsService {
    suspend fun get(): List<Post>
    suspend fun post(post: Post)
    suspend fun get(id: Int): Post?
    suspend fun getBy(title: String): List<Post>
}
```
