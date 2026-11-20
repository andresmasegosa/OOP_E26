package assignment3.solution;

/**
 * What every type of shift has in common, written once. A shift has from 1 to
 * 12 hours, and this constructor refuses any other number for every type of
 * shift at once.
 */
public abstract class Shift {

    private int hours;
    private String task;

    public Shift(int hours, String task) {
        if (hours < 1 || hours > 12) {
            throw new IllegalArgumentException("A shift has from 1 to 12 hours, not " + hours + ".");
        }
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

    /** A shift prints as its hours and its task, such as 8 h, Beer bar. */
    @Override
    public String toString() {
        return hours + " h, " + task;
    }
}
