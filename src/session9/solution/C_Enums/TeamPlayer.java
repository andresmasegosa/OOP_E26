package session9.solution.C_Enums;

/**
 * A player in a game with two teams, blue and red. Exercise C. The team is a
 * Team, BLUE or RED, instead of a String.
 */
public class TeamPlayer {

    private String name;
    private Team team;                  // exercise C

    public TeamPlayer(String name, Team team) {     // exercise C
        this.name = name;
        this.team = team;
    }

    public boolean isOnSameTeamAs(TeamPlayer other) {
        return team == other.team;      // exercise C
    }

    @Override
    public String toString() {
        return name + " (" + team + ")";
    }
}
