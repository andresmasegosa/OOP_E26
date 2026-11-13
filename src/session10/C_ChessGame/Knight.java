package session10.C_ChessGame;

import session10.C_ChessGame.rules.LShape;

/**
 * The knight jumps in an L, two squares along one axis and one along the other.
 * It holds one rule, an LShape.
 */
public class Knight extends ChessPiece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
