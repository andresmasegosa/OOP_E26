package session11.solution.C_ChessGame;

import session11.solution.C_ChessGame.rules.Leap;

/**
 * The knight jumps in an L, two squares along one axis and one along the other.
 * It holds one rule, a Leap(2, 1).
 */
public class Knight extends ChessPiece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
        addRule(new Leap(2, 1));
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
