# Theme Park Visitor Management System

## Course Project - Data Structures (CSC212)

This project, developed for the CSC212 Data Structures course in Trimester 2, 2022/2023, is a Theme Park Visitor Management System implemented in Java. The software is designed to manage visitor information and track their movement within a theme park, adhering to specific rules for kingdom visitation and exit. A core requirement of this project was the implementation of custom Abstract Data Types (ADTs) without the use of Java's built-in Collections framework.

## Project Overview

The theme park has a main entrance and exit, and four internal kingdoms, each with its own gates. Visitors can enter kingdoms in any order. However, for marketing purposes, visitors must exit the kingdoms in the reverse order of their initial visit before being allowed to leave the park. The system reads visitor data from a text file and stores it using a custom-built ADT to facilitate various operations related to visitor information and location tracking.

## Features

The system supports the following operations on visitor data:

1.  **Find Visitors by Last Name:** Retrieve and display information for all visitors with a given last name.
2.  **Total Number of Regions:** Display the total count of distinct regions from which visitors originate.
3.  **Regions by Visitor Count:** Display a list of regions and the number of visitors from each, sorted in descending order by visitor count.
4.  **VIP Pass Holders per Region:** Display the number of VIP pass holders originating from a specific region.
5.  **Current Location of VIP Pass Holders:** Display the current estimated location (kingdom) for all visitors holding VIP passes.
6.  **Check Same Kingdom (VIP):** Determine if two VIP pass holders from the same region, identified by their phone numbers, are currently in the same kingdom.
7.  **Check Same Visit Order (Regular):** Determine if two regular pass holders from the same region, identified by their phone numbers, visited the kingdoms in the exact same order and number of kingdoms.

## Data Structures

In strict adherence to the course requirements, this project implements custom data structures from scratch. The core of the system is built around a custom `ThemeParkADT` (or a set of related ADTs) designed to efficiently store visitor data and support the required operations. **No classes from `java.util.*` or other Java Collections libraries were used.** The design prioritizes performance for the specified operations, considering factors like time complexity for search, insertion, and retrieval tasks.

## How to Run

1.  Ensure you have a Java Development Kit (JDK) installed.
2.  Compile the Java source files.
3.  Run the `Main` class. The program will read visitor data from a specified input text file (as per project requirements) and execute the operations.

```bash
# Example compilation (adjust path as needed)
javac *.java

# Example execution (adjust Main class name and input file path as needed)
java Main visitors.txt
