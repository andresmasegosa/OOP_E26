package session5.C_ChessGame;

import session5.C_ChessGame.rules.StraightLine;

/** The rook: straight lines, as far as it likes. */
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
