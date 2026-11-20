package session3.solution;

/**
 * Session 3, OFFICIAL SOLUTION, the entry point.
 *
 * The scripted game of the session's Demo, now with bishops and knights. The
 * cost lines students write at the top of main are shown filled in. The
 * Amazon of exercise 2 is tried on a board of her own, so that the game itself
 * is not disturbed.
 */
public class Demo {

    public static void main(String[] args) {
        // Cost of the bishop, session 1:
        //   places touched: 2   of which switches: 2   did anything warn me: no
        // Cost of the bishop, session 2:
        //   places touched: 1   of which switches: 1   did anything warn me: no
        // Cost of the bishop, session 3:
        //   places touched: 2   of which switches: 0   did anything warn me: yes, both times.
        //   The compiler forced the rule and the constructor, and refused new Bishop(...) in
        //   ChessGame.setupPieces until the class existed
        // Cost of the knight, session 3:
        //   places touched: 4 (class, Movements.isLegalKnightMove, setupPieces, and the
        //   legend in ChessBoard.print, which the compiler did not find)
        //   of which switches: 0   did anything warn me: yes, everywhere the compiler could:
        //   the rule, the letter, the constructor and the class name in setupPieces. Only
        //   the legend line went unmentioned

        // SOLUTION (exercise 2): the Amazon, on a board of her own.
        ChessBoard testBoard = new ChessBoard();
        Amazon amazon = new Amazon("White");
        testBoard.placePiece(4, 4, amazon);
        System.out.println("The " + amazon.getColor() + " " + amazon.getType() + " is drawn as " + amazon.getSymbol());
        System.out.println("Amazon from (4,4) to (2,5), a knight's jump: " + amazon.isLegalMove(testBoard, 2, 5));
        System.out.println("Amazon from (4,4) to (0,0), a queen's diagonal: " + amazon.isLegalMove(testBoard, 0, 0));
        System.out.println("Amazon from (4,4) to (1,2), neither: " + amazon.isLegalMove(testBoard, 1, 2));

        ChessGame game = new ChessGame();
        game.printBoard();

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(0, 4, 0, 3);   // Black king onto its own queen: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen
        game.movePiece(0, 4, 0, 3);   // and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // SOLUTION (exercise 1): the bishop moves.
        game.movePiece(7, 2, 5, 2);   // SOLUTION (exercise 1): and the bishop is refused a straight move.

        game.printBoard();

        game.play();
    }
}
