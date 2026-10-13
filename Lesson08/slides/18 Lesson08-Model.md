---
title: NASA APOD
template: two-column
---
```kotlin
@Serializable
data class APod(
    @SerialName("copyright") val copyright: String = "",
    @Serializable(with = LocalDateSerializer::class)
    @SerialName("date") val date: LocalDate,
    @SerialName("explanation") val explanation: String,
    @SerialName("hdurl") val hdUrl: String,
    @SerialName("media_type") val mediaType: String,
    @SerialName("service_version") val serviceVersion: String,
    @SerialName("title") val title: String,
    @SerialName("url") val url: String
)
```
Notice the annotation used for enforcing this serialization


<!-- column -->

```kotlin
object LocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString(), DateTimeFormatter.ISO_LOCAL_DATE)
    }
}
```
Notice that a custom serializer is made for the LocalDate data type.


