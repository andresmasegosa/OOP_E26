package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.Diagonal;
import session5.solution.C_ChessGame.rules.StraightLine;

/**
 * The queen moves along straight lines and diagonals. Its constructor adds
 * the two rules; getLetter supplies Q. Movement is decided by the inherited
 * ChessPiece.isLegalMove method.
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
