package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.LShape;
import session5.solution.C_ChessGame.rules.StraightLine;

/**
 * Exercise 1. A rook and a knight in one piece, and the constructor says
 * exactly that. In session 3 this piece had to choose a superclass and copy
 * the other half.
 */
public class Chancellor extends ChessPiece {

    public Chancellor(String color) {
        super("Chancellor", color);
        addRule(new StraightLine(7));
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
