### Documentation for `GameState.java`

#### Class: `GameState`

The `GameState` class manages the state of the chess game, including the positions of pieces on the board.

#### Fields:
- `public static HashMap<Integer, Integer> coordinatePlane`: A static `HashMap` representing the board, where the key is a coordinate (x * 10 + y) and the value is the piece code.

#### Constructor:
- `public GameState()`: Initializes a new instance of the `GameState` class.

#### Methods:

- `public void putInMap(int xy, int piece)`:
    - Adds a piece to the board at the specified coordinate.
    - Parameters:
        - `xy`: An integer representing the coordinate (x * 10 + y).
        - `piece`: An integer code representing the piece.

- `public void updateMap(Integer xy, Integer piece)`:
    - Updates the piece at the specified coordinate.
    - Parameters:
        - `xy`: An integer representing the coordinate (x * 10 + y).
        - `piece`: An integer code representing the piece.

- `public int checkPiece(int x, int y)`:
    - Retrieves the piece code at the specified coordinates.
    - Parameters:
        - `x`: The x-coordinate on the board.
        - `y`: The y-coordinate on the board.
    - Returns:
        - An integer code representing the piece at the specified coordinates.

#### Usage Example:
```java
public static void main(String[] args) {
    GameState state = new GameState();
    state.putInMap(11, 1); // Place a white pawn at coordinate (1, 1)
    int piece = state.checkPiece(1, 1); // Check the piece at coordinate (1, 1)
    System.out.println("Piece at (1, 1): " + piece);
}
```
