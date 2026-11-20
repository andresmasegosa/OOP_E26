package session10.solution.C_ChessGame.rules;

import session10.solution.C_ChessGame.ChessBoard;

/**
 * Exercise 1. A jump of rows squares in one direction and cols squares in the
 * other. A jump does not depend on the pieces in between, so this rule does not
 * use the board. The knight uses a Leap(2, 1).
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
