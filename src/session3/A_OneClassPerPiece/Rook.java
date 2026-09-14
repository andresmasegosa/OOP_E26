package session3.A_OneClassPerPiece;

/**
 * The rook, written the way step A writes every piece. Put this file next to
 * Queen.java and compare them line by line. Only the rule is different.
 */
public class Rook {

    private String color;
    private int row;
    private int col;

    public Rook(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    /** Along a row or along a column, any distance. */
    public boolean isLegalMove(int toRow, int toCol) {
        int rowDistance = Math.abs(toRow - row);
        int colDistance = Math.abs(toCol - col);
        if (rowDistance == 0 && colDistance == 0) {
            return false;   // not moving at all
        }
        return rowDistance == 0 || colDistance == 0;
    }
}
