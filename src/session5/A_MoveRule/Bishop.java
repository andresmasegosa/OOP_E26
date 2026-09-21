package session5.A_MoveRule;

import session5.A_MoveRule.rules.Diagonal;

/** The bishop: one rule, the diagonal. The same Diagonal class the queen uses. */
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
