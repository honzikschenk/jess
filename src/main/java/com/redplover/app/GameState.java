package com.redplover.app;

import java.util.HashMap;

/*
NOTE:
Piece + Color = PC

1 = Pawn
2 = Rook
3 = Knight
4 = Bishop
5 = Queen
6 = King

0 = White
1 = Black
*/

public class GameState {

    public static HashMap<Integer, Integer> coordinatePlane = new HashMap<Integer, Integer>();

    public GameState() {}

    public void putInMap(int xy, int piece) {
        coordinatePlane.put(xy, piece);
    }

    public void updateMap(Integer xy, Integer piece) {
        coordinatePlane.replace(xy, piece);
    }

    public int checkPiece(int x, int y) {
        return coordinatePlane.get((x*10)+y);
    }
}
