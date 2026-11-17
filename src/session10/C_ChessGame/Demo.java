package session10.C_ChessGame;

import session10.C_ChessGame.players.GreedyPlayer;

/**
 * Plays one game of mini-chess between two programs. Both players are a
 * GreedyPlayer, so both of them capture pieces and nobody types anything.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against GreedyPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new GreedyPlayer());
        game.play();

        // --- EXERCISES 1 AND 2 ------------------------------------------
        // See EXERCISES.md. After each exercise this game still plays to the
        // end, and the tests in test/session10/C_ChessGame still pass.
    }
}
