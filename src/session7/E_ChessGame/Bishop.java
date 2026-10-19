package session7.E_ChessGame;

import session7.E_ChessGame.rules.Diagonal;

/**
 * The bishop moves any number of squares along a diagonal. It holds one rule,
 * a Diagonal with a reach of seven.
 */
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super("Bishop", color);
        addRule(new Diagonal(7));
    }

    @Override
    protected char getLetter() {
        return 'B';
    }
}
