package session3.A_OneClassPerPiece;

/**
 * One class per piece works as long as every piece is used on its own. Run
 * this demo first. Then read the two commented blocks at the end, where the
 * pieces have to share a board.
 */
public class Demo {

    public static void main(String[] args) {
        Queen queen = new Queen("White", 7, 3);
        Rook rook = new Rook("Black", 0, 0);

        // Each object answers with its own rule. There is no switch anywhere.
        System.out.println("Queen from (7,3) to (4,6): " + queen.isLegalMove(4, 6));
        System.out.println("Rook from (0,0) to (2,2):  " + rook.isLegalMove(2, 2));

        // Now both pieces go on one board. The board of session 2 is an 8x8
        // array, and an array has one element type. Try Queen. Uncomment the
        // three lines below and compile.
        //
        // Queen[][] squares = new Queen[8][8];
        // squares[7][3] = queen;
        // squares[0][0] = rook;
        //
        // error: incompatible types: Rook cannot be converted to Queen
        //
        // Put the comments back. Every class in Java is also an Object, even
        // when it does not say so (chapter 7, "The Object Class"), so an array
        // of Object accepts both pieces. Uncomment these three lines instead.
        //
        // Object[][] squares = new Object[8][8];
        // squares[7][3] = queen;
        // System.out.println(squares[7][3].isLegalMove(4, 6));
        //
        // error: cannot find symbol
        //
        // The square holds the queen, but the type of the square is Object,
        // and Object has no method isLegalMove. The board could store the
        // pieces and could not ask them anything. It needs a type that every
        // piece has and that declares isLegalMove. Step B builds it.
    }
}
