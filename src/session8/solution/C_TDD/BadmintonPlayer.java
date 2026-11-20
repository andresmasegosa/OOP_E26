package session8.solution.C_TDD;

/**
 * A badminton player, with a name and the number of matches won and lost.
 * Written one test at a time, each method after the test that asks for it.
 */
public class BadmintonPlayer {

    private String name;
    private int wins;
    private int losses;

    public BadmintonPlayer(String name) {           // step 1
        this.name = name;
    }

    public String getName() {                        // step 1
        return name;
    }

    public int getWins() {                           // step 1
        return wins;
    }

    public int getLosses() {                         // step 1
        return losses;
    }

    public void wonMatch() {                         // step 2
        wins = wins + 1;
    }

    public void lostMatch() {                        // step 3
        losses = losses + 1;
    }
}
