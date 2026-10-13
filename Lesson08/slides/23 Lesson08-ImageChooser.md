---
title: Image Chooser
template: two-column
showFooter : false
---

```kotlin
@Composable
fun ImageChooser() {
    val context = LocalContext.current
    val service = remember { KtorAPodService() }
    val now = LocalDate.now()
    val apod = remember { mutableStateOf<APod?>(null) }
    val date = remember { mutableStateOf(now) }
    val datePicker = DatePickerDialog(context,
        { p: DatePicker, _, _, _ ->
            date.value = LocalDate.of(p.year, p.month, p.dayOfMonth)
        },
        now.year,now.monthValue,now.dayOfMonth
    )
    LaunchedEffect(date.value) {
        when (val res = service.get(date.value)) {
            is NasaResponse.Success -> apod.value = res.apod
            is NasaResponse.Failure -> Toast.makeText(
                context,
                res.message,
                Toast.LENGTH_SHORT).show()
        }
    }
    DisposableEffect(Unit) {
        onDispose {
            service.close()
        }
    }}
```
<!-- column -->

```kotlin
Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
    Text("This is an app showing daily pictures")
    Button(onClick = { datePicker.show() }) {
        Text("Select Date")
    }
    if (apod.value != null) {
        Text(
            apod.value?.copyright?.let { "\u00A9" + it }
                ?: "There is no Copyright on this image"
        )
        SubcomposeAsyncImage(
            model = apod.value?.url,
            loading = { CircularProgressIndicator() },
            contentDescription = "Nasa Image"
        )
        Text(apod.value?.explanation ?: "There is no explanation for this image")
    }
}
```
