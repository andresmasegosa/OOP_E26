package session1;

/**
 * Session 1, step C — loops: filling and printing the board.
 *
 * Writing board[row][col] = '.' sixty-four times would be madness.
 * A `for` loop repeats a block of code; two nested loops visit every
 * (row, col) square of the board.
 */
public class C_PrintingTheBoard {

    public static void main(String[] args) {
        char[][] board = new char[8][8];

        // Fill every square with '.' — for each row, for each column.
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = '.';
            }
        }

        // Place a few pieces.
        board[0][4] = 'k';
        board[7][4] = 'K';
        board[7][3] = 'Q';

        // Print the board, one row per line.
        // System.out.print (without "ln") stays on the same line;
        // System.out.println() with nothing prints just the line break.
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int row = 0; row < 8; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();   // end of this row: jump to the next line
        }
    }
}
