---
title: MapView Composable
template: default
---

```kotlin
@Composable
fun MapView(locations: List<Location>) {

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            locations[0].let { LatLng(it.latitude, it.longitude) }, 15f
        )
    }

    GoogleMap(cameraPositionState=cameraPositionState) {
        Polyline(
            color = Color.Magenta,
            pattern = listOf(Dash(2f)),
            points = locations.map { LatLng(it.latitude, it.longitude) }
        )
        Marker(
            state = MarkerState(
                position = locations[0].let { LatLng(it.latitude, it.longitude) }),
            title = "TEST",
            snippet = "Marker in:"
        )
    }
}

```
