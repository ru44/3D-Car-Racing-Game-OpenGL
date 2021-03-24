# 3D-Car-Racing-Game-OpenGL
3D Car Racing Game OpenGL using Java

## Contents


- Phase I
   - Introduction
- Phase II
   - Problem definition:
   - Summary
   - Use of 3d objects
      - The car
      - The trees
      - The Buildings
   - Animation
   - Interaction
      - The user/car
      - The car/world
   - Project objectives
   - Project responsibilities
- Phase III
   - Computer graphics phenomenon
   - Project importance
   - Use Case diagram
   - Use case tables
- Phase IV
   - UML Class Diagram:
   - Algorithm used in this project:
      - Making the environment move
      - Collision-Detection for obstacles
   - Demo of the game
   - The idea of the game
   - Features that were missing but wish if we can include:
   - Libraries that were used in the project
- Figure 1- Use 3D Car List of Figures
- Figure 2- Use 3D Tree
- Figure 3 Use 3D Tree
- Figure 4- Use case diagram
- Figure 5- UML class diagram
- Figure 6- Game look
- Figure 7- Moving camera
- Figure 8- Green area(collision-detection)
- Figure 9- Finish line (collision-detection)
- Figure 10- Starting the game
- Figure 11- Middle of the game
- Figure 12- Lose the game
- Figure 13- Win the game


## Phase I

### Introduction

Our project aims to develop a simple car racing game built using OpenGL and
java programming language. The project goal is to use 3D models to build the game’s main
objects, apply illumination and shading on these objects and finally allow the user to interact
with the game.

## Phase II

### Problem definition:

For our project, the problems are divided into 3 categories:

```
1 - How to use openGL library.
2 - How to implement the motion of the camera and the car with the environment.
3 - How to implement collision detection and how it will interact with the world.
```
### Summary

The project we are planning to do is a car racing video game where the player
compete against the contestant car for the 1st place, The race start at the beginning line and
ends at the ending line, the player control the car using the arrow keys on the keyboard and
tries to reach the end point before the contestant car by keep moving forward without
stopping.


### Use of 3d objects

#### The car

_Figure 1 - Use 3D Car_

#### The trees

## Figure 2- Use 3D Tree


#### The Buildings

## Figure 3 Use 3D Tree

### Animation

The 3D objects that will be animated are the other cars in the racetrack.

### Interaction

The interaction will be divided into 2 subcategories:

```
1 - How the user interacts with the race car.
2 - How the car interacts with the world itself.
```
#### The user/car

The game will take the inputs from the user using the arrow buttons
where “↑” means move forward, “←” means turn left, “→” means turn right and “↓” means
stop the car and if the car stopped completely start to go backword.

#### The car/world

The game will implement a simple collision detection that will prevent
the car to go outside the racetrack.

### Project objectives

The objective of this project is to learn how 3d games are implemented, how
to use java and openGL to create a video game, the relationship between math and computer
graphics and how lights and shadows affect an object.

## Phase III

### Computer graphics phenomenon

Computer graphics is a science that deals with how an image is represented using a
digital system, today everybody sees the effect of computer graphics starting from a movie you just
watched to a video game you just finished playing to an ad you just saw on your TV, it is now
considered to be one of the most important topics of computer science.

### Project importance

This project is considered to be one of the most important projects we implemented
as students, it will teach us how to represent a 3D objects, how to link them together to create an
environment and finally how to animate a world of a game. Our project gives us a brief idea of how
hard creating a video game can be.

Features that it will be included are:

- Ranking.
- Restart the game.
- Simple collision detection.

```
It will exclude:
```
- Complex collision detection.
- A smart bot.
- Main menu.


### Use Case diagram

## Figure 4- Use case diagram

### Use case tables

```
Use case ID UC- 1
Use case name Start game
Actor Player and System
Pre-condition None
```
Post-condition (^) - Create Map

- Create Objects
- Start the race
- Calculate Score

Flow of events (^) - Start the game

