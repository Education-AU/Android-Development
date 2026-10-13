---
title: Dependencies
template: default
---

<div class="center-left">
For versions of all libraries see the project KtorHttp.zip

<br>

You might have to update some versions in the project

</div>

```toml
[libraries]
#KTOR-BEGIN
ktor-client-serialization={group="io.ktor",name="ktor-client-serialization",version.ref="ktor"}
ktor-client-content-negotiation={group="io.ktor",name="ktor-client-content-negotiation",version.ref="ktor"}
ktor-client-logging={group="io.ktor",name="ktor-client-logging",version.ref="ktor"}
ktor-client-android={group="io.ktor",name="ktor-client-android",version.ref="ktor"}
ktor-client-core = { group = "io.ktor", name = "ktor-client-core", version.ref = "ktor" }
ktor-client-serialization-kotlinx-json={group="io.ktor",name="ktor-serialization-kotlinx-json",version.ref="ktor"}
#KTOR-END
```

```toml
[plugins]
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlinSerialization" }
```