package session5.solution.C_ChessGame;

import session5.solution.C_ChessGame.players.GreedyPlayer;
import session5.solution.C_ChessGame.players.KeyboardPlayer;
import session5.solution.C_ChessGame.players.RandomPlayer;

/**
 * Compares the exercise costs, tries an Amazon on a board of her own, and
 * runs two games. Two RandomPlayers play the first; a KeyboardPlayer plays
 * against a GreedyPlayer in the second.
 */
public class Demo {

    public static void main(String[] args) {
        // --- EXERCISE 1, the cost line, under the three earlier ones -------
        //
        // Cost of the bishop, session 1:
        //   places touched: 2   of which switches: 2   did anything warn me: no
        // Cost of the bishop, session 2:
        //   places touched: 1   of which switches: 1   did anything warn me: no
        // Cost of the bishop, session 3:
        //   places touched: 2   of which switches: 0   did anything warn me: yes, both times.
        //   The compiler forced the rule and the constructor, and refused new Bishop(...) in
        //   ChessGame.setupPieces until the class existed
        // Cost of the Amazon, session 5:
        //   places touched: 1   lines in the new class: 16
        //   the same piece in session 3: 15 lines, a subclass of Queen,
        //   super.isLegalMove for half of it, and the knight's L borrowed from
        //   a class it does not extend

        // --- EXERCISE 1, the Amazon on a board of her own ------------------
        ChessBoard empty = new ChessBoard();
        ChessPiece amazon = new Amazon("White");
        empty.placePiece(4, 4, amazon);
        System.out.println("The Amazon holds " + amazon.countRules() + " rules.");
        System.out.println("  like a rook,   (4,4) to (4,7): " + amazon.isLegalMove(empty, 4, 7));
        System.out.println("  like a bishop, (4,4) to (1,1): " + amazon.isLegalMove(empty, 1, 1));
        System.out.println("  like a knight, (4,4) to (2,3): " + amazon.isLegalMove(empty, 2, 3));
        System.out.println("  and not (4,4) to (1,2), which is none of the three: "
                + amazon.isLegalMove(empty, 1, 2));

        // --- Two machines ---------------------------------------------------
        // A different game every run, and it ends by itself when a king is
        // captured. Two players this bad can take a long time to find a king,
        // so it may run for a hundred moves or more; scroll, or stop it and
        // run it again. No move is refused. A RandomPlayer only proposes what
        // its pieces allow, and ChessPiece.isLegalMove never allows a piece to
        // end on one of its own.

        System.out.println("Two RandomPlayers. Nobody is at the keyboard.");
        System.out.println("This can run for a while: neither of them is trying to win.");
        ChessGame machines = new ChessGame(new RandomPlayer(), new RandomPlayer());
        machines.play();

        System.out.println();
        System.out.println("The square (0,4) now holds: " + describe(machines.getBoard(), 0, 4));

        // --- EXERCISE 2: a game against GreedyPlayer --------------------------
        // Player arguments choose who makes each side's moves.

        System.out.println();
        System.out.println("Your turn! You are White, GreedyPlayer is Black, and White moves first.");
        ChessGame game = new ChessGame(new KeyboardPlayer(), new GreedyPlayer());
        game.play();
    }

    /** Says what stands on a square, or that it is empty. */
    private static String describe(ChessBoard board, int row, int col) {
        ChessPiece piece = board.getPieceAt(row, col);
        if (piece == null) {
            return "nothing";
        }
        return "a " + piece.getColor() + " " + piece.getType();
    }
}
