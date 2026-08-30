package session1; // Packages are explained in Session 2. For now, just leave this line as it is.

import java.util.Scanner;

/**
 * Session 1 — a working chess game with NO object-oriented programming at all.
 *
 * Everything in this file is built from the basics: variables, chars, a 2D
 * array, if/else, switch, loops and static methods. And it works: you can
 * run this file and play.
 *
 * THE BOARD
 *   An 8x8 grid of chars. A square holds a piece letter, or '.' if empty.
 *   Uppercase = White ('K' king, 'Q' queen, 'R' rook, 'B' bishop).
 *   Lowercase = Black ('k', 'q', 'r', 'b').
 *   A square is (row, col), both from 0 to 7. Row 0 is the top (Black's side).
 *
 * THE RULES (mini-chess)
 *   Only kings, queens, rooks and bishops. No pawns, no knights, no check,
 *   no castling. You capture by moving onto an enemy piece.
 *
 *   ...and, as you may discover while playing: THE BISHOPS DO NOT MOVE.
 *   Nobody has taught this program how a bishop moves yet.
 *   That is your job — see EXERCISES.md, Exercise 1.
 *
 * As you read, keep one question in mind: this program clearly works...
 * but what will it FEEL like to grow it? We will answer that during the
 * course, by growing it.
 */
public class E_ChessGame {

    public static void main(String[] args) {
        char[][] board = setupBoard();
        printBoard(board);

        // --- A short scripted game --------------------------------------
        // Coordinates are (row, col): see the numbers around the board.

        movePiece(board, 7, 3, 4, 3);   // White queen straight up: legal
        movePiece(board, 0, 0, 2, 2);   // Black rook diagonally: illegal
        movePiece(board, 7, 0, 7, 2);   // White rook onto its own bishop: illegal
        movePiece(board, 4, 3, 0, 3);   // The white queen captures the black queen!
        movePiece(board, 0, 4, 0, 3);   // ...and the black king takes revenge.
        movePiece(board, 7, 5, 5, 3);   // White bishop: should be legal... but see EXERCISES.md

        printBoard(board);

        // --- EXERCISE 4: the sabotage -----------------------------------
        // Uncomment the two lines below and run again. A second white queen
        // appears out of thin air in the middle of the board. No rule stopped
        // us: the board is just an array, and ANY code can write ANY square.
        //
        // board[4][4] = 'Q';
        // printBoard(board);

        play(board);
    }

    /** Creates the initial position of our mini-chess (no pawns, no knights). */
    static char[][] setupBoard() {
        char[][] board = new char[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = '.';
            }
        }

        // Black pieces (lowercase), top of the board.
        board[0][0] = 'r';
        board[0][2] = 'b';
        board[0][3] = 'q';
        board[0][4] = 'k';
        board[0][5] = 'b';
        board[0][7] = 'r';

        // White pieces (uppercase), bottom of the board.
        board[7][0] = 'R';
        board[7][2] = 'B';
        board[7][3] = 'Q';
        board[7][4] = 'K';
        board[7][5] = 'B';
        board[7][7] = 'R';

