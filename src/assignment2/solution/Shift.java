package assignment2.solution;

/**
 * What every type of shift has in common, written once. Each type says how
 * many points it earns and how it counts them. Both methods are abstract, so
 * a new type of shift that forgets one of them does not compile.
 */
public abstract class Shift {

    private int hours;
    private String task;

    public Shift(int hours, String task) {
        this.hours = hours;
        this.task = task;
    }

    public int getHours() {
        return hours;
    }

    public String getTask() {
        return task;
    }

    /** The points this shift earns for the volunteer who works it. */
    public abstract int pointsFor(Volunteer volunteer);

    /** How this type of shift counts points, in words. */
    public abstract String describeRule();
}
