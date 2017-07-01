
![](http://xurxodev.com/content/images/2017/04/xurxodev-readme.png) 
#  Movies Kotlin Kata
Movies Kotlin kata for practice Clean Architecture and Best Practices in Android using Kotlin, implemented by Jorge Sánchez (Xurxodev)

![](http://xurxodev.com/content/images/2017/07/kotlin_espresso.png)

## Kata 4

- We are here to practice UI Testing.
- We are going to use [espresso](https://google.github.io/android-testing-support-library/docs) to interact with the Application UI.
- We are going to practice pair programming.

## Considerations

Master branch contains already solved katas, exists a branch for every kata.

## Getting started

This repository contains an Android application to show movies information:

![](/art/movies.gif)

Initial state in this branch is ready to just start writing UI tests.

## Tasks

Your task as Android Developer is to **create Espresso tests**.

The recommendation for this exercise is:

  * Before starting
    1. Fork this repository and Checkout `kata_espresso_movies` branch or download zip.
    2. Execute the application, explore it manually and make yourself familiar with the code.
  
  * Test to create:
    1. Create a test that navigate to all detail movies activity and verify title as movie title
    2. Create a test that verify the number of rows is equal than movies count text
    3. Create a test that verify that while is retrieving movies loading text is visible
    4. Create a test that verify that while is retrieving movies progress bar is visible
    
  * Rules
    1. First create tests without Robot Pattern
    2. After refactoring tests to Robot Pattern

## Documentation

There are some links which can be useful to finish these tasks:

* [androidTestingDocumentation](https://google.github.io/android-testing-support-library)
* [espressoCheatSheet](https://google.github.io/android-testing-support-library/docs/espresso/cheatsheet/index.html)
* [espressoIdlingResources](http://dev.jimdo.com/2014/05/09/wait-for-it-a-deep-dive-into-espresso-s-idling-resources)

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
