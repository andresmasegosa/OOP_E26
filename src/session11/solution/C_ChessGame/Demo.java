package session11.solution.C_ChessGame;

import session11.solution.C_ChessGame.listeners.CaptureCounter;
import session11.solution.C_ChessGame.listeners.CheckAnnouncer;
import session11.solution.C_ChessGame.listeners.Scoreboard;
import session11.solution.C_ChessGame.players.GreedyPlayer;

/**
 * Plays one game of mini-chess between two programs. Both players are a
 * GreedyPlayer, so both of them capture pieces and nobody types anything. The
 * game has a CaptureCounter and a Scoreboard, and Demo prints the captures of
 * each player at the end. Exercise 2. The game has a CheckAnnouncer too.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against GreedyPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new GreedyPlayer());
        CaptureCounter counter = new CaptureCounter();
        game.addListener(counter);
        game.addListener(new Scoreboard());
        game.addListener(new CheckAnnouncer(game.getBoard()));       // exercise 2
        game.play();
        System.out.println("Captures: WHITE " + counter.getCaptures(Color.WHITE)
                + ", BLACK " + counter.getCaptures(Color.BLACK));

        // --- EXERCISES 1 AND 2, solved -----------------------------------
        // Each change is marked // exercise N in its file.
    }
}
