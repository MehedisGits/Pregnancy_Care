<div align="center">

# ZenMom — Pregnancy Care

**A comprehensive Android app for maternal health, pregnancy tracking, and wellness**

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat&logo=android&logoColor=white)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.java.com)
[![Version](https://img.shields.io/badge/Version-8.1.143-blue?style=flat)](https://github.com/MehedisGits/Pregnancy_Care)
[![License](https://img.shields.io/badge/License-MIT-green?style=flat)](LICENSE)

</div>

---

## Overview

ZenMom is a maternal health companion app designed specifically for expectant mothers. It provides week-by-week pregnancy guidance, nutritional advice, immunization schedules, mental health support, and physical wellness tips — all in one accessible Android application.

The app aims to reduce anxiety around pregnancy by giving mothers reliable, structured information at every stage of their journey.

---

## Features

### Pregnancy Tracking
- Week-by-week pregnancy progress tracker
- Milestone tracking with visual indicators
- Baby development information per trimester

### Nutrition & Diet
- Curated food guides — fruits, vegetables, and pregnancy-safe meals
- Foods and substances to avoid (alcohol, smoke, unsafe items)
- Eating habit recommendations by trimester

### Health & Wellness
- Immunization schedule and vaccine reminders
- Mental health resources and stress management tips
- Physical activity guidelines safe for pregnancy
- Oral health guidance during pregnancy

### Sexual & Reproductive Health
- Evidence-based sexual health information for pregnant mothers

### UI & Experience
- Lottie-powered animations for engaging onboarding and transitions
- Accessibility-first design — screen reader support, contrast compliance
- Smooth splash screen with animated entry
- Optimized for low-end Android devices (LOLLIPOP+)

---

## Tech Stack

| Layer | Technology |
|---|---|
| Platform | Android (Java) |
| Min SDK | Android 5.0 (LOLLIPOP) |
| Animations | Lottie |
| Build System | Gradle |
| Architecture | MVC (Activity/Fragment based) |
| Assets | ZenMom-Image companion repo (57 curated health images) |

---

## Project Structure

```
ZenMom-Pregnancy-Care/
├── app/
│   ├── src/main/
│   │   ├── java/          # Activities, Fragments, Adapters
│   │   ├── res/
│   │   │   ├── layout/    # XML layouts
│   │   │   ├── drawable/  # Icons and assets
│   │   │   └── raw/       # Lottie animation files
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── gradle/
```

---

## Asset Library

The visual content for this app is maintained in a dedicated companion repository:

**[ZenMom-Image](https://github.com/MehedisGits/ZenMom-Image)** — 57 curated health and wellness images organized by category:

| Category | Content |
|---|---|
| Fruits & Vegetables | Pregnancy-safe nutrition visuals |
| Prenatal Nutrition | Meal and diet guidance images |
| Immunization | Vaccine schedule reference images |
| Mental Health | Wellness and mindfulness visuals |
| Physical Activity | Safe exercise illustrations |
| Items to Avoid | Alcohol, smoke, unsafe substances |
| Oral & Sexual Health | Informational health visuals |

---

## Getting Started

### Prerequisites
- Android Studio (Hedgehog or later)
- Android SDK (API 21+)
- Java 11+

### Run locally

```bash
git clone https://github.com/MehedisGits/Pregnancy_Care.git
cd Pregnancy_Care
```

1. Open in **Android Studio**
2. Sync Gradle dependencies
3. Run on emulator or physical device (Android 5.0+)

---

## Version History

| Version | Notes |
|---|---|
| 8.1.143 | Stable release — accessibility fixes, Lottie splash, progress tracker |
| 5.1.143 | UI improvements, LOLLIPOP crash fix |
| Earlier | Initial features — nutrition, immunization, health content |

---

## Author

**Rakibul Islam Mehedi**
Android & Flutter Developer | Bangladesh

[![GitHub](https://img.shields.io/badge/GitHub-MehedisGits-181717?style=flat&logo=github)](https://github.com/MehedisGits)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-rakibulmehedi-0077B5?style=flat&logo=linkedin)](https://linkedin.com/in/rakibulmehedi)

---

<div align="center">
  <sub>ZenMom — Built with care for every mother's journey · MIT License</sub>
</div>
