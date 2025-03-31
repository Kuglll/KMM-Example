## KMP Example

This is a Kotlin Multiplatform project Example.

In this example we'll try to simulate we have 2 existing apps: iOS and Android. 

Our plan is to:
- Extract shared logic from an existing android app into a KMP module.
- Add the KMP module to the iOS app, that is in other repo.
- Delete ios part of the code that is not needed anymore.

## Project structure

* `/shared` contains the project's code. It has several subfolders:
  - `androidMain` includes android specific code + android app (android app could also be a part of another repo)
  - `commonMain` is for code that’s going to be shared between android and ios.
  - `iosMain` includes ios specific code. iOS app is in a separate repo.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
