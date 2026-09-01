package session2.D_Encapsulation;

/**
 * The sabotage of session 1, replayed twice: first against public fields
 * and a bare array, where it still works — then against the encapsulated
 * classes, where the COMPILER stops it before the program even runs.
 */
public class Demo {

    public static void main(String[] args) {
        // --- 1. The lie ---------------------------------------------------
        // Step C's piece still has public fields. Watch any code "move" a
        // queen without asking anyone. (Fully-qualified name again: this
        // folder has its own ChessPiece.)
        session2.C_Constructors.ChessPiece naive =
                new session2.C_Constructors.ChessPiece("Queen", "White", 7, 3);
        naive.col = 5;   // no rule ran, no path was checked. It just happened.
        System.out.println("The naive queen now claims: " + naive.describe());

        // --- 2. The sabotage, on a bare array ------------------------------
        // Session 1, exercise 4, with objects instead of chars. Same hole:
        ChessPiece[][] openBoard = new ChessPiece[8][8];
        openBoard[4][4] = new ChessPiece("Queen", "White");   // out of thin air
        System.out.println("Intruder on the open board: "
                + openBoard[4][4].describe());
        // Read that line again: the ARRAY says she stands on (4,4), the
        // PIECE says (-1,-1) — nobody kept the two in sync, because a bare
        // array cannot defend an invariant. Compare with placePiece below.

        // --- 3. The same attacks, against the encapsulated classes ---------
        ChessBoard board = new ChessBoard();
        ChessPiece queen = new ChessPiece("Queen", "White");
        System.out.println("placePiece(7,3): " + board.placePiece(7, 3, queen));
        System.out.println("The real queen:  " + queen.describe());

        // The direct write does not compile any more. Uncomment and read
        // the error — it is YOUR one-sentence answer from session 1,
        // exercise 4, enforced by the compiler:
        //
        // board.pieces[4][4] = new ChessPiece("Queen", "White");
        // error: pieces has private access in ChessBoard

        // Neither does teleporting the queen:
        //
        // queen.col = 5;
        // error: col has private access in ChessPiece

        // And the doors that DO exist can say no:
        ChessPiece intruder = new ChessPiece("Queen", "White");
        System.out.println("placePiece(7,3) again: " + board.placePiece(7, 3, intruder));
        System.out.println("placePiece(9,9):       " + board.placePiece(9, 9, intruder));
        System.out.println("The intruder is still " + intruder.describe());
    }
}
