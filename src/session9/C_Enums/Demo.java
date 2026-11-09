package session9.C_Enums;

/**
 * Step C. An enum is a type with a fixed list of values. A switch can choose
 * by the value, and a value of an enum can hold data, as each Planet holds
 * its position.
 */
public class Demo {

    public static void main(String[] args) {
        Day day = Day.FRIDAY;
        switch (day) {
            case MONDAY:
                System.out.println("Monday! Bummer!");
                break;
            case FRIDAY:
                System.out.println("Aww yeah!");
                break;
            default:
                System.out.println("Just another day.");
                break;
        }

        Planet planet = Planet.EARTH;
        System.out.println(planet + " is planet number " + planet.getPosition());

        TeamPlayer mia = new TeamPlayer("Mia", "Blue");
        TeamPlayer jonas = new TeamPlayer("Jonas", "blue");
        System.out.println(mia + " and " + jonas);
        System.out.println("Same team: " + mia.isOnSameTeamAs(jonas));

        // --- EXERCISE C --------------------------------------------------
        // Give TeamPlayer a team of type Team. See EXERCISES.md.
    }
}
