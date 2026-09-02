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
 *   - the game itself is an object too. In session 1 every method took the
 *     board as a parameter and "whose turn is it" lived in a local
 *     variable of play(). Here both are FIELDS: a ChessGame HAS a board and
 *     knows whose turn it is. Compare the method signatures with session
 *     1's — the board parameter is gone from every one of them, because
 *     'this' game already has one.
 *
 * STATIC OR NOT? Read the modifiers in this file and in Movements.java.
 *   - main is static: it runs before any ChessGame exists, and its job is
 *     to create one. A static method belongs to the class, not to an
 *     object, so it has no 'this' and no fields to work on.
 *   - Every other method here is an instance method: it works on THIS
 *     game's board and THIS game's turn.
 *   - Movements is all static, and ChessPiece.typeFromLetter is static:
 *     pure computations that need no object — geometry, a translation.
 *   The rule: static when there is no object the code belongs to;
 *   instance when the code is about one object's state.
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

    private ChessBoard board;             // the game HAS a board: no longer a parameter
    private boolean whiteToMove = true;   // whose turn: no longer a local variable of play()

    /**
     * A game is born whole: with its board and all twelve pieces on it. A
     * ChessGame without a board makes no sense, so the constructor does not
     * let one exist.
     */
    public ChessGame() {
        this.board = new ChessBoard();
        setupPieces();
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.printBoard();

        // --- The same short scripted game as session 1 -------------------
        // Coordinates are (row, col): see the numbers around the board.
        // Session 1 wrote movePiece(board, 7, 3, 4, 3). The board is gone
        // from the call: it is the game's own.

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(7, 0, 7, 2);   // White rook onto its own bishop: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen!
        game.movePiece(0, 4, 0, 3);   // ...and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // White bishop: still nobody taught it. Exercise 1!

        game.printBoard();

        // --- EXERCISE 3: the sabotage, revisited --------------------------
        // Session 1's saboteur wrote straight onto the array:
        //
        //     board[4][4] = 'Q';
        //
        // Try the equivalent now — uncomment and compile:
        //
        // game.getBoard().pieces[4][4] = new ChessPiece(game.getBoard(), 'Q', 4, 4);
        //
        // It does not compile: "pieces has private access in ChessBoard".
        // That is your one-sentence answer from session 1, exercise 4,
        // enforced by the compiler. Whether EVERY door is as well guarded
        // is another question — EXERCISES.md, exercise 3.

        game.play();
    }

    /**
     * The board this game is played on. Reading it is harmless — and yet
     * this door hands out the board itself, with its own doors attached.
     * Exercise 3 asks what that lets an outsider do.
     */
    public ChessBoard getBoard() {
        return board;
    }

    /** The initial position — the same twelve pieces as session 1. */
    private void setupPieces() {
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
    public void printBoard() {
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
     * method just talks. (It does not check whose turn it is — play()
     * does. The scripted game in main moves both sides freely.)
     */
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
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
     * square" is an object, asking whether it is White means asking the
     * piece itself, and whose turn it is is a field of this game.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Your turn! White plays the UPPERCASE pieces and moves first.");
        System.out.println("A move is four numbers separated by spaces: fromRow fromCol toRow toCol");
        System.out.println("For example, typing  7 0 5 0  tries to move the piece on (7,0) to (5,0).");
        System.out.println("Type -1 to quit.");

        while (true) {
            printBoard();
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
            } else if (movePiece(fromRow, fromCol, toRow, toCol)) {
                whiteToMove = !whiteToMove;   // the move was made: other player's turn
            }
        }
    }
}
