package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.Diagonal;
import session5.solution.C_ChessGame.rules.LShape;
import session5.solution.C_ChessGame.rules.StraightLine;

/**
 * Exercise 1. A queen and a knight. Three rules, three lines, and the cost
 * line of the session.
 *
 * Session 3's Amazon extended Queen, called super.isLegalMove for the queen's
 * part, and needed the knight's L from a class it did not extend. The wish
 * that closed session 3 was exactly this class written without that trouble.
 */
public class Amazon extends ChessPiece {

    public Amazon(String color) {
        super("Amazon", color);
        addRule(new StraightLine(7));
        addRule(new Diagonal(7));
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'A';   // as in session 3's solution
    }
}
