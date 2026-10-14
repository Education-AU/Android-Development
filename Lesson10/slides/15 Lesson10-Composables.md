---
title: GetLocations Composable
template: default
showFooter : false
---

```kotlin
@Composable
fun GetLocations(mapsService: MapsService) {
    val context = LocalContext.current
    val granted = remember {
        mutableStateOf(
            PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
                context,
                PERMISSION))}
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->granted.value = isGranted}
    val locations = remember { mutableStateListOf<Location?>() }
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        if (!granted.value) {launcher.launch(PERMISSION)}
    }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Button(onClick = {
            scope.launch {locations.add(mapsService.getCurrentLocation())}
        }) {Text("GetLocation")}
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            locations.forEach {Text(it.toString())}
        }
        if (locations.isNotEmpty())
            MapView(locations.toList().filterNotNull())
    }
}

```
