---
title: Android Platform Software Stack
footerVariant: dark
template: two-column
---

<span class="orange">Linux Kernel:</span><br>
Provides the core operating-system functionality, including process management,
memory management, networking, security, and device drivers.

<span class="cyan">Hardware Abstraction Layer (HAL):</span><br>
Provides standard interfaces that allow higher-level Android components to
access hardware-specific functionality without depending directly on the
underlying hardware implementation.

<span class="yellow">Android Runtime(ART):</span><br>
Provides the runtime environment for Android applications. It executes
DEX bytecode and includes AOT* and JIT** compilation and garbage collection.

<span class="purple">Native C/C++ Libraries:</span><br>
A collection of native libraries used by Android and exposed to higher-level
components through various interfaces.

<span class="green">Java API framework:</span><br>
Provides the APIs and system services that applications use to access
Android functionality such as activities, notifications, resources,
and location services.


<span class="cyan-dark">System Apps:</span><br>
Pre-installed applications that provide common functionality, such as
phone, messaging, settings, and other system-level features. 

<!-- column -->



<div class="center">

<img src="./assets/AndroidPlatform.png" alt="Android Platform" width="55%">

</div>

