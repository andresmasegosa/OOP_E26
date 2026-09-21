package session5.C_ChessGame;

import session5.C_ChessGame.rules.Diagonal;
import session5.C_ChessGame.rules.StraightLine;

/**
 * The queen: straight lines and diagonals, as far as she likes. Session 3's
 * Queen held a method with three calls in it; this one adds two rules and
 * holds no method at all.
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super("Queen", color);
        addRule(new StraightLine(7));
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'Q';
    }
}
