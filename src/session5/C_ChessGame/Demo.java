package session5.C_ChessGame;

import session5.C_ChessGame.players.KeyboardPlayer;
import session5.C_ChessGame.players.RandomPlayer;

/**
 * Starts the game. Every folder of this session has a class called Demo, and
 * this is the one the EXERCISES.md of this folder means when it says Demo or
 * Demo.main, the class session5.C_ChessGame.Demo.
 *
 * Two games run here, and the only difference between them is the two
 * arguments on one line. The first is played by two programs and needs no
 * keyboard at all. The second is the one session 3 asked for: you against
 * the machine.
 */
public class Demo {

    public static void main(String[] args) {
        // --- EXERCISE 1: your cost line for the Amazon goes here, under the
        //     three lines of sessions 1, 2 and 3.

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

        // --- Now your game --------------------------------------------------
        // One line, two different arguments. Change RandomPlayer for
        // KeyboardPlayer and it is two people again.

        System.out.println();
        System.out.println("Your turn! You are White, the machine is Black, and White moves first.");
        ChessGame game = new ChessGame(new KeyboardPlayer(), new RandomPlayer());
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
