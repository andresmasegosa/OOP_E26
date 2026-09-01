package session2.E_ChessGame;

import java.util.Scanner;   // our first import: Scanner lives in the package java.util

/**
 * Session 2 — the same chess game as session 1, rebuilt on classes.
 *
 * Same board, same rules, same missing bishops. Play it: it behaves
 * exactly like session 1's E_ChessGame, to the letter. What changed is
 * everything you cannot see from the outside:
 *   - a piece is an OBJECT that carries its own type, color and square;
 *   - the board's array is PRIVATE, and the only door through which a
 *     piece changes square is ChessBoard.movePiece — session 1's sabotage
 *     no longer compiles;
 *   - this class holds no chess knowledge at all: it prints, it reads
 *     your keyboard, and it asks the board and the pieces for everything
 *     else.
 *
 * THE RULES (mini-chess, unchanged)
 *   Only kings, queens, rooks and bishops. No pawns, no knights, no check,
 *   no castling. You capture by moving onto an enemy piece.
 *
 *   ...and yes: THE BISHOPS STILL DO NOT MOVE. Teaching them is exercise 1
 *   — for the second time. That is on purpose: same change, new design,
 *   measure the difference. See EXERCISES.md.
 */
public class ChessGame {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        setupBoard(board);
        printBoard(board);

        // --- The same short scripted game as session 1 -------------------
        // Coordinates are (row, col): see the numbers around the board.

        movePiece(board, 7, 3, 4, 3);   // White queen straight up: legal
        movePiece(board, 0, 0, 2, 2);   // Black rook diagonally: illegal
        movePiece(board, 7, 0, 7, 2);   // White rook onto its own bishop: illegal
        movePiece(board, 4, 3, 0, 3);   // The white queen captures the black queen!
        movePiece(board, 0, 4, 0, 3);   // ...and the black king takes revenge.
        movePiece(board, 7, 5, 5, 3);   // White bishop: still nobody taught it. Exercise 1!

        printBoard(board);

        // --- EXERCISE 3: the sabotage, revisited --------------------------
        // Session 1's saboteur wrote straight onto the array:
        //
        //     board[4][4] = 'Q';
        //
        // Try the equivalent now — uncomment and compile:
        //
        // board.pieces[4][4] = new ChessPiece(board, 'Q', 4, 4);
        //
        // It does not compile: "pieces has private access in ChessBoard".
        // That is your one-sentence answer from session 1, exercise 4,
        // enforced by the compiler. Whether EVERY door is as well guarded
        // is another question — EXERCISES.md, exercise 3.

        play(board);
    }

    /** The initial position — the same twelve pieces as session 1. */
    static void setupBoard(ChessBoard board) {
        // Each 'new' creates a piece AND registers it on the board (the
        // constructor does that). We do not even keep the variables: the
        // board holds a reference to every piece, and that keeps them
        // alive. Exercise 2 will want some of these back — you will have
        // to hold on to them.

        // Black pieces (lowercase), top of the board.
        new ChessPiece(board, 'r', 0, 0);
        new ChessPiece(board, 'b', 0, 2);
        new ChessPiece(board, 'q', 0, 3);
        new ChessPiece(board, 'k', 0, 4);
        new ChessPiece(board, 'b', 0, 5);
        new ChessPiece(board, 'r', 0, 7);

        // White pieces (uppercase), bottom of the board.
        new ChessPiece(board, 'R', 7, 0);
        new ChessPiece(board, 'B', 7, 2);
        new ChessPiece(board, 'Q', 7, 3);
        new ChessPiece(board, 'K', 7, 4);
        new ChessPiece(board, 'B', 7, 5);
        new ChessPiece(board, 'R', 7, 7);
    }

    /** Prints the board — the same picture as session 1, to the character. */
    static void printBoard(ChessBoard board) {
        System.out.println();
        System.out.println("        0 1 2 3 4 5 6 7   <- col");
        System.out.println("      +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print("row " + row + " | ");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = board.getPieceAt(row, col);
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
        System.out.println("      K king, Q queen, R rook, B bishop, . empty square");
    }

    /**
     * Tries a move given as squares, session 1 style, and narrates what
     * happened in session 1's exact words. Notice how little this method
     * knows: the board decides, the pieces know their rules, and this
     * method just talks.
     */
    static boolean movePiece(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece piece = null;
        if (fromRow >= 0 && fromRow <= 7 && fromCol >= 0 && fromCol <= 7) {
            piece = board.getPieceAt(fromRow, fromCol);
        }

        // Look at the target BEFORE moving: if an enemy stands there, this
        // move is a capture, and we want to name the victim.
        ChessPiece target = null;
        if (toRow >= 0 && toRow <= 7 && toCol >= 0 && toCol <= 7) {
            target = board.getPieceAt(toRow, toCol);
        }

        if (!board.movePiece(piece, toRow, toCol)) {
            System.out.println("Illegal move: (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol
                    + "): not how that piece moves, the path is blocked, or the target is your own piece");
            return false;
        }

        if (target != null) {
            System.out.println(piece.getColor() + " " + piece.getType() + " captures "
                    + target.getColor() + " " + target.getType() + " on (" + toRow + "," + toCol + ")!");
        } else {
            System.out.println(piece.getColor() + " " + piece.getType()
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }
        return true;
    }

    /**
     * Play from the keyboard — session 1's loop, almost line for line.
     * The differences are in what the words mean now: "the piece on a
     * square" is an object, and asking whether it is White means asking
     * the piece itself.
     */
    static void play(ChessBoard board) {
        Scanner scanner = new Scanner(System.in);
        boolean whiteToMove = true;

        System.out.println();
        System.out.println("Your turn! White plays the UPPERCASE pieces and moves first.");
        System.out.println("A move is four numbers separated by spaces: fromRow fromCol toRow toCol");
        System.out.println("For example, typing  7 0 5 0  tries to move the piece on (7,0) to (5,0).");
        System.out.println("Type -1 to quit.");

        while (true) {
            printBoard(board);
            if (whiteToMove) {
                System.out.print("White > ");
            } else {
                System.out.print("Black > ");
            }

            int fromRow = scanner.nextInt();
            if (fromRow == -1) {
                System.out.println("Thanks for playing!");
                return;
            }
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7
                    || board.getPieceAt(fromRow, fromCol) == null) {
                System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
            } else if (board.getPieceAt(fromRow, fromCol).isWhite() != whiteToMove) {
                System.out.println("That piece is not yours!");
            } else if (movePiece(board, fromRow, fromCol, toRow, toCol)) {
                whiteToMove = !whiteToMove;   // the move was made: other player's turn
            }
        }
    }
}
