# Overwatch Stat Analyser - A tool for analysing your data

#### So you are writing down the results of your game to get a better understanding of your performance on different champions and maps. 

What is strongest hero for every map? Strongest Role? Whats your skill rating over time?

This is a java application that reads an Excel file(.xlsx) and generates graphs and percentages for specific hero's, maps, roles and more.

#### Skill rating over games played
<img src="https://github.com/TimAndreJacobsen/OverwatchStatAnalyser/raw/master/assets/sr-over-time.PNG" alt="skill-rating-graph-ui" height="25%" width="25%">


#### Champion performance sorted on role: support over all maps
<img src="https://github.com/TimAndreJacobsen/OverwatchStatAnalyser/raw/master/assets/role-win-rate-over-map.PNG" alt="support-win-rate-over-map" height="25%" width="25%">


## Setup:
#### Libraries: JavaFX, Apache POI, JUnit4
### Requirements: Java 1.8, Maven, a dataset of played games and stats
##### Clone the repo and use Maven to import dependencies(will grab JavaFX, Apache POI, Junit4).
##### to install dependencies you can target pom.xml with Maven and import.

#### Example dataset
<img src="https://github.com/TimAndreJacobsen/OverwatchStatAnalyser/raw/master/assets/dataset.PNG" alt="example-dataset" height="25%" width="25%">
