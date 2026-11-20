package session8.solution.C_TDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Step C. The class BadmintonPlayer does not exist yet. A badminton player has
 * a name and the number of matches won and lost. BadmintonPlayer.wonMatch
 * records a won match, and BadmintonPlayer.lostMatch a lost one. Each test is
 * written before the code it asks for.
 */
public class BadmintonPlayerTest {

    @Test
    public void newPlayer() {                        // step 1
        BadmintonPlayer player = new BadmintonPlayer("Mia");
        assertEquals("Mia", player.getName());
        assertEquals(0, player.getWins());
        assertEquals(0, player.getLosses());
    }

    @Test
    public void wonMatch() {                         // step 2
        BadmintonPlayer player = new BadmintonPlayer("Mia");
        player.wonMatch();
        player.wonMatch();
        assertEquals(2, player.getWins());
        assertEquals(0, player.getLosses());
    }

    @Test
    public void lostMatch() {                        // step 3
        BadmintonPlayer player = new BadmintonPlayer("Mia");
        player.lostMatch();
        assertEquals(1, player.getLosses());
        assertEquals(0, player.getWins());
    }
}
