package assignment2.solution;

/** 1 point per hour. FestivalVolunteers's 'B'. */
public class BarShift extends Shift {

    public BarShift(int hours, String task) {
        super(hours, task);
    }

    @Override
    public int pointsFor(Volunteer volunteer) {
        return getHours();
    }

    @Override
    public String describeRule() {
        return "1 per hour";
    }
}
