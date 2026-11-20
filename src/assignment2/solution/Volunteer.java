package assignment2.solution;

/**
 * One volunteer. Everything the program knows about a volunteer is here, and
 * the points change only in work, when the volunteer works a shift.
 */
public class Volunteer {

    private String name;
    private int festivals;   // festivals before this one
    private int points;      // starts at 0

    public Volunteer(String name, int festivals) {
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

    /**
     * The volunteer works a shift. The shift says how many points it earns for
     * this volunteer, and which shift it is never matters here.
     */
    public void work(Shift shift) {
        int earned = shift.pointsFor(this);
        points = points + earned;
        System.out.println("  " + name + " worked " + shift.getHours() + " h, " + shift.getTask() + ": "
                + earned + " points (" + shift.describeRule() + ")");
    }

    /** The line of task 1. */
    public void printIntroduction() {
        System.out.println("  " + name + " has helped at " + festivals + " festivals before");
    }
}
