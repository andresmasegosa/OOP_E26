package session3.A_OneClassPerPiece;

/**
 * Session 3, step A. One class per type of piece, and nothing else.
 *
 * Session 2 ended with one switch left in ChessPiece.isLegalMove, a case per
 * type of piece. The most direct way to get rid of it is to write one class
 * per type of piece. A Queen knows how a queen moves and a Rook knows how a
 * rook moves, so no code has to ask a piece what type it is.
 *
 * This step has no board. The rules here only look at the shape of the move
 * and do not check the squares in between. The full rules come back in
 * E_ChessGame.
 */
public class Queen {

    private String color;
    private int row;
    private int col;

    public Queen(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    /** Along a row, along a column or along a diagonal, any distance. */
    public boolean isLegalMove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - row);
        int colDistance = Math.abs(toCol - col);
        if (rowDistance == 0 && colDistance == 0) {
            return false;   // not moving at all
        }
        return rowDistance == 0 || colDistance == 0 || rowDistance == colDistance;
    }
}
