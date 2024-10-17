# Battleship Game

This project is a Java-based implementation of the classic Battleship game. The game allows a user to place ships, make attacks, and play against an opponent until a winner is determined.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+

### Installation

1. Clone this repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd battleship-game
   ```
3. Compile the project using Maven:
   ```sh
   mvn compile
   ```

### Running the Game

To start the game, run the following command:

```sh
mvn exec:java -D"exec.mainClass=abdn.scnu.ai.RunGame" -D"exec.args=arg1 arg2 arg3"
```

The game will prompt for the necessary input to set up the game grid, including:
- Width and height of the grid
- Number of ships
- Ship placements

After starting the game, you can continue playing rounds by entering coordinates or use the "exit" command to stop the game.

## Features

### Task 1: Battleship Creation
- Creates Battleship objects with unique names.
- Sets the orientation of each ship (vertical or horizontal) randomly.

### Task 2: Displaying the Game Grid
- Provides functionality to display the game grid, allowing players to see ship placements and attacks.
- Ships are randomly placed, and the grid is updated after each move.

### Task 3: Game Rounds and Attack Handling
- Implements rounds for gameplay, allowing players to attack opponent ships.
- Tracks hits, and updates grid markings with "X" for hits and "%" for misses.

### Task 4: Game Control Mechanisms
- Uses arguments in the main method to accept user input.
- Implements victory checks and handles game exit conditions.

### Task 5: Reporting and Code Comments
- Includes comments throughout the code for better understanding.
- Provided detailed reports on different classes and methods.

## Challenges Faced

Initially, the development faced challenges due to lack of familiarity with Java basics. Learning was done gradually through textbooks, online resources, and class slides. Logical issues were resolved by revisiting each file, debugging, and improving the code iteratively.

## How to Play

1. Launch the game by running the Maven command mentioned above.
2. Enter grid dimensions, the number of ships, and the ship placements.
3. Attack by providing grid coordinates, e.g., "3 5".
4. Type "exit" to stop the game.

## Credits

This project was inspired and developed as part of a learning exercise with the guidance of course instructors and online resources.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
