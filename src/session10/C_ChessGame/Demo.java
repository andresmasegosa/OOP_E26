package session10.C_ChessGame;

import session10.C_ChessGame.players.GreedyPlayer;
import session10.C_ChessGame.players.RandomPlayer;

/**
 * Plays one game of mini-chess between two programs. GreedyPlayer plays White
 * and RandomPlayer plays Black, so nobody types anything.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against RandomPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new RandomPlayer());
        game.play();

        // --- EXERCISES 1 AND 2 ------------------------------------------
        // See EXERCISES.md. After each exercise this game still ends with
        // a winner, and the tests in test/session10/C_ChessGame stay green.
    }
}
