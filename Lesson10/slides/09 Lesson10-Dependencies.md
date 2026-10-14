---
title: Dependencies
template: default

---
Versions probably need updates

```toml
googleGms = "4.4.2"
googleSecrets="2.0.1"
googleplayservicelocation = "21.3.0"
googleplayservicemaps="19.0.0"
googleMapsCompose="4.1.1"

[libraries]
#MAPS
google-maps-compose={group="com.google.maps.android",name="maps-compose",version.ref="googleMapsCompose"}
google-gms-play-services-location={group="com.google.android.gms",name="play-services-location",version.ref="googleplayservicelocation"}
google-play-services-maps={group="com.google.android.gms",name="play-services-maps",version.ref="googleplayservicemaps"}

[plugins]
google-gms-services = { id = "com.google.gms.google-services", version.ref = "googleGms" }
google-secrets={id="com.google.android.libraries.mapsplatform.secrets-gradle-plugin",version.ref="googleSecrets"}


```


