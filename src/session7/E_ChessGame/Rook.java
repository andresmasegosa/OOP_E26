package session7.E_ChessGame;

import session7.E_ChessGame.rules.StraightLine;

/**
 * The rook moves any number of squares along a row or a column. It holds one
 * rule, a StraightLine with a reach of seven.
 */
public class Rook extends ChessPiece {

    public Rook(String color) {
        super("Rook", color);
        addRule(new StraightLine(7));
    }

    @Override
    protected char getLetter() {
        return 'R';
    }
}
