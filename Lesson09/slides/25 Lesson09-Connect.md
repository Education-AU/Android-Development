---
title: Connecting to FireStore
template: two-column
showFooter : false
---

#### FS Service
```kotlin
class FSHorsesService {
private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    suspend fun createHorse(horse: CreateHorseFS){
      db.collection("Horses").add(horse).await()
    }

    suspend fun getHorses(): List<HorseFS> {
        val horses = db.collection("Horses").get().await()
        return horses.documents.mapNotNull { document ->
            val horse = document.toObject<HorseFS>()
            horse?.id = document.id // Assign the document ID to a property in the data class
            horse // Return the deserialized object with the document ID included
        }
    }

    suspend fun getHorse(id: String): HorseFS? {
        val horse = db.collection("Horses").document(id).get().await()
        if (horse.exists()) {
            return horse.toObject<HorseFS>()
        }
        return null
    }
}
```

<!-- column -->

#### Domain model
And then a domain model that does not couple to firestore

```kotlin
data class Horse(val id:String,val name:String)
```
#### Domain service
```kotlin
class HorseService {

    private val fsService: FSHorsesService = FSHorsesService()

    suspend fun getAllHorses(): List<Horse> {
        return fsService.getHorses().map { Horse(it.id, it.Name ?: "") }
    }
}
```