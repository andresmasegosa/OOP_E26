package session3.C_Overriding;

/**
 * Which isLegalMove runs? Before you run, write down what every line will
 * print, and for each call the class whose method runs.
 */
public class Demo {

    public static void main(String[] args) {
        // Three variables of type ChessPiece, holding objects of three classes.
        ChessPiece queen = new Queen("White", 7, 3);
        ChessPiece rook = new Rook("White", 7, 0);
        ChessPiece king = new King("White", 7, 4);

        // Every call compiles, because ChessPiece declares isLegalMove. Which
        // version runs is decided by the object, not by the variable.
        System.out.println("Queen from (7,3) to (4,6): " + queen.isLegalMove(4, 6));
        System.out.println("Rook from (7,0) to (4,0):  " + rook.isLegalMove(4, 0));
        System.out.println("King from (7,4) to (6,4):  " + king.isLegalMove(6, 4));

        // Step B's board, now able to ask its question.
        ChessPiece[][] squares = new ChessPiece[8][8];
        squares[7][0] = rook;
        squares[7][3] = queen;
        squares[7][4] = king;
        for (int col = 0; col < 8; col++) {
            ChessPiece piece = squares[7][col];
            if (piece != null) {
                System.out.println("The " + piece.getType() + " on (7," + col + ") may move one square up: "
                        + piece.isLegalMove(6, col));
            }
        }
        // The loop never asks what type a piece is. It asks the piece, and the
        // piece answers with its own rule. That is polymorphism.

        // One failure is left. ChessPiece is an ordinary class, so anyone can
        // still create one directly. This piece has no rule of its own and
        // gets the default.
        ChessPiece mystery = new ChessPiece("Bishop", "White");
        System.out.println("A plain ChessPiece called " + mystery.getType() + " may move to (5,3): "
                + mystery.isLegalMove(5, 3));
        // It compiles and it runs. Step D turns this line into a compile error.
    }
}
