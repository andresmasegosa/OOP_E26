package session10.C_ChessGame;

import session10.C_ChessGame.rules.Diagonal;

/**
 * The bishop moves any number of squares along a diagonal. It holds one rule,
 * a Diagonal with a reach of seven.
 */
public class Bishop extends ChessPiece {

    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'B';
    }
}
