package session11.solution.C_ChessGame.rules;

import session11.solution.C_ChessGame.ChessBoard;

/**
 * A jump of rows squares in one direction and cols squares in the other. A
 * jump does not depend on the pieces in between, so this rule does not use the
 * board. The knight uses a Leap(2, 1), and a camel would use a Leap(3, 1).
 */
public class Leap implements MoveRule {

    private int rows;
    private int cols;

    public Leap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public boolean allows(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);
        return (rowDistance == rows && colDistance == cols)
                || (rowDistance == cols && colDistance == rows);
    }

    public int getRows() {                                          // exercise 1
        return rows;
    }

    public int getCols() {                                          // exercise 1
        return cols;
    }

    @Override
    public void accept(RuleVisitor visitor) {                       // exercise 1
        visitor.visitLeap(this);
    }
}
