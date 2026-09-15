package session3.A_OneClassPerPiece;

/**
 * Session 3, step A. One class per type of piece, and nothing else.
 *
 * Session 2 ended with one switch left in ChessPiece.isLegalMove, a case per
 * type of piece. The most direct way to get rid of it is to write one class
 * per type of piece. A Queen knows how a queen moves and a Rook knows how a
 * rook moves, so no code has to ask a piece what type it is.
 *
 * The rule itself is not the lesson of this session, so it is not written
 * here: it asks Movements, session 1's helper class, exactly as the game does
 * in E_ChessGame. This step has no board, so this Movements checks only the
 * shape of the move and not the squares in between. The full ones come back
 * with the board, in E_ChessGame.
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
        return Movements.isLegalHorizontalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalVerticalMove(row, col, toRow, toCol, 7)
                || Movements.isLegalDiagonalMove(row, col, toRow, toCol, 7);
    }
}
