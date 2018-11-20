# kotlin-multiplatform [![CircleCI](https://circleci.com/gh/ToxicBakery/kotlin-multiplatform.svg?style=svg)](https://circleci.com/gh/ToxicBakery/kotlin-multiplatform)
Kotlin multiplatform project sample for a conference talk.

## Swing Demo
A Swing based demo which should launch on any platform with at least JRE 8 installed.

```bash
./gradlew :swing:run
```

## Browser Demo
Uses Node and Webpack to host a simple website.

```bash
./gradlew :browser:run
```

Then open your browser to `http://localhost:8088`. You can stop the server as well.
```bash
./gradlew :browser:stop
```