        return board;
    }

    /** Prints the board, with row/column labels and a small legend. */
    static void printBoard(char[][] board) {
        System.out.println();
        System.out.println("        0 1 2 3 4 5 6 7   <- col");
        System.out.println("      +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print("row " + row + " | ");
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("      +-----------------+");
        System.out.println("      UPPERCASE = White, lowercase = black");
        System.out.println("      K king, Q queen, R rook, B bishop, . empty square");
    }

    /** Is this piece White? (White pieces are the uppercase letters.) */
    static boolean isWhite(char piece) {
        return Character.isUpperCase(piece);
    }

    /** Do these two pieces belong to the same player? */
    static boolean sameColor(char pieceA, char pieceB) {
        return isWhite(pieceA) == isWhite(pieceB);
    }

    /** "White" or "Black", for printing nice messages. */
    static String colorName(char piece) {
        if (isWhite(piece)) {
            return "White";
        } else {
            return "Black";
        }
    }

    /**
     * The name of a piece, for printing nice messages.
     * The type of a piece is its letter, ignoring the color.
     */
    static String pieceName(char piece) {
        switch (Character.toUpperCase(piece)) {
            case 'K':
                return "King";
            case 'Q':
                return "Queen";
            case 'R':
                return "Rook";
            default:
                return "?";
        }
    }

    /**
     * The heart of the game: may the piece on (fromRow, fromCol) move to
     * (toRow, toCol)? Each kind of piece has its own rule, so we switch on
     * the piece type. The isLegal...Move methods below also check that no
     * other piece is standing in the way.
     */
    static boolean isLegalMove(char[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        // Both squares must exist on the board.
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7
                || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;
        }

        // There must be a piece to move.
        char piece = board[fromRow][fromCol];
        if (piece == '.') {
            return false;
        }

        // You may capture an enemy piece, but never one of your own.
        char target = board[toRow][toCol];
        if (target != '.' && sameColor(piece, target)) {
            return false;
        }

        // Each kind of piece moves its own way.
        switch (Character.toUpperCase(piece)) {
            case 'K':
                return isLegalHorizontalMove(board, fromRow, fromCol, toRow, toCol, 1)
                        || isLegalVerticalMove(board, fromRow, fromCol, toRow, toCol, 1)
                        || isLegalDiagonalMove(board, fromRow, fromCol, toRow, toCol, 1);
            case 'Q':
                return isLegalHorizontalMove(board, fromRow, fromCol, toRow, toCol, 7)
                        || isLegalVerticalMove(board, fromRow, fromCol, toRow, toCol, 7)
                        || isLegalDiagonalMove(board, fromRow, fromCol, toRow, toCol, 7);
            case 'R':
                return isLegalHorizontalMove(board, fromRow, fromCol, toRow, toCol, 7)
                        || isLegalVerticalMove(board, fromRow, fromCol, toRow, toCol, 7);
            default:
                // A piece nobody taught this program to move. (Bishops... Exercise 1!)
                return false;
        }
    }

    /**
     * Horizontal move: same row, the column changes by at most maxDistance,
     * and every square strictly BETWEEN the two must be empty.
     * (The target square itself may hold an enemy piece: that is a capture.)
     */
    static boolean isLegalHorizontalMove(char[][] board, int fromRow, int fromCol,
                                         int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        // Not horizontal, not moving at all, or moving too far.
        if (rowDistance != 0 || colDistance == 0 || colDistance > maxDistance) {
            return false;
        }

        // Walk the squares between the two columns: all must be empty.
        int col = Math.min(fromCol, toCol) + 1;
        int lastCol = Math.max(fromCol, toCol);
        while (col < lastCol) {
            if (board[fromRow][col] != '.') {
                return false;   // another piece is in the way
            }
            col++;
        }
        return true;
    }

    /** Vertical move: same column, the row changes. Same idea as horizontal. */
    static boolean isLegalVerticalMove(char[][] board, int fromRow, int fromCol,
                                       int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (colDistance != 0 || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        int row = Math.min(fromRow, toRow) + 1;
        int lastRow = Math.max(fromRow, toRow);
        while (row < lastRow) {
            if (board[row][fromCol] != '.') {
                return false;
            }
            row++;
        }
        return true;
    }

    /**
     * Diagonal move: row and column change by the same amount. To walk the
     * path we step one square at a time in the right direction, which is
     * +1 or -1 on each axis.
     */
    static boolean isLegalDiagonalMove(char[][] board, int fromRow, int fromCol,
                                       int toRow, int toCol, int maxDistance) {
        int rowDistance = Math.abs(toRow - fromRow);
        int colDistance = Math.abs(toCol - fromCol);

        if (rowDistance != colDistance || rowDistance == 0 || rowDistance > maxDistance) {
            return false;
        }

        int rowStep;   // +1 going down, -1 going up
        if (toRow > fromRow) {
            rowStep = 1;
        } else {
            rowStep = -1;
        }

        int colStep;   // +1 going right, -1 going left
        if (toCol > fromCol) {
            colStep = 1;
        } else {
            colStep = -1;
        }

        // Walk the squares strictly between the two ends: all must be empty.
        int row = fromRow + rowStep;
        int col = fromCol + colStep;
        while (row != toRow) {
            if (board[row][col] != '.') {
                return false;
            }
            row = row + rowStep;
            col = col + colStep;
        }
        return true;
    }

    /**
     * Tries to make a move. If it is legal, the board is updated (and an
     * enemy piece on the target square is captured). Prints what happened
     * and returns whether the move was made.
     */
    static boolean movePiece(char[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        if (!isLegalMove(board, fromRow, fromCol, toRow, toCol)) {
            System.out.println("Illegal move: (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol
                    + "): not how that piece moves, the path is blocked, or the target is your own piece");
            return false;
        }

        char piece = board[fromRow][fromCol];
        char target = board[toRow][toCol];
        if (target != '.') {
            System.out.println(colorName(piece) + " " + pieceName(piece) + " captures "
                    + colorName(target) + " " + pieceName(target) + " on (" + toRow + "," + toCol + ")!");
        } else {
            System.out.println(colorName(piece) + " " + pieceName(piece)
                    + " moves (" + fromRow + "," + fromCol + ") -> (" + toRow + "," + toCol + ")");
        }

        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = '.';
        return true;
    }

    /**
     * Play from the keyboard. White and Black take turns; a move is four
     * numbers separated by spaces: fromRow fromCol toRow toCol
     * (for example: 7 3 4 3). Enter -1 to quit.
     */
    static void play(char[][] board) {
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
                    || board[fromRow][fromCol] == '.') {
                System.out.println("There is no piece on (" + fromRow + "," + fromCol + ")");
            } else if (isWhite(board[fromRow][fromCol]) != whiteToMove) {
                System.out.println("That piece is not yours!");
            } else if (movePiece(board, fromRow, fromCol, toRow, toCol)) {
                whiteToMove = !whiteToMove;   // the move was made: other player's turn
            }
        }
    }
}
