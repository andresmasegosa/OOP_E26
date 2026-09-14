package session3.B_Inheritance;

/**
 * What a subclass gets from its superclass. Before you run, write down the
 * order in which the constructor lines will appear.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("new Queen(\"White\", 7, 3)");
        Queen queen = new Queen("White", 7, 3);
        System.out.println("new Rook(\"Black\", 0, 0)");
        Rook rook = new Rook("Black", 0, 0);

        // Queen declares no getColor and no getRow. She inherits them.
        System.out.println("The queen is " + queen.getColor() + " and stands on row " + queen.getRow());
        System.out.println("Queen from (7,3) to (4,6): " + queen.isLegalMove(4, 6));

        // The type half. A Queen is a ChessPiece and so is a Rook, so one
        // array of ChessPiece holds both. Step A's first error is gone.
        ChessPiece[][] squares = new ChessPiece[8][8];
        squares[7][3] = queen;
        squares[0][0] = rook;
        System.out.println("On (0,0) stands a " + squares[0][0].getColor() + " piece");

        // Now ask a square the question the board needs to ask. Uncomment and
        // compile.
        //
        // System.out.println(squares[7][3].isLegalMove(4, 6));
        //
        // error: cannot find symbol
        //
        // The object on (7,3) is a Queen, and a Queen has isLegalMove. But the
        // compiler only knows that squares[7][3] is a ChessPiece, and
        // ChessPiece declares no isLegalMove, so it refuses. Step C puts
        // isLegalMove into ChessPiece.

        // A subclass does not inherit constructors. ChessPiece has a
        // constructor that takes a color, and that does not give Queen one.
        // Uncomment and compile.
        //
        // Queen shortQueen = new Queen("White");
        //
        // error: constructor Queen in class Queen cannot be applied to given types;
    }
}
