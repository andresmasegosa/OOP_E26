package session7.E_ChessGame;

import session7.E_ChessGame.players.GreedyPlayer;
import session7.E_ChessGame.players.RandomPlayer;

/**
 * Plays one game of mini-chess between two programs. GreedyPlayer plays White
 * and RandomPlayer plays Black, so nobody types anything.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against RandomPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new RandomPlayer());
        game.play();

        // --- EXERCISES 1, 2 AND 3 ----------------------------------------
        // Run this Demo after each exercise. See EXERCISES.md.
    }
}
