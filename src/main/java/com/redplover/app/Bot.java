package com.redplover.app;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Bot {
    private GameState state;
    private Validator validator;
    private int botColor; // 0 for white, 1 for black

    public Bot(GameState state, Validator validator, int botColor) {
        this.state = state;
        this.validator = validator;
        this.botColor = botColor;
    }

    public int[] makeMove() {
        HashMap<Integer, Integer> coordinatePlane = state.getMap();
        int[] bestMove = minimax(3, true, coordinatePlane);
        if (bestMove != null) {
            return new int[]{bestMove[1], bestMove[2]};
        } else {
            System.out.println("No valid moves available for the bot.");
            return new int[]{-1, -1};
        }
    }

    private int evaluateBoard() {
        int score = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                int piece = state.checkPiece(x, y);
                score += getPieceValue(piece);
            }
        }
        return score;
    }

    private int getPieceValue(int piece) {
        switch (piece) {
            case 11: case 10: return 1; // Pawn
            case 21: case 20: return 5; // Rook
            case 31: case 30: return 3; // Knight
            case 41: case 40: return 3; // Bishop
            case 51: case 50: return 9; // Queen
            case 61: case 60: return 100; // King
            default: return 0;
        }
    }

    private int[] minimax(int depth, boolean isMaximizingPlayer, HashMap<Integer, Integer> coordinatePlane) {
        int[] bestMove = new int[2];

        if (depth == 0) {
            return new int[]{evaluateBoard(), -1, -1};
        }

        List<int[]> validMoves = generateValidMoves(isMaximizingPlayer, coordinatePlane);
        if (validMoves.isEmpty()) {
            return bestMove; // No valid moves
        }

        int bestScore = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int[] move : validMoves) {
            int from = move[0];
            int to = move[1];
            int piece = state.checkPiece(from / 10, from % 10);
            int capturedPiece = state.checkPiece(to / 10, to % 10);

            coordinatePlane.replace(to, piece);
            coordinatePlane.replace(from, 0);

            int score = minimax(depth - 1, !isMaximizingPlayer, coordinatePlane)[0];

            coordinatePlane.replace(from, piece);
            coordinatePlane.replace(to, capturedPiece);

            if (isMaximizingPlayer) {
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = move;
                }
            } else {
                if (score < bestScore) {
                    bestScore = score;
                    bestMove = move;
                }
            }
        }

        return bestMove != null ? new int[]{bestScore, bestMove[0], bestMove[1]} : null;
    }

    private List<int[]> generateValidMoves(boolean isMaximizingPlayer, HashMap<Integer, Integer> coordinatePlane) {
        List<int[]> validMoves = new ArrayList<>();
        int color = isMaximizingPlayer ? botColor : 1 - botColor;

        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                int piece = coordinatePlane.get((x*10)+y);
                if (piece != 0 && (piece % 10 == color)) {
                    for (int x2 = 1; x2 <= 8; x2++) {
                        for (int y2 = 1; y2 <= 8; y2++) {
                            if (validator.validation(piece / 10, piece % 10, x, x2, y, y2)) {
                                validMoves.add(new int[]{(x * 10) + y, (x2 * 10) + y2});
                            }
                        }
                    }
                }
            }
        }

        return validMoves;
    }
}
