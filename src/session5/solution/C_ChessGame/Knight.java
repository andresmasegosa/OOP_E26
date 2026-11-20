package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.LShape;

/** Exercise A, copied into the game in exercise 1. One rule, the L. */
public class Knight extends ChessPiece {

    public Knight(String color) {
        super("Knight", color);
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
