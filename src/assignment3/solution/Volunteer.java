package assignment3.solution;

import java.util.Objects;

/**
 * One volunteer. The points change only in work, when the volunteer works a
 * shift. Two volunteers with the same name are equal, which is what the
 * festival checks when one joins.
 */
public class Volunteer {

    private String name;
    private int festivals;   // festivals before this one
    private int points;      // starts at 0

    public Volunteer(String name, int festivals) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("A volunteer needs a name.");
        }
        this.name = name;
        this.festivals = festivals;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getFestivals() {
        return festivals;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasTicket() {
        return points >= 30;
    }

    /** The volunteer works a shift and earns its points. The shift prints itself. */
    public void work(Shift shift) {
        int earned = shift.pointsFor(this);
        points = points + earned;
        System.out.println("  " + name + " worked " + shift + ": " + earned + " points ("
                + shift.describeRule() + ")");
    }

    /** The line of task 1. */
    public String introduction() {
        return name + " has helped at " + festivals + " festivals before";
    }

    /** A volunteer prints as the name and the points, such as Ida 42 (ticket). */
    @Override
    public String toString() {
        if (hasTicket()) {
            return name + " " + points + " (ticket)";
        }
        return name + " " + points;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Volunteer volunteer = (Volunteer) other;
        return Objects.equals(name, volunteer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
