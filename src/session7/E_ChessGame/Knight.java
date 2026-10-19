package session7.E_ChessGame;

import session7.E_ChessGame.rules.LShape;

/**
 * The knight jumps in an L, two squares along one axis and one along the other.
 * It holds one rule, an LShape.
 */
public class Knight extends ChessPiece {

    public Knight(String color) {
        super("Knight", color);
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'N';
    }
}
