package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.rules.Diagonal;
import session9.solution.D_ChessGame.rules.StraightLine;

/**
 * The king moves one square in any direction. It holds a StraightLine and a
 * Diagonal, both with a reach of one.
 */
public class King extends ChessPiece {

    public King(Color color) {          // exercise 1
        super(PieceType.KING, color);     // exercise 2
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
    }

    @Override
    protected char getLetter() {
        return 'K';
    }
}
