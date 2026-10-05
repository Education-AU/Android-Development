---
title: Calling Api in Launched Effect
template: default
---
<div class="text-image-row">
<img src="./assets/ApiCall1.png" alt="Boxes" width="20%">
10 sec 
<img src="./assets/ApiCall2.png" alt="Boxes" width="20%">
</div>

<br>

```kotlin
object WaitService {
    fun serve(waitTime: Long): String {
        Thread.sleep(waitTime)
        Log.v(this::class.simpleName, "Service called")
        return "API RESULT"
    }
}
```


