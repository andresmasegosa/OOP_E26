package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.rules.LShape;

/**
 * The knight jumps in an L, two squares along one axis and one along the other.
 * It holds one rule, an LShape.
 */
public class Knight extends ChessPiece {

    public Knight(Color color) {          // exercise 1
        super(PieceType.KNIGHT, color);     // exercise 2
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
