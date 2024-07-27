package com.redplover.app;

public class Validator {

    public Validator() {}

    public boolean validation(int type, int color, int x1, int x2, int y1, int y2) {
        GameState state = new GameState();
        int colorof2 = state.checkPiece(x2, y2) % 10;
        if (state.checkPiece(x2, y2) == 0) colorof2 = -1;
        if (((color == 0 && App.whiteTurn && (colorof2 == 1 || colorof2 == -1)) || (color == 1 && !App.whiteTurn && (colorof2 == 0 || colorof2 == -1)))) {
            if (type == 1) {
                if (((x2 == x1) && colorof2 == -1 && ((y1 - y2 == 1 && App.whiteTurn) || (y2 - y1 == 1 && !App.whiteTurn)))
                        || (((x2 == x1) && ((y1 - y2 == 2 && state.checkPiece(x2, y2 + 1) == 0 && App.whiteTurn) || (y2 - y1 == 2 && state.checkPiece(x2, y2 - 1) == 0 && !App.whiteTurn))) && (y1 == 7 || y1 == 2))
                        || (x2 - 1 == x1 && y1 - y2 == 1 && colorof2 == 1)
                        || (x2 + 1 == x1 && y1 - y2 == 1 && colorof2 ==1)
                        || (x2 - 1 == x1 && y2 - y1 == 1 && colorof2 == 0)
                        || (x2 + 1 == x1 && y2 - y1 == 1 && colorof2 ==0)) return true;
                else return false;
            } else if (type == 2) {
                if (x2 == x1 || y2 == y1) {
                    if (Math.abs(x1 - x2) == 1 || Math.abs(y1 - y2) == 1) { return true;
                    } else if (x2 == x1) {
                        if (y2 > y1) {
                            for (int i = y1 + 1; i < y2; i++) {
                                if (state.checkPiece(x1, i) != 0) return false;
                            }
                        } else {
                            for (int i = y1 - 1; i > y2; i--) {
                                if (state.checkPiece(x1, i) != 0) return false;
                            }
                        }
                    } else {
                        if (x2 > x1) {
                            for (int i = x1 + 1; i < x2; i++) {
                                if (state.checkPiece(i, y1) != 0) return false;
                            }
                        } else {
                            for (int i = x1 - 1; i > x2; i--) {
                                if (state.checkPiece(i, y1) != 0) return false;
                            }
                        }
                    }
                    return true;
                } else return false;
            } else if (type == 3) {
                if ((Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 2) || (Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 1)) return true;
                else return false;
            } else if (type == 4) {
                if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
                    if (x2 > x1 && y2 > y1) {
                        for (int i = 1; i < x2 - x1; i++) {if (state.checkPiece(x1 + i, y1 + i) != 0) {return false;}}
                    } else if (x2 > x1 && y2 < y1) {
                        for (int i = 1; i < x2 - x1; i++) {if (state.checkPiece(x1 + i, y1 - i) != 0) {return false;}}
                    } else if (x2 < x1 && y2 > y1) {
                        for (int i = 1; i < x1 - x2; i++) {if (state.checkPiece(x1 - i, y1 + i) != 0) {return false;}}
                    } else if (x2 < x1 && y2 < y1) {
                        for (int i = 1; i < x1 - x2; i++) {if (state.checkPiece(x1 - i, y1 - i) != 0) {return false;}}
                    }
                    return true;
                } else return false;
            } else if (type == 5) {
                if ((x2 == x1) || (y2 == y1)) {
                    if (x2 == x1) {
                        if (y2 > y1) {
                            for (int i = y1 + 1; i < y2; i++) {
                                if (state.checkPiece(x1, i) != 0) return false;
                            }
                        } else {
                            for (int i = y1 - 1; i > y2; i--) {
                                if (state.checkPiece(x1, i) != 0) return false;
                            }
                        }
                    } else {
                        if (x2 > x1) {
                            for (int i = x1 + 1; i < x2; i++) {
                                if (state.checkPiece(i, y1) != 0) return false;
                            }
                        } else {
                            for (int i = x1 - 1; i > x2; i--) {
                                if (state.checkPiece(i, y1) != 0) return false;
                            }
                        }
                    }
                    return true;
                }
                if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
                    if (x2 > x1 && y2 > y1) {
                        for (int i = 1; i < x2 - x1; i++) {if (state.checkPiece(x1 + i, y1 + i) != 0) {return false;}}
                    } else if (x2 > x1 && y2 < y1) {
                        for (int i = 1; i < x2 - x1; i++) {if (state.checkPiece(x1 + i, y1 - i) != 0) {return false;}}
                    } else if (x2 < x1 && y2 > y1) {
                        for (int i = 1; i < x1 - x2; i++) {if (state.checkPiece(x1 - i, y1 + i) != 0) {return false;}}
                    } else if (x2 < x1 && y2 < y1) {
                        for (int i = 1; i < x1 - x2; i++) {if (state.checkPiece(x1 - i, y1 - i) != 0) {return false;}}
                    }
                    return true;
                }
                return false;
            } else if (type == 6) {
                if (Math.abs(x2 - x1) <= 1 && Math.abs(y2 - y1) <= 1) return true;
                else return false;
            } else return false;
        } else return false;
    }
}
