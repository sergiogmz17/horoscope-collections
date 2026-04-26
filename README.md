# Football-Themed Compatibility System (Java)

This project is a creative take on a compatibility system (similar to a horoscope) but using **football teams** instead of zodiac signs. It calculates relationships and rivalries between teams based on birth year cycles.

## Project Concept (In my words)
I wanted to build something different to practice my logic. This program assigns you a football team based on your birth year and then tells you which other teams you "get along with" and which ones are your rivals. It was a fun way to experiment with how different data points relate to each other in a complex system.

## Technical Deep Dive
Beyond the theme, this project was built to master the **Java Collections Framework**:

- **TreeMap & TreeSet:** Used to store teams as keys and years as values in a sorted manner, ensuring efficient data retrieval.
- **ArrayList:** Used to manage dynamic lists of compatible "signs".
- **Reciprocity Logic:** I implemented a system where relationships are automatically bidirectional.
- **Search Algorithms:** Custom methods to identify the correct team for a given year and filter matches.

## How to run
1. Open the project in any Java IDE (developed in BlueJ).
2. Create a new `Horoscope` object.
3. Call the `printCompatibleSignsFor(int year)` method to see the results.

## Skills Demonstrated
- Java Object-Oriented Programming (OOP)
- Complex Data Structures (Maps, Sets, Lists)
- Javadoc Documentation
- Algorithm Design
