### Documentation for `Validator.java`

#### Class: `Validator`

The `Validator` class is responsible for validating the moves of chess pieces based on the rules of chess.

#### Constructor:
- `public Validator()`: Initializes a new instance of the `Validator` class.

#### Methods:

- `public boolean validation(int type, int color, int x1, int x2, int y1, int y2)`:
    - Validates whether a move is legal based on the type and color of the piece and the coordinates of the move.
    - Parameters:
        - `type`: An integer representing the type of the piece (1 = Pawn, 2 = Rook, 3 = Knight, 4 = Bishop, 5 = Queen, 6 = King).
        - `color`: An integer representing the color of the piece (0 = White, 1 = Black).
        - `x1`: The x-coordinate of the starting position.
        - `x2`: The x-coordinate of the ending position.
        - `y1`: The y-coordinate of the starting position.
        - `y2`: The y-coordinate of the ending position.
    - Returns:
        - A boolean indicating whether the move is valid.

- `public boolean isCheck(int color)`:
    - Checks if the current board state is a check for the given color.
    - Parameters:
        - `color`: An integer representing the color of the player (0 = White, 1 = Black).
    - Returns:
        - A boolean indicating whether the given color is in check.

- `public boolean isCheckmate(int color)`:
    - Checks if the current board state is a checkmate for the given color.
    - Parameters:
        - `color`: An integer representing the color of the player (0 = White, 1 = Black).
    - Returns:
        - A boolean indicating whether the given color is in checkmate.

- `public boolean isStalemate(int color)`:
    - Checks if the current board state is a stalemate for the given color.
    - Parameters:
        - `color`: An integer representing the color of the player (0 = White, 1 = Black).
    - Returns:
        - A boolean indicating whether the given color is in stalemate.

#### Usage Example:
```java
public static void main(String[] args) {
    Validator validator = new Validator();
    boolean isValid = validator.validation(1, 0, 2, 2, 7, 5); // Validate a move for a white pawn
    System.out.println("Is the move valid? " + isValid);

    boolean isCheck = validator.isCheck(0); // Check if white is in check
    System.out.println("Is white in check? " + isCheck);

    boolean isCheckmate = validator.isCheckmate(1); // Check if black is in checkmate
    System.out.println("Is black in checkmate? " + isCheckmate);

    boolean isStalemate = validator.isStalemate(0); // Check if white is in stalemate
    System.out.println("Is white in stalemate? " + isStalemate);
}
```
