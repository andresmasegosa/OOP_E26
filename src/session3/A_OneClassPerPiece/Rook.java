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
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 7);
    }
}
