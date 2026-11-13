package session10.C_ChessGame;

import session10.C_ChessGame.rules.StraightLine;

/**
 * The rook moves any number of squares along a row or a column. It holds one
 * rule, a StraightLine with a reach of seven.
 */
public class Rook extends ChessPiece {

    public Rook(Color color) {
        super(PieceType.ROOK, color);
        addRule(new StraightLine(7));
    }

    @Override
    protected char getLetter() {
        return 'R';
    }
}
