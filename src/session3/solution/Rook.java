package session3.solution;

/** The rook, as in the session. */
public class Rook extends ChessPiece {

    public Rook(String color) {
        super("Rook", color);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, int toRow, int toCol) {
        return Movements.isLegalHorizontalMove(board, getRow(), getCol(), toRow, toCol, 7)
                || Movements.isLegalVerticalMove(board, getRow(), getCol(), toRow, toCol, 7);
    }

    @Override
    protected char getLetter() {
        return 'R';
    }
}
