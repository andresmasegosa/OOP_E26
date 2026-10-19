package session7.E_ChessGame;

import session7.E_ChessGame.players.Move;
import session7.E_ChessGame.players.Player;

/**
 * A game of mini-chess between two players. It has kings, queens, rooks,
 * bishops and knights, and no pawns. A piece captures by moving onto an enemy
 * piece, and the game ends when a king is captured. ChessGame asks the player
 * whose turn it is for a move, and checks the move.
 */
public class ChessGame {

    private ChessBoard board;
    private boolean whiteToMove = true;
    private Player white;
    private Player black;
    private String winner;                // null while the game is running

    public ChessGame(Player white, Player black) {
        this.board = new ChessBoard();
        this.white = white;
        this.black = black;
        setupPieces();
    }

    public ChessBoard getBoard() {
        return board;
    }

    private void setupPieces() {
        // Black pieces, top of the board.
        board.placePiece(0, 0, new Rook("Black"));
        board.placePiece(0, 1, new Knight("Black"));
        board.placePiece(0, 2, new Bishop("Black"));
        board.placePiece(0, 3, new Queen("Black"));
        board.placePiece(0, 4, new King("Black"));
        board.placePiece(0, 5, new Bishop("Black"));
        board.placePiece(0, 6, new Knight("Black"));
        board.placePiece(0, 7, new Rook("Black"));

        // White pieces, bottom of the board.
        board.placePiece(7, 0, new Rook("White"));
        board.placePiece(7, 1, new Knight("White"));
        board.placePiece(7, 2, new Bishop("White"));
        board.placePiece(7, 3, new Queen("White"));
        board.placePiece(7, 4, new King("White"));
        board.placePiece(7, 5, new Bishop("White"));
        board.placePiece(7, 6, new Knight("White"));
        board.placePiece(7, 7, new Rook("White"));
    }

    public void printBoard() {
        board.print();
    }

    /** Plays until a king is captured, or until a player returns null instead of a move. */
    public void play() {
        boolean positionChanged = true;

        while (true) {
            if (positionChanged) {
                printBoard();
            }

            String color;
            Player current;
            if (whiteToMove) {
                color = "White";
                current = white;
            } else {
                color = "Black";
                current = black;
            }

            Move move = current.chooseMove(board, color);

            if (move == null) {          // KeyboardPlayer after q, or a player that finds no move
                System.out.println();
                System.out.println("Thanks for playing!");
                return;
            }

            positionChanged = takeTurn(move);

            if (winner != null) {
                printBoard();
                System.out.println();
                System.out.println(winner + " wins: the other king is off the board.");
                return;
            }
        }
    }

    /**
     * Checks that the piece on the first square belongs to the player to move,
     * and then tries the move. Answers true when the move was made.
     */
    private boolean takeTurn(Move move) {
        int fromRow = move.getFromRow();
        int fromCol = move.getFromCol();

        ChessPiece chosen = board.getPieceAt(fromRow, fromCol);   // null off the board too
        if (chosen == null) {
            System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
            return false;
        }
        if (chosen.isWhite() != whiteToMove) {
            System.out.println("That piece is not yours! The " + chosen.getColor() + " " + chosen.getType()
                    + " on (" + fromRow + "," + fromCol + ") belongs to the other player.");
            return false;
        }
        if (!movePiece(move)) {
            return false;
        }
        whiteToMove = !whiteToMove;
        return true;
    }

    /** Makes the move if ChessBoard.movePiece allows it, and prints what happened. */
    private boolean movePiece(Move move) {
        int fromRow = move.getFromRow();
        int fromCol = move.getFromCol();
        int toRow = move.getToRow();
        int toCol = move.getToCol();

        ChessPiece piece = board.getPieceAt(fromRow, fromCol);

        // Read the target before the move, to know whether it is a capture.
        ChessPiece target = board.getPieceAt(toRow, toCol);

        if (!board.movePiece(piece, toRow, toCol)) {
            System.out.println("Illegal move: (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol
                    + "): not how that piece moves, the path is blocked, or the target is your own piece");
            return false;
        }

        if (target != null) {
            System.out.println(piece.getColor() + " " + piece.getType() + " captures "
                    + target.getColor() + " " + target.getType() + " on (" + toRow + "," + toCol + ")!");

            if (target.getType().equals("King")) {
                winner = piece.getColor();
            }
        } else {
            System.out.println(piece.getColor() + " " + piece.getType()
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }
        return true;
    }
}
