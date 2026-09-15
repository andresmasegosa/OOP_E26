package session4.C_ChessGame;

import session4.C_ChessGame.rules.Diagonal;

/**
 * The bishop: diagonals, as far as it likes. You wrote this class in
 * session 3 and it held a method; here it holds the same Diagonal class the
 * queen uses.
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
