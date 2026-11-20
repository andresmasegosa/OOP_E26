package assignment3.solution;

/** 2 points per hour, 3 after 3 festivals or more. */
public class LeaderShift extends Shift {

    public LeaderShift(int hours, String task) {
        super(hours, task);
    }

    @Override
    public int pointsFor(Volunteer volunteer) {
        if (volunteer.getFestivals() >= 3) {
            return 3 * getHours();
        }
        return 2 * getHours();
    }

    @Override
    public String describeRule() {
        return "2 per hour, 3 after 3 festivals";
    }
}
