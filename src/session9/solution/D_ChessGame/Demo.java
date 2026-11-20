package session9.solution.D_ChessGame;

import session9.solution.D_ChessGame.players.GreedyPlayer;
import session9.solution.D_ChessGame.players.RandomPlayer;

/**
 * Plays one game of mini-chess between two programs. GreedyPlayer plays White
 * and RandomPlayer plays Black, so nobody types anything.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against RandomPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new RandomPlayer());
        game.play();

        // --- EXERCISES 1, 2 AND 3, solved ---------------------------------
        // Not a line of this demo changes. Each change is marked
        // // exercise N in its file.
    }
}
