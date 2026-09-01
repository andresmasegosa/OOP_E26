package session2.C_Constructors;

/**
 * Why constructors exist, and what overloading buys us.
 */
public class Demo {

    public static void main(String[] args) {
        // --- The accident constructors prevent --------------------------
        // Step A's ChessPiece declares no constructor, so Java gives it an
        // empty one for free — and nothing forces you to fill the fields
        // in. This is a HALF-piece: we forgot type and color.
        session2.A_ClassesAndObjects.ChessPiece halfPiece =
                new session2.A_ClassesAndObjects.ChessPiece();
        halfPiece.row = 7;
        halfPiece.col = 3;
        System.out.println("The half-piece: " + halfPiece.describe());

        // (That long class name is a FULLY-QUALIFIED name: package plus
        // class. We need it here because this folder has a ChessPiece of
        // its own — two classes may share a name as long as they live in
        // different packages, and the package name tells them apart.)

        // --- Born whole --------------------------------------------------
        // THIS folder's ChessPiece declares constructors, so the accident
        // above does not even compile any more. Try it — uncomment:
        //
        // ChessPiece empty = new ChessPiece();
        //
        // error: no suitable constructor found for ChessPiece(no arguments)
        //
        // The moment a class declares a constructor, the free empty one
        // disappears.

        ChessPiece queen = new ChessPiece("Queen", "White", 7, 3);
        System.out.println("Born whole:     " + queen.describe());

        // --- Overloading: two ways in, one whole object either way -------
        ChessPiece alsoAQueen = new ChessPiece('q', 0, 3);   // session 1's letters still work
        ChessPiece rook = new ChessPiece('R', 7, 0);
        System.out.println("From a letter:  " + alsoAQueen.describe());
        System.out.println("From a letter:  " + rook.describe());
    }
}
