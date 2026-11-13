package session10.C_ChessGame;

import session10.C_ChessGame.players.Move;
import session10.C_ChessGame.players.Player;

import java.util.ArrayList;
import java.util.List;

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
    private Color winner;                 // null while the game is running
    private List<ChessPiece> captured = new ArrayList<>();

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
        board.placePiece(0, 0, new Rook(Color.BLACK));
        board.placePiece(0, 1, new Knight(Color.BLACK));
        board.placePiece(0, 2, new Bishop(Color.BLACK));
        board.placePiece(0, 3, new Queen(Color.BLACK));
        board.placePiece(0, 4, new King(Color.BLACK));
        board.placePiece(0, 5, new Bishop(Color.BLACK));
        board.placePiece(0, 6, new Knight(Color.BLACK));
        board.placePiece(0, 7, new Rook(Color.BLACK));

        // White pieces, bottom of the board.
        board.placePiece(7, 0, new Rook(Color.WHITE));
        board.placePiece(7, 1, new Knight(Color.WHITE));
        board.placePiece(7, 2, new Bishop(Color.WHITE));
        board.placePiece(7, 3, new Queen(Color.WHITE));
        board.placePiece(7, 4, new King(Color.WHITE));
        board.placePiece(7, 5, new Bishop(Color.WHITE));
        board.placePiece(7, 6, new Knight(Color.WHITE));
        board.placePiece(7, 7, new Rook(Color.WHITE));
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

            Color color;
            Player current;
            if (whiteToMove) {
                color = Color.WHITE;
                current = white;
            } else {
                color = Color.BLACK;
                current = black;
            }

            Move move = current.chooseMove(board, color);

            if (move == null) {          // KeyboardPlayer after q, or a player that finds no move
                System.out.println();
                System.out.println("Thanks for playing!");
                System.out.println("Captured: " + captured);
                return;
            }

            positionChanged = takeTurn(move);

            if (winner != null) {
                printBoard();
                System.out.println();
                System.out.println(winner + " wins: the other king is off the board.");
                System.out.println("Captured: " + captured);
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

        try {
            board.movePiece(piece, toRow, toCol);
        } catch (IllegalMoveException e) {
            System.out.println("Illegal move: " + e.getMessage());
            return false;
        }

        if (target != null) {
            captured.add(target);
            System.out.println(piece.getColor() + " " + piece.getType() + " captures "
                    + target.getColor() + " " + target.getType() + " on (" + toRow + "," + toCol + ")!");

            if (target.getType() == PieceType.KING) {
                winner = piece.getColor();
            }
        } else {
            System.out.println(piece.getColor() + " " + piece.getType()
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }
        return true;
    }
}
