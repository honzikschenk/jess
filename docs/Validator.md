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

#### Usage Example:
```java
public static void main(String[] args) {
    Validator validator = new Validator();
    boolean isValid = validator.validation(1, 0, 2, 2, 7, 5); // Validate a move for a white pawn
    System.out.println("Is the move valid? " + isValid);
}
```
