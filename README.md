
![](http://xurxodev.com/content/images/2017/04/xurxodev-readme.png) 
#  Movies Kotlin Kata
Movies Kotlin kata for practice Clean Architecture and Best Practices in Android using Kotlin, implemented by Jorge Sánchez (Xurxodev)

## Kata 1

- We are here to practice Dependency Injection.
- We are going to use [Dagger2](https://google.github.io/dagger/) as Dependency Injector.
- We are going to practice pair programming.

## Considerations 

Master branch contains already solved katas, exists a branch for every kata.

## Getting started

This repository contains an Android application written in kotlin to show movies information:

![](/art/movies.gif)

The application initial state without dependency injection is ready to just start refactoring. 

## Tasks

Your task as Android Developer is to **refactoring to inject dependencies**, only singleton dependencies.
The recommendation for this exercise is:

  * Before starting
    1. Fork this repository and Checkout `kata-di-movies` branch or download zip.
    3. Execute the application, explore it manually and make yourself familiar with the code.

  * To help you get started:     
    1. Configure dagger 
    2. Identify singleton dependencies.
    3. Create module/s, component/s, custom application, set targets where inject dependencies
    4. Execute the app and verify that all is right
    
## Documentation

There are some links which can be useful to finish these tasks:

* [Official docs Dagger 2](https://google.github.io/dagger/)
* [Dependency Injection with Dagger 2](https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2)
* [How to use Dagger 2 on Android with Kotlin](https://antonioleiva.com/dagger-android-kotlin/)

## Developed By

* Jorge Sánchez Fernández aka [xurxodev](https://twitter.com/xurxodev)

## License


    Copyright 2017 Jorge Sánchez Fernández

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
