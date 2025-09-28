Metro Route Calculator  
---
A simple educational Java project that simulates route calculation in the St. Petersburg Metro. 
The program loads metro map data from a JSON file, builds an index of stations, lines, and connections, and calculates the shortest route between two stations. It also estimates the travel duration.
Features  
Represents metro stations and lines as Java classes.  
Supports connections between lines (transfers).  
Calculates:  
Shortest route between two stations.  
Travel duration, considering:  
2.5 minutes between stations on the same line.  
3.5 minutes for transfers between lines.  
JSON-based metro map loading. 
Interactive CLI: user inputs departure and destination stations.  
JUnit tests for route calculation and duration logic.  
Project Structure  
core.Station – represents a metro station.  
core.Line – represents a metro line containing multiple stations.  
StationIndex – stores all stations, lines, and connections.  
RouteCalculator – core logic for finding the shortest route and calculating travel duration.  
Main – entry point with interactive console interface. 
map.json – data file with metro lines, stations, and connections.  
RouteCalculatorTests – JUnit test cases for route calculation.  
Example Usage 
```
$ java Main
```
St. Petersburg Metro Route Calculation Program  
Enter the departure station:  
Ploshchad Vosstaniya  
Enter the destination station:  
Nevsky Prospekt  
Track:  
   - Ploshchad Vosstaniya
    -Transfer to the station Nevsky Prospekt (Blue line)
   - Nevsky Prospekt
Duration: 3.5 minutes  
Requirements  
Java 8+  
JSON-simple library (for parsing map.json)  
JUnit 4 (for running tests)  
How It Works  
The program loads metro data from map.json.  
Builds an index of:  
Lines  
Stations  
Connections  
User enters departure and destination stations.  
RouteCalculator:  
Finds shortest route.  
Prints stations and transfers.  
Calculates travel duration.  
Running Tests  
To run unit tests:
```
$ mvn test
```
Educational Goal  
This project demonstrates:  
OOP principles (composition, encapsulation, comparison).  
Collections (List, Map, Set, TreeSet).  
Working with JSON in Java.  
Implementing search and route calculation logic.  
Writing unit tests.  
License  
This project is created for educational purposes.
Free to use, modify, and distribute.