- Create the game objects
- Begin the race for the player

```
Use case ID UC- 2
Use case name Move forward
Actor Player
Pre-condition Hold “⬆”
Post-condition Car moves forward
```
Flow of events (^) - Hold ⬆

- Car moves forward


Use case ID UC- 3
Use case name Move Right
Actor Player
Pre-condition Hold “⟹”
Post-condition Car moves right

Flow of events (^) - Hold ⟹

- Car moves right

Use case ID UC- 4
Use case name Move Left
Actor Player
Pre-condition Hold “⟸”
Post-condition Car moves left

Flow of events (^) - Hold ⟸

- Car moves left

Use case ID UC- 5
Use case name Stop the car
Actor Player
Pre-condition Press “↓”
Post-condition The car stops completely

Flow of events (^) - Press “↓”

- Car stops

Use case ID UC- 6
Use case name Move backward
Actor Player
Pre-condition Hold “↓”
Post-condition The car moves backward

Flow of events (^) - Hold “↓”

- Car moves backward

Use case ID UC- 7
Use case name End race
Actor System
Pre-condition Car reached end of race

Post-condition (^) - End the race


- Show the score

```
Flow of events
```
- Player reaches end of the race
- End this race
- Show player score

## Phase IV

### UML Class Diagram:

## Figure 5- UML class diagram


### Algorithm used in this project:

In our project we used different techniques to implement the environment of the
game, such as the following three objects that plays a major part of the game’s world.

## Figure 6- Game look

**The road:**

- Has been implemented as a simple grey rectangle using GL_QUAD.
- To create an impression of a long road we had to increase the difference in z-axis compared
    to the x-axis.

**The road signals:**

- Has been implemented as a simple white rectangle using GL_QUAD.
- drawn across the depth of the road.
- Identical length.

**The green area:**

- Has been implemented as a simple green rectangle using GL_QUAD.
- End points are identical to the road’s sides.

#### Making the environment move

The main idea of the motion in our project depends on the translation of the positions of
both the camera and the actual car at the z-axis instead of the concept of moving the map itself that
many other car racing games implement in their projects (which gives the player the impression that
the car is the one that is moving as he presses the keyboard keys while its position is actually fixed).


## Figure 7- Moving camera

#### Collision-Detection for obstacles

```
Our project will have two simple collision detection
```
1. When the player tries to go outside the rood the game will detect that he
    will try to exit and prevent him from going further left or right.
2. When the player reaches the finish line the game will detect that he finished
    the race.

```
Green area (Collision-Detection)
```

## Figure 8- Green area(collision-detection)

```
Finish line (Collision-Detection)
```
## Figure 9- Finish line (collision-detection)

### Demo of the game

Starting the game


## Figure 10- Starting the game

Middle of the game

## Figure 11- Middle of the game

Losing the game


## Figure 12- Lose the game

Winning the game

## Figure 13- Win the game


### The idea of the game

The game was not inspired by any means by another game but we thought that it
would be cool if we make a car racing game, the idea is well known and there are a lot of great car
racing games for example forza horizon , gran turismo sport , need for speed, etc. our project took
the base principle of car racing game from the games mentioned above and tried to implement it,
for example, a car racing game must have the player’s car, a racetrack, other contestant cars, and
finally, it must include a ranking of the player if he is first second, or last.

### Features that were missing but wish if we can include:

- a complex collision detection.
- The ability to play against another player.
- Smart AI.
- More racetracks.
- The ability to choose difficulty.
- Car customization.

### Libraries that were used in the project

- **Name:** openGL.
- **Main target:** the main use of this library is to help developer to render 2d
    and 3d graphics.
- **How the library contributed to the project:** it is the main building block for
    our project.
- **The citation of the library:** Official website for this library
    https://www.opengl.org/
- **Brief description of the license for using the library:** it is free to use by
    developer, but it is not an open source library.
- **The name(s) of any alternative of the used library:** GLUT.


