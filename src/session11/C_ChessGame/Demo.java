package session11.C_ChessGame;

import session11.C_ChessGame.listeners.CaptureCounter;
import session11.C_ChessGame.listeners.Scoreboard;
import session11.C_ChessGame.players.GreedyPlayer;

/**
 * Plays one game of mini-chess between two programs. Both players are a
 * GreedyPlayer, so both of them capture pieces and nobody types anything. The
 * game has a CaptureCounter and a Scoreboard, and Demo prints the captures of
 * each player at the end.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("GreedyPlayer (White) against GreedyPlayer (Black).");
        ChessGame game = new ChessGame(new GreedyPlayer(), new GreedyPlayer());
        CaptureCounter counter = new CaptureCounter();
        game.addListener(counter);
        game.addListener(new Scoreboard());
        game.play();
        System.out.println("Captures: WHITE " + counter.getCaptures(Color.WHITE)
                + ", BLACK " + counter.getCaptures(Color.BLACK));

        // --- EXERCISES ---------------------------------------------------
        // See EXERCISES.md. After each exercise this game still plays to the
        // end, and the tests in test/session11/C_ChessGame still pass.
    }
}
