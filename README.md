# MVI-KMM-Sample

- [Webinar](https://www.youtube.com/watch?v=g1TtM-bUmR4&ab_channel=kts)
- [Habr article](https://habr.com/ru/companies/kts/articles/729832/)

MVI KMM Sample project. It contains 2 apps: for Android and for iOS

### Shared code
- Data-layer
- Domain-layer
- Resources, namely strings, colors, pictures and fonts
- ViewModel

### Platform code
- Just ui: Compose on Android and UIKit on iOS

# Getting started

### Before the first launch
1. Install cocoapods: `sudo gem install cocoapods`
2. Install xcodegen: `brew install xcodegen`

### After clonning
1. From `iosApp` folder: `xcodegen generate`