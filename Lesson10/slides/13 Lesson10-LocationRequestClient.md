---
title: The Location Client
template: default
---

```kotlin
class MainActivity : ComponentActivity() {
    private val locationClient by lazy { LocationServices.getFusedLocationProviderClient(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMapAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val scope = rememberCoroutineScope()
                    Box(modifier = Modifier.padding(innerPadding)) {
                        GetLocations(MapsService(locationClient))
                    }
                }}}}}

```

In this application it is located in the MainActivity because it needs the activity reference.

It is lazy loaded so that it is only created when it is first used. This is important because the location client needs
the activity reference to be created, and the activity is not available until onCreate () is called.

It is passed to the composables that need it, in this case the GetLocations composable, which is responsible for
requesting the location and displaying it on the map.