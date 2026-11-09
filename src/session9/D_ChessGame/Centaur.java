package session9.D_ChessGame;

import session9.D_ChessGame.rules.Diagonal;
import session9.D_ChessGame.rules.LShape;
import session9.D_ChessGame.rules.StraightLine;

/**
 * The centaur, from session 8, moves like a king or like a knight. It is not
 * placed in the game.
 */
public class Centaur extends ChessPiece {

    public Centaur(String color) {
        super("Centaur", color);
        addRule(new StraightLine(1));
        addRule(new Diagonal(1));
        addRule(new LShape());
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
