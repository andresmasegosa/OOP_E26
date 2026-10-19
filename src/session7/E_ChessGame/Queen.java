package session7.E_ChessGame;

import session7.E_ChessGame.rules.Diagonal;
import session7.E_ChessGame.rules.StraightLine;

/**
 * The queen moves like a rook and like a bishop. It holds a StraightLine and
 * a Diagonal, both with a reach of seven.
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
