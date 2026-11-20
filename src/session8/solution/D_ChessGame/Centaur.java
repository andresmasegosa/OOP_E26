package session8.solution.D_ChessGame;

import session8.solution.D_ChessGame.rules.Diagonal;
import session8.solution.D_ChessGame.rules.LShape;
import session8.solution.D_ChessGame.rules.StraightLine;

/**
 * Exercise 3. The centaur moves like a king or like a knight. Each rule was
 * added after the test in CentaurTest that asks for it.
 */
public class Centaur extends ChessPiece {

    public Centaur(String color) {
        super("Centaur", color);
        addRule(new StraightLine(1));                // step 1
        addRule(new Diagonal(1));                    // step 2
        addRule(new LShape());                       // step 3
    }

    @Override
    protected char getLetter() {
        return 'C';
    }
}
