package session3.B_Inheritance;

/**
 * What a subclass gets from its superclass, and which version runs when you
 * ask for it.
 *
 * Before you run this, write down two things: the order in which the
 * constructor lines will appear, and, for every call to isLegalMove, the class
 * whose method you expect to run.
 */
public class Demo {

    public static void main(String[] args) {
        // --- 1. The constructors, superclass first ------------------------
        System.out.println("new Queen(\"White\", 7, 3)");
        Queen queen = new Queen("White", 7, 3);
        System.out.println("new Rook(\"White\", 7, 0)");
        Rook rook = new Rook("White", 7, 0);
        System.out.println("new King(\"White\", 7, 4)");
        King king = new King("White", 7, 4);

        // --- 2. What a subclass inherits: the code ------------------------
        // Queen declares no getColor and no getRow. She inherits them.
        System.out.println("The queen is " + queen.getColor() + " and stands on row " + queen.getRow());

        // --- 3. What a subclass inherits: the type ------------------------
        // A Queen is a ChessPiece, and so are a Rook and a King, so one array
        // of ChessPiece holds all three. Step A could not do this.
        ChessPiece[][] squares = new ChessPiece[8][8];
        squares[7][0] = rook;
        squares[7][3] = queen;
        squares[7][4] = king;
        System.out.println("On (7,0) stands a " + squares[7][0].getColor() + " " + squares[7][0].getType());

        // Step A could not do this either: ChessPiece declares isLegalMove, so
        // the board may ask any square, and the answer comes from the object.
        for (int col = 0; col < 8; col++) {
            ChessPiece piece = squares[7][col];
            if (piece != null) {
                System.out.println("The " + piece.getType() + " on (7," + col + "): up 3? "
                        + piece.isLegalMove(4, col)
                        + "   diagonal 1? " + piece.isLegalMove(6, col + 1));
            }
        }
        // The loop asks a piece its type only to print it. It never asks the
        // type in order to DECIDE: it asks the piece, and the piece answers with
        // its own rule. Java picks the version while the program runs, by
        // looking at the object. That is polymorphism.

        // --- 4. What is still broken --------------------------------------
        // ChessPiece is an ordinary class, so anyone can still create one
        // directly. This piece has no rule of its own and gets the default.
        ChessPiece mystery = new ChessPiece("Bishop", "White");
        System.out.println("A plain ChessPiece called " + mystery.getType() + " may move to (5,3): "
                + mystery.isLegalMove(5, 3));
        // It compiles and it runs. Step C turns this line into a compile error.

        // A subclass does not inherit constructors. ChessPiece has a
        // constructor that takes a type and a color, and that does not give
        // Queen one. Uncomment and compile.
        //
        // Queen shortQueen = new Queen("Queen", "White");
        //
        // error: constructor Queen in class Queen cannot be applied to given types;
    }
}
