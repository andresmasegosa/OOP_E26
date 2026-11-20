package session11.solution.C_ChessGame;

import session11.solution.C_ChessGame.rules.Diagonal;
import session11.solution.C_ChessGame.rules.StraightLine;

/**
 * The king moves one square in any direction. It holds a StraightLine and a
 * Diagonal, both with a reach of one.
 */
public class King extends ChessPiece {

    public King(Color color) {
        super(PieceType.KING, color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
    }

    @Override
    protected char getLetter() {
        return 'K';
    }
}
