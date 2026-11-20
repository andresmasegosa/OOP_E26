package session2.solution;

/**
 * Session 2 — OFFICIAL SOLUTION, the entry point.
 *
 * The scripted game of the session's Demo, with exercise 2 grown onto it:
 * main holds references to the white queen and both white rooks (through
 * getBoard()), answers the club's questions — and interrogates the ghost.
 * Exercise 3 produces no lasting code: its sabotage line must NOT compile
 * (that is the point), and the intruder and turn-bypass experiments
 * corrupt the position, so they stay here as comments.
 */
public class Demo {

    public static void main(String[] args) {
        // SOLUTION (exercise 1): count methods, including any legend edit.
        // Cost of the bishop, session 1:
        //   places touched: 2   of which switches: 2   did anything warn me: no
        // Cost of the bishop, session 2:
        //   places touched: 1   of which switches: 1   did anything warn me: no
        //   ChessPiece.isLegalMove is the only edit. The stored type already
        //   supplies the name, so there is no pieceName fix in this design.
        // Cost of the knight, session 1 (exercise 5 comparison):
        //   places touched: 4   of which switches: 2   did anything warn me: no
        //   setup: setupBoard; rule: isLegalMove; name: pieceName;
        //   drawing: printBoard's legend. Without that optional legend: 3.
        // Cost of the knight, session 2 (exercise 5):
        //   places touched: 5   of which switches: 3   did anything warn me: no
        //   setup: ChessGame.setupPieces; rule: ChessPiece.isLegalMove;
        //   name and letter: ChessPiece.typeFromLetter and getSymbol;
        //   drawing: ChessBoard.print's legend. Without that optional legend: 4.
        ChessGame game = new ChessGame();
        game.printBoard();

        // SOLUTION (exercise 2): ask the game for its board and the board
        // for the pieces BEFORE the game starts, and hold what it hands
        // you — it is not a copy, it is the piece. The reference will
        // follow the queen through every move; the square (7,3) will not.
        ChessPiece whiteQueen = game.getBoard().getPieceAt(7, 3);
        ChessPiece leftRook = game.getBoard().getPieceAt(7, 0);
        ChessPiece rightRook = game.getBoard().getPieceAt(7, 7);

        game.movePiece(7, 3, 4, 3);   // White queen straight up: legal
        game.movePiece(0, 0, 2, 2);   // Black rook diagonally: illegal
        game.movePiece(7, 0, 7, 2);   // White rook onto its own bishop: illegal
        game.movePiece(4, 3, 0, 3);   // The white queen captures the black queen!
        game.movePiece(0, 4, 0, 3);   // ...and the black king takes revenge.
        game.movePiece(7, 5, 5, 3);   // SOLUTION (exercise 1): now it succeeds.

        game.printBoard();

        // SOLUTION (exercise 2): the club's questions, answered without
        // searching anything — each reference still points at its piece.
        System.out.println();
        System.out.println("The club's statistics:");
        System.out.println("  White Queen moved " + whiteQueen.getMoveCount() + " times");
        System.out.println("  Left White Rook moved " + leftRook.getMoveCount() + " times");
        System.out.println("  Right White Rook moved " + rightRook.getMoveCount() + " times");

        // SOLUTION (exercise 2, the ghost): the white queen was captured in
        // move 5, the board has forgotten her — but our reference has not,
        // and nobody told HER anything.
        System.out.println("The ghost queen still claims to stand on ("
                + whiteQueen.getRow() + "," + whiteQueen.getCol() + ")");
        ChessPiece occupant = game.getBoard().getPieceAt(0, 3);
        System.out.println("The board says (0,3) is occupied by the "
                + occupant.getColor() + " " + occupant.getType());
        // Who should have told her — the board, in movePiece? The piece
        // itself? That is a responsibility question, and responsibilities
        // are session 5's subject. For now: write your one sentence.

        // EXERCISE 3 leftovers, for reference:
        //
        // game.getBoard().pieces[4][4] = new ChessPiece('Q');
        //   -> error: pieces has private access in ChessBoard
        //
        // game.getBoard().placePiece(4, 4, new ChessPiece('Q'));
        //   -> compiles and runs: a second white queen, politely placed.
        //      Every board invariant held; the chess-sense rule "pieces are
        //      not created mid-game" has no class enforcing it (yet).
        //
        // game.getBoard().movePiece(game.getBoard().getPieceAt(0, 7), 3, 7);
        //   -> compiles and runs: a Black rook moves on White's turn.
        //      The keyboard loop calls ChessGame.takeTurn to check the turn.
        //      This direct board call bypasses that check. The board itself
        //      knows nothing about turns.

        game.play();
    }
}
