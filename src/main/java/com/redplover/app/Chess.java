package com.redplover.app;

import java.awt.*;

import javax.swing.*;

import java.io.IOException;
import java.util.Objects;

public class Chess {

    JButton[][] boardSquares = new JButton[8][8];
    GameState state = new GameState();
    Validator val = new Validator();
    Bot bot;
    JFrame jFrame = new JFrame("Jess");

    private static int x1 = 100;
    private static int y1 = 100;

    private static boolean isWhite;

    private static Color white = Color.decode("#CCC7B9");
    private static Color black = Color.decode("#E2D4BA");

    private static Color selected = Color.decode("#AF7A6D");

    public Chess() {
    }

    public void start(boolean isWhite) throws IOException {
        jFrame.setLayout(new GridLayout(8, 8));
        jFrame.setSize(700, 700);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.isWhite = isWhite;
        bot = new Bot(state, val, isWhite ? 1 : 0);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                JButton b = new JButton();
                if ((x % 2 == 1 && y % 2 == 1) || (x % 2 == 0 && y % 2 == 0)) {
                    b.setBackground(isWhite ? white : black);
                } else {
                    b.setBackground(isWhite ? black : white);
                }

                boardSquares[x][y] = b;

                if ((x % 2 == 1 && y % 2 == 1) || (x % 2 == 0 && y % 2 == 0)) {
                    boardSquares[x][y].setBackground(isWhite ? white : black);
                } else {
                    boardSquares[x][y].setBackground(isWhite ? black : white);
                }

                final int yy = y;
                final int xx = x;
                boardSquares[x][y].addActionListener(e -> check(xx, yy));
                boardSquares[x][y].setOpaque(true);
                boardSquares[x][y].setContentAreaFilled(true);
                boardSquares[x][y].setBorderPainted(false);
                boardSquares[x][y].setFocusable(false);
                boardSquares[x][y].repaint();

                jFrame.add(b);
            }
        }

        if (isWhite) {
            for (int x = 0; x < 8; x++) {
                boardSquares[x][1].add(
                        new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 11 + ".png")))));
                state.putInMap(((x + 1) * 10) + 2, 11);
                boardSquares[x][6].add(
                        new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 10 + ".png")))));
                state.putInMap(((x + 1) * 10) + 7, 10);
            }
            // Black
            boardSquares[0][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 21 + ".png")))));
            state.putInMap(11, 21);
            boardSquares[7][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 21 + ".png")))));
            state.putInMap(81, 21);
            boardSquares[1][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 31 + ".png")))));
            state.putInMap(21, 31);
            boardSquares[6][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 31 + ".png")))));
            state.putInMap(71, 31);
            boardSquares[2][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 41 + ".png")))));
            state.putInMap(31, 41);
            boardSquares[5][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 41 + ".png")))));
            state.putInMap(61, 41);
            boardSquares[3][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 51 + ".png")))));
            state.putInMap(41, 51);
            boardSquares[4][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 61 + ".png")))));
            state.putInMap(51, 61);

            // White
            boardSquares[0][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 20 + ".png")))));
            state.putInMap(18, 20);
            boardSquares[7][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 20 + ".png")))));
            state.putInMap(88, 20);
            boardSquares[1][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 30 + ".png")))));
            state.putInMap(28, 30);
            boardSquares[6][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 30 + ".png")))));
            state.putInMap(78, 30);
            boardSquares[2][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 40 + ".png")))));
            state.putInMap(38, 40);
            boardSquares[5][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 40 + ".png")))));
            state.putInMap(68, 40);
            boardSquares[3][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 50 + ".png")))));
            state.putInMap(48, 50);
            boardSquares[4][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 60 + ".png")))));
            state.putInMap(58, 60);
        } else {
            for (int x = 0; x < 8; x++) {
                boardSquares[x][1].add(
                        new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 10 + ".png")))));
                state.putInMap(((x + 1) * 10) + 2, 10);
                boardSquares[x][6].add(
                        new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 11 + ".png")))));
                state.putInMap(((x + 1) * 10) + 7, 11);
            }
            // White
            boardSquares[0][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 20 + ".png")))));
            state.putInMap(11, 20);
            boardSquares[7][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 20 + ".png")))));
            state.putInMap(81, 20);
            boardSquares[1][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 30 + ".png")))));
            state.putInMap(21, 30);
            boardSquares[6][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 30 + ".png")))));
            state.putInMap(71, 30);
            boardSquares[2][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 40 + ".png")))));
            state.putInMap(31, 40);
            boardSquares[5][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 40 + ".png")))));
            state.putInMap(61, 40);
            boardSquares[3][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 50 + ".png")))));
            state.putInMap(41, 50);
            boardSquares[4][0]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 60 + ".png")))));
            state.putInMap(51, 60);

            // Black
            boardSquares[0][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 21 + ".png")))));
            state.putInMap(18, 21);
            boardSquares[7][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 21 + ".png")))));
            state.putInMap(88, 21);
            boardSquares[1][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 31 + ".png")))));
            state.putInMap(28, 31);
            boardSquares[6][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 31 + ".png")))));
            state.putInMap(78, 31);
            boardSquares[2][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 41 + ".png")))));
            state.putInMap(38, 41);
            boardSquares[5][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 41 + ".png")))));
            state.putInMap(68, 41);
            boardSquares[3][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 51 + ".png")))));
            state.putInMap(48, 51);
            boardSquares[4][7]
                    .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + 61 + ".png")))));
            state.putInMap(58, 61);
        }

        for (int y = 3; y < 7; y++) {
            for (int x = 0; x < 9; x++) {
                state.putInMap(((x + 1) * 10) + y, 0);
            }
        }

        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        if (!isWhite) {
            bot.makeMove();
            App.whiteTurn = !App.whiteTurn;
        }
    }

    public void check(int x, int y) {
        x++;
        y++;

        int x2;
        int y2;

        if (x1 == 100) {
            x1 = x;
            y1 = y;
            boardSquares[x1 - 1][y1 - 1].setBackground(selected);
            boardSquares[x1 - 1][y1 - 1].repaint();
        } else {
            x2 = x;
            y2 = y;

            if (!(x1 == x2 && y1 == y2)) {
                int symbol = state.checkPiece(x1, y1);
                int type = symbol / 10;
                int color = symbol % 10;
                int cond = state.checkPiece(x2, y2);
                if (validMove(type, color, x1, x2, y1, y2)) {
                    makeMove(x1, y1, x2, y2, cond);
                }
            }

            if ((x1 % 2 == 1 && y1 % 2 == 1) || (x1 % 2 == 0 && y1 % 2 == 0)) {
                boardSquares[x1 - 1][y1 - 1].setBackground(isWhite ? white : black);
            } else {
                boardSquares[x1 - 1][y1 - 1].setBackground(isWhite ? black : white);
            }
            boardSquares[x1 - 1][y1 - 1].repaint();
            x1 = 100;
            y1 = 100;
        }
    }

    public void makeMove(int x1, int y1, int x2, int y2, int cond) {
        boardSquares[x1 - 1][y1 - 1].removeAll();
        boardSquares[x2 - 1][y2 - 1].removeAll();
        boardSquares[x1 - 1][y1 - 1].setText("");
        int i = state.checkPiece(x1, y1);
        boardSquares[x2 - 1][y2 - 1].setText(Integer.toString(i));
        state.updateMap(x2 * 10 + y2, state.checkPiece(x1, y1));
        state.updateMap(x1 * 10 + y1, 0);
        boardSquares[x2 - 1][y2 - 1]
                .add(new JLabel(new ImageIcon(Objects.requireNonNull(App.class.getResource("/" + i + ".png")))));
        App.whiteTurn = !App.whiteTurn;
        jFrame.repaint();
        if (cond / 10 == 6) {
            JFrame jFrameOth;
            jFrameOth = new JFrame(App.whiteTurn ? "Black" : "White" + " wins");
            jFrameOth.setSize(200, 200);
            jFrameOth.setLocationRelativeTo(null);
            jFrameOth.setResizable(false);
            jFrameOth.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrameOth.setVisible(true);
            JLabel wins = new JLabel(App.whiteTurn ? "Black" : "White" + " wins!");
            wins.setHorizontalAlignment(SwingConstants.CENTER);
            wins.setHorizontalTextPosition(SwingConstants.CENTER);
            wins.setVerticalAlignment(SwingConstants.CENTER);
            wins.setVerticalTextPosition(SwingConstants.CENTER);
            jFrameOth.add(wins);
            jFrame.dispose();
        }

        if (App.whiteTurn && !isWhite || !App.whiteTurn && isWhite) {
            int[] move = bot.makeMove();
            makeMove(move[0] / 10, move[0] % 10, move[1] / 10, move[1] % 10, state.checkPiece(move[1] / 10, move[1] % 10));
        }
    }

    public boolean validMove(int type, int color, int x1, int x2, int y1, int y2) {
        return ((App.whiteTurn && state.checkPiece(x1, y1) % 10 == 0)
                || (!App.whiteTurn && state.checkPiece(x1, y1) % 10 == 1))
                && val.validation(type, color, x1, x2, y1, y2);
    }
}
