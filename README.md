# Chess Game Application

> [!IMPORTANT]
> The project is meant to practice Mavin use and general CI structure. The chess aspect is very basic.

This project is a Java-based chess game application that provides a graphical user interface (GUI) for playing chess. The application allows users to select their color (black or white) and start a game of chess against an opponent.

## Project Structure

- `App.java`: The entry point of the application, which initializes the GUI for selecting the player's color and starting the game.
- `Chess.java`: Manages the chess game, including the initialization of the chessboard, placement of pieces, and the logic for moving pieces.
- `GameState.java`: Manages the state of the chess game, including the positions of pieces on the board.
- `Validator.java`: Validates the moves of chess pieces based on the rules of chess.

## Documentation

For detailed documentation on each class, refer to the following files:

- [App.md](docs/App.md): Documentation for `App.java`
- [Chess.md](docs/Chess.md): Documentation for `Chess.java`
- [GameState.md](docs/GameState.md): Documentation for `GameState.java`
- [Validator.md](docs/Validator.md): Documentation for `Validator.java`

## Getting Started

To run the application, execute the `main` method in `App.java`. This will launch the GUI, allowing you to select your color and start the game.

## Requirements

- Java Development Kit (JDK)
- Maven (for managing dependencies)

## How to Play

1. Run the application.
2. Select your color (black or white) in the GUI.
3. Click "Start" to begin the game.
4. Play chess by clicking on the pieces and then clicking on the space you want them to move (according to the rules of chess).

Enjoy playing chess!
