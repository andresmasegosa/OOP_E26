package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.Diagonal;
import session5.solution.C_ChessGame.rules.LShape;

/** Exercise 1. A bishop and a knight. */
public class Archbishop extends ChessPiece {

    public Archbishop(String color) {
        super("Archbishop", color);
        addRule(new Diagonal(7));
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'H';
    }
}
