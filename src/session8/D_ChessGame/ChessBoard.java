package session8.D_ChessGame;

import java.util.HashMap;
import java.util.Map;

/**
 * The board, eight rows by eight columns, and the pieces on it. A square holds
 * at most one piece, and a piece on the board knows the square it stands on.
 */
public class ChessBoard {

    private Map<Position, ChessPiece> pieces = new HashMap<>();

    /** The piece on that square, or null for an empty square or a square off the board. */
    public ChessPiece getPieceAt(int row, int col) {
        if (!isOnBoard(row, col)) {
            return null;
        }
        return pieces.get(new Position(row, col));
    }

    private static boolean isOnBoard(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    /** Places a piece on an empty square. Answers false when the square is taken or off the board. */
    public boolean placePiece(int row, int col, ChessPiece piece) {
        if (!isOnBoard(row, col)) {
            return false;
        }
        if (pieces.get(new Position(row, col)) != null) {
            return false;
        }
        pieces.put(new Position(row, col), piece);
        piece.setRow(row);
        piece.setCol(col);
        return true;
    }

    /** Moves a piece if its rules allow the move. Answers false, and moves nothing, when they do not. */
    public boolean movePiece(ChessPiece piece, int toRow, int toCol) {
        if (piece == null) {
            return false;
        }
        if (!isOnBoard(piece.getRow(), piece.getCol())) {
            return false;               // a piece that is not on the board cannot move
        }
        if (!isOnBoard(toRow, toCol)) {
            return false;
        }

        // A piece may capture an enemy piece, but never one of its own.
        ChessPiece target = pieces.get(new Position(toRow, toCol));
        if (target != null && target.isWhite() == piece.isWhite()) {
            return false;
        }

        if (!piece.isLegalMove(this, toRow, toCol)) {
            return false;
        }

        pieces.remove(new Position(piece.getRow(), piece.getCol()));
        pieces.put(new Position(toRow, toCol), piece);
        piece.setRow(toRow);
        piece.setCol(toCol);
        return true;
    }

    /** Draws the board on the console, White in uppercase and Black in lowercase. */
    public void print() {
        System.out.println();
        System.out.println("        0 1 2 3 4 5 6 7   <- col");
        System.out.println("      +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print("row " + row + " | ");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = pieces.get(new Position(row, col));
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("      +-----------------+");
        System.out.println("      UPPERCASE = White, lowercase = black");
        System.out.println("      K king, Q queen, R rook, B bishop, N knight, . empty square");
    }
}
