package session3.C_AbstractClasses;

/**
 * Step B's demo, run against the abstract ChessPiece. The lines that matter
 * most are the ones that no longer compile.
 */
public class Demo {

    public static void main(String[] args) {
        ChessPiece queen = new Queen("White", 7, 3);
        ChessPiece rook = new Rook("White", 7, 0);
        ChessPiece king = new King("White", 7, 4);

        System.out.println("Queen from (7,3) to (4,6): " + queen.isLegalMove(4, 6));
        System.out.println("Rook from (7,0) to (4,0):  " + rook.isLegalMove(4, 0));
        System.out.println("King from (7,4) to (6,4):  " + king.isLegalMove(6, 4));

        // Step B's board, asked the same question. The array
        // still has type ChessPiece, and every object in it is something
        // more specific.
        ChessPiece[][] squares = new ChessPiece[8][8];
        squares[7][0] = rook;
        squares[7][3] = queen;
        squares[7][4] = king;
        for (int col = 0; col < 8; col++) {
            ChessPiece piece = squares[7][col];
            if (piece != null) {
                System.out.println("The " + piece.getType() + " on (7," + col + "): up 3? "
                        + piece.isLegalMove(4, col)
                        + "   diagonal 1? " + piece.isLegalMove(6, col + 1));
            }
        }

        // Step B ended with a piece nobody had taught. Uncomment and compile.
        //
        // ChessPiece mystery = new ChessPiece("Bishop", "White");
        //
        // error: ChessPiece is abstract; cannot be instantiated
        //
        // A variable can still have the type ChessPiece, as queen, rook and
        // king do above. What cannot exist any more is an object that is a
        // ChessPiece and nothing more specific.

        // The second compile error is in Bishop.java, next to this file.
    }
}
