package session5.B_Player;

/** A board cut down to what this step needs. */
public class ChessBoard {

    private ChessPiece[][] pieces = new ChessPiece[8][8];

    public ChessPiece getPieceAt(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            return null;
        }
        return pieces[row][col];
    }

    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            return false;
        }
        if (pieces[row][col] != null) {
            return false;
        }
        pieces[row][col] = piece;
        piece.setRow(row);
        piece.setCol(col);
        return true;
    }

    public void print() {
        System.out.println();
        System.out.println("        0 1 2 3 4 5 6 7   <- col");
        System.out.println("      +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print("row " + row + " | ");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = pieces[row][col];
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("      +-----------------+");
    }
}
