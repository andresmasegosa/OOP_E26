package session11.C_ChessGame.rules;

import session11.C_ChessGame.ChessBoard;

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
}
