---
title: Sha Fingerprint
template: default

---

The easiest way to generate sha fingerprint is in terminal

```text
.\gradlew.bat signingReport
```

producing output like this:

```text
Task :app:signingReport
Variant: debug
Config: debug
Store: C:\Users........
Alias: AndroidDebugKey
MD5: 6F:46:...........
SHA1: DB:F7:.......
SHA-256: 04:8Q:..........
Valid until: .............
```
And enter that into restrictions in Google Cloud Console.