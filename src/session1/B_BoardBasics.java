package session1;

/**
 * Session 1, step B — variables, chars, and the board as a 2D array.
 *
 * Our convention for the whole course:
 *   - The board is an 8x8 grid of characters (type char[][]).
 *   - Uppercase letters are White pieces: 'K' king, 'Q' queen, 'R' rook, 'B' bishop.
 *   - Lowercase letters are Black pieces: 'k', 'q', 'r', 'b'.
 *   - A dot '.' means the square is empty.
 *   - A square is named by two numbers (row, col), both from 0 to 7.
 *     Row 0 is the top of the board (Black's side), row 7 the bottom (White's side).
 */
public class B_BoardBasics {

    public static void main(String[] args) {
        // A variable has a type and holds a value of that type.
        int row = 0;                          // a whole number
        int col = 3;
        char piece = 'q';                     // a single character, in single quotes
        String description = "black queen";   // a text, in double quotes

        // Texts are glued together with +.
        System.out.println("We put a " + description + " ('" + piece + "') on square (" + row + "," + col + ")");

        // The board: 8 rows and 8 columns of chars.
        char[][] board = new char[8][8];

        // We write on a square with board[row][col] = ...
        board[0][3] = 'q';   // the black queen
        board[7][3] = 'Q';   // the white queen
        board[7][4] = 'K';   // the white king

        // ... and we read a square the same way.
        System.out.println("On square (7,3) there is: " + board[7][3]);

        // An if statement lets the program take decisions.
        char square = board[7][3];
        if (square == 'Q') {
            System.out.println("That is a queen!");
        } else {
            System.out.println("That is not a queen.");
        }

        // Uppercase means White and lowercase means Black,
        // so the case of the letter tells us the color of the piece.
        if (Character.isUpperCase(board[7][3])) {
            System.out.println("The piece on (7,3) belongs to White");
        } else {
            System.out.println("The piece on (7,3) belongs to Black");
        }
    }
}
