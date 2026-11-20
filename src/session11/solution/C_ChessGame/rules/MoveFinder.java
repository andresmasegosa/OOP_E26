package session11.solution.C_ChessGame.rules;

import session11.solution.C_ChessGame.ChessBoard;
import session11.solution.C_ChessGame.ChessPiece;
import session11.solution.C_ChessGame.players.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds the moves that the rules of one piece allow on a board.
 * MoveFinder.addSquare is given. It decides what happens with one square, and
 * returns whether a walk along a row, a column or a diagonal can go on past it.
 * Exercise 1. MoveFinder is a RuleVisitor, and each visit method finds the moves
 * of one kind of rule.
 */
public class MoveFinder implements RuleVisitor {                     // exercise 1

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

    @Override
    public void visitStraightLine(StraightLine rule) {                 // exercise 1
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : directions) {
            for (int step = 1; step <= rule.getMaxDistance(); step++) {
                if (!addSquare(piece.getRow() + step * d[0], piece.getCol() + step * d[1])) {
                    break;
                }
            }
        }
    }

    @Override
    public void visitDiagonal(Diagonal rule) {                         // exercise 1
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] d : directions) {
            for (int step = 1; step <= rule.getMaxDistance(); step++) {
                if (!addSquare(piece.getRow() + step * d[0], piece.getCol() + step * d[1])) {
                    break;
                }
            }
        }
    }

    @Override
    public void visitLeap(Leap rule) {                                 // exercise 1
        int a = rule.getRows();
        int b = rule.getCols();
        int[][] jumps = {{a, b}, {a, -b}, {-a, b}, {-a, -b}, {b, a}, {b, -a}, {-b, a}, {-b, -a}};
        for (int[] jump : jumps) {
            addSquare(piece.getRow() + jump[0], piece.getCol() + jump[1]);
        }
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
