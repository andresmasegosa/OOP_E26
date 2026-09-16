package session4.A_MoveRule;

import session4.A_MoveRule.rules.Diagonal;
import session4.A_MoveRule.rules.MoveRule;

/**
 * Step A. Three classes of piece, two classes of rule, and no Movements.
 *
 * Session 3 ended with a wish: a piece that moves like two pieces, without
 * copying code. Session 3's answer was to extend one of them and copy the
 * other, which is what the Amazon did. Here a piece holds a list of ways of
 * moving, and moving like two pieces is holding two rules.
 */
public class Demo {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        ChessPiece queen = new Queen("White");
        ChessPiece rook = new Rook("White");
        ChessPiece bishop = new Bishop("White");
        board.placePiece(7, 3, queen);
        board.placePiece(7, 0, rook);
        board.placePiece(7, 2, bishop);
        board.placePiece(5, 3, new Rook("Black"));   // in the queen's way
        board.print();

        System.out.println();
        System.out.println("The queen holds " + queen.countRules() + " rules, the rook "
                + rook.countRules() + " and the bishop " + bishop.countRules() + ".");
        System.out.println("Three classes of piece, two classes of rule. Open the three");
        System.out.println("classes: each one is a constructor that names the piece and");
        System.out.println("then adds its ways of moving, one line each.");

        System.out.println();
        System.out.println("Queen (7,3) to (4,3), through the black rook on (5,3): "
                + queen.isLegalMove(board, 4, 3));
        System.out.println("Queen (7,3) to (5,1), along a clear diagonal:          "
                + queen.isLegalMove(board, 5, 1));
        System.out.println("Rook  (7,0) to (5,0), along a clear column:            "
                + rook.isLegalMove(board, 5, 0));
        System.out.println("Rook  (7,0) to (5,2), along a diagonal it has no rule for: "
                + rook.isLegalMove(board, 5, 2));

        // A rule is an object, and it belongs to nobody. This one is not on
        // the board, not in a piece, and it answers anyway.
        MoveRule diagonal = new Diagonal(7);
        System.out.println();
        System.out.println("A Diagonal(7) asked on its own, (7,2) to (5,4): "
                + diagonal.allows(board, 7, 2, 5, 4));
        System.out.println("That is what changed. In sessions 1, 2 and 3 the geometry was three");
        System.out.println("static methods in a class called Movements, which no longer exists.");
        System.out.println("Here it is objects, and a piece holds the ones it may use.");

        // --- One line that does not compile ---------------------------------
        //
        // An interface has no constructor, because it has no code to run.
        // Uncomment and compile.
        //
        // MoveRule anyRule = new MoveRule();
        //
        // error: MoveRule is abstract; cannot be instantiated
        //
        // --- What is left for you ------------------------------------------
        //
        // There is no LShape in this folder, and no Knight. Exercise 2 is to
        // write the rule once and then count what a Chancellor, an
        // Archbishop and an Amazon cost. Before you start, write down your
        // guess: how many new classes, and how many lines in each.
    }
}
