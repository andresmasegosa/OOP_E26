package session2.E_ChessGame;

/**
 * Starts a game. This class is main and nothing else — the same shape as
 * the Demo in every other folder of this session: a static entry point
 * whose only job is to create objects and set them going.
 *
 * STATIC OR NOT? Three classes, three answers:
 *   - ChessGame has no static method at all. Everything a game does is
 *     about ONE game — its board, its turn — so every method in it is an
 *     instance method.
 *   - This main is static: it runs before any ChessGame exists, and its
 *     job is to create the first one. A static method belongs to the
 *     class, not to an object, so it has no 'this' and no fields.
 *   - Movements is all static: pure geometry over a board it is handed,
 *     no state of its own. Same for ChessPiece.typeFromLetter.
 *   The rule: static when there is no object the code belongs to;
 *   instance when the code is about one object's state.
 */
public class Demo {

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.printBoard();

        // --- The same short scripted game as session 1 -------------------
        // Coordinates are (row, col): see the numbers around the board.
        // Session 1 wrote movePiece(board, 7, 3, 4, 3). The board is gone
        // from the call: it is the game's own.

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(7, 0, 7, 2);   // White rook onto its own bishop: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen!
        game.movePiece(0, 4, 0, 3);   // ...and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // White bishop: still nobody taught it. Exercise 1!

        game.printBoard();

        // --- EXERCISE 3: the sabotage, revisited --------------------------
        // Session 1's saboteur wrote straight onto the array:
        //
        //     board[4][4] = 'Q';
        //
        // Try the equivalent now — uncomment and compile:
        //
        // game.getBoard().pieces[4][4] = new ChessPiece(game.getBoard(), 'Q', 4, 4);
        //
        // It does not compile: "pieces has private access in ChessBoard".
        // That is your one-sentence answer from session 1, exercise 4,
        // enforced by the compiler. Whether EVERY door is as well guarded
        // is another question — EXERCISES.md, exercise 3.

        game.play();
    }
}
