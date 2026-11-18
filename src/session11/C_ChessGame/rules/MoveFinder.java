package session11.C_ChessGame.rules;

import session11.C_ChessGame.ChessBoard;
import session11.C_ChessGame.ChessPiece;
import session11.C_ChessGame.players.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds the moves that the rules of one piece allow on a board. In exercise 1
 * it becomes a visitor of the rules, with one visit method for each kind of
 * rule. MoveFinder.addSquare is written for you. It decides what happens with
 * one square, and returns whether a walk along a row, a column or a diagonal
 * can go on past it.
 */
public class MoveFinder {

    private ChessBoard board;
    private ChessPiece piece;
    private List<Move> moves = new ArrayList<>();

    public MoveFinder(ChessBoard board, ChessPiece piece) {
        this.board = board;
        this.piece = piece;
    }

    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Keeps the move to (row, col) when that square is on the board and is empty
     * or has an enemy piece on it. Returns true when the square was empty, so that
     * a walk along a line can go on past it, and false when the walk has to stop
     * there, at the edge of the board or at a piece.
     */
    private boolean addSquare(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            return false;                       // off the board: stop
        }
        ChessPiece target = board.getPieceAt(row, col);
        if (target == null) {
            moves.add(new Move(piece.getRow(), piece.getCol(), row, col));
            return true;                        // empty: keep it, and go on
        }
        if (target.getColor() != piece.getColor()) {
            moves.add(new Move(piece.getRow(), piece.getCol(), row, col));
        }
        return false;                           // a piece: stop here
    }
}
