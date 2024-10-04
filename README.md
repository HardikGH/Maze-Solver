# Maze Solver in Java

This repository contains a Java application that implements a maze-solving algorithm using a depth-first search (DFS) approach. The program reads maze configurations from a text file, navigates through the maze, and outputs the shortest solution path.

## Key Features

- **File Input**: Load maze configurations from external text files.
- **Depth-First Search Algorithm**: Finds a path from the starting point (`S`) to the goal (`K`).
- **Dynamic Start and Goal Points**: Automatically detects the starting point and the goal point in the maze.
- **Obstacle Handling**: Navigates around obstacles marked by `O`.
- **Path Tracing**: Displays the solution path using directions (Up, Down, Left, Right).

## Usage

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/maze-solver.git

2. **Prepare a Maze Text File**
   The file should be formatted as follows:
   [number_of_rows]
   [number_of_columns]
   [maze_representation]
   
Example Maze:

  5 10
OOOOOOOOOO
OSSSOSSSSO
OSOOSSOOSO
OMSSSKSSSO
OOOOOOOOOO

3. **Input the Filename:**
    When prompted, enter the name of your maze file.
    ***Requirements***
    Java Development Kit (JDK) 8 or higher

