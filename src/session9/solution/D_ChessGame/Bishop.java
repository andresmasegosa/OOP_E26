package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.rules.Diagonal;

/**
 * The bishop moves any number of squares along a diagonal. It holds one rule,
 * a Diagonal with a reach of seven.
 */
public class Bishop extends ChessPiece {

    public Bishop(Color color) {          // exercise 1
        super(PieceType.BISHOP, color);     // exercise 2
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'B';
    }
}
