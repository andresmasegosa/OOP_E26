package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.rules.Diagonal;
import session5.solution.C_ChessGame.rules.StraightLine;

/** The king: one square in any direction, so both rules with a reach of one. */
public class King extends ChessPiece {

    public King(String color) {
        super("King", color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
    }

    @Override
    protected char getLetter() {
        return 'K';
    }
}
