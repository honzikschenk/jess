### Documentation for `Chess.java`

#### Class: `Chess`

The `Chess` class represents a chess game with a graphical user interface (GUI) using Java Swing. It handles the initialization of the chessboard, the placement of pieces, and the logic for moving pieces.

#### Fields:
- `JButton[][] boardSquares`: A 2D array representing the chessboard squares.
- `GameState state`: An instance of the `GameState` class to manage the state of the game.
- `Validator val`: An instance of the `Validator` class to validate moves.
- `JFrame jFrame`: The main frame for the chess game.
- `static int x1, y1`: Coordinates for the first selected square.
- `private static boolean isWhite`: A boolean indicating whether the player is playing as white.
- `private Minimax minimax`: An instance of the `Minimax` class to handle the bot's move logic.

#### Constructor:
- `public Chess()`: Initializes a new instance of the `Chess` class.

#### Methods:

- `public void start(boolean isWhite) throws IOException`:
    - Initializes the chessboard and places the pieces.
    - Sets up the GUI components and displays the main frame.
    - Parameters:
        - `isWhite`: A boolean indicating whether the player is playing as white.

- `private void initializeBoard(boolean isWhite)`:
    - Sets up the initial positions of the pieces on the board.
    - Parameters:
        - `isWhite`: A boolean indicating whether the player is playing as white.

- `private void setupPieces(int pawn, int pawnOpp, int rook, int knight, int bishop, int queen, int king, int rookOpp, int knightOpp, int bishopOpp, int queenOpp, int kingOpp)`:
    - Places the pieces on the board based on the provided piece codes.
    - Parameters:
        - `pawn`, `pawnOpp`, `rook`, `knight`, `bishop`, `queen`, `king`, `rookOpp`, `knightOpp`, `bishopOpp`, `queenOpp`, `kingOpp`: Integer codes representing different pieces.

- `public void check(int x, int y)`:
    - Handles the logic for selecting and moving pieces on the board.
    - Parameters:
        - `x`, `y`: Coordinates of the selected square.

- `private void makeBotMove()`:
    - Handles the bot's move logic using the minimax algorithm with alpha-beta pruning.

#### Usage Example:
```java
public static void main(String[] args) {
    Chess game = new Chess();
    try {
        game.start(true); // Start the game with the player as white
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
