# OOP-PTSA - 2024
## Object Oriented Programming - Java
### Websitegenerator - Wetterservice

This project is an exercise in object-oriented programming. It creates a website generator that generates a static website with weather information for several cities and towns. The website includes a navigation bar with links to each city and town's weather page.

Because I am from a german university, the names are in german. For convinience in using the program with unix systems, the umlauts are replaced by the corresponding vowel followed by an 'e'. For example, 'ä' is replaced by 'ae'. Also the 'ß' is replaced by 'ss'.  
I also added the documentation in english for better understanding of the code.

## Table of Contents

- [UML](#uml)
- [Structure](#structure)
  - [Main Classes](#main-classes)
  - [Test](#test)
  - [JavaDoc](#javadoc)
- [Code](#code)
- [Bugs](#Bugs)

## UML

Coming soon...

***
## Structure

The project includes several classes and a test class. The main classes are as follows:
***
### Main Classes

- `Wetter`: An enumeration that represents the weather. It contains the values `SONNIG`, `WOLKIG`, and `REGEN`.

- `App`: The main class. It creates a `WebsitenGenerator` object and adds example cities and towns to it. It then runs the generator to create the `.html` files.

- `Stadt`: Represents a city or town. It contains the name of the city or town and the current weather. It can generate a content string and a URL for the city or town's weather page.

- `Grossstadt`: Represents a large city with different districts. It uses the `Stadt` class to represent the city. It can generate a content string and a URL for the city's weather page.

- `Kleinstadt`: Represents a small town. It uses the `Stadt` class to represent the town. It can generate a content string and a URL for the town's weather page.

- `WebsitenGenerator`: Generates the website. It can add cities and towns, generate the website, return the navigation bar content and output the website to several `.html` files.

### Test

- `AppTest`: A JUnit test class that tests the `Stadt`, `Grossstadt`, `Kleinstadt`, and `WebsitenGenerator` classes.

### JavaDoc
The project features JavaDoc documentation for each class. To generate the JavaDoc, use the intigrated tools of your IDE.

***
## Code

The main code is located in the `psta-src/src` directory. The `psta-src/test` directory contains tests for each of these classes in the `AppTest` class.
***
## Bugs
Currently, there are no known bugs.
