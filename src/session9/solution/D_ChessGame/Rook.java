package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.rules.StraightLine;

/**
 * The rook moves any number of squares along a row or a column. It holds one
 * rule, a StraightLine with a reach of seven.
 */
public class Rook extends ChessPiece {

    public Rook(Color color) {          // exercise 1
        super(PieceType.ROOK, color);     // exercise 2
        addRule(new StraightLine(7));
    }

    @Override
    protected char getLetter() {
        return 'R';
    }
}
