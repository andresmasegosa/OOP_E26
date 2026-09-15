package session4.B_Player;

import session4.B_Player.rules.StraightLine;

/** The rook: one rule, the straight line, as far as it likes. */
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
