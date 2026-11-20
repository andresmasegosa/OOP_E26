package assignment3.solution;

/** 1 point per hour and 1 per bag of cups. A recycling shift has 0 bags or more. */
public class RecyclingShift extends Shift {

    private int bags;

    public RecyclingShift(int hours, String task, int bags) {
        super(hours, task);
        if (bags < 0) {
            throw new IllegalArgumentException("A recycling shift has 0 bags or more, not " + bags + ".");
        }
        this.bags = bags;
    }

    @Override
    public int pointsFor(Volunteer volunteer) {
        return getHours() + bags;
    }

    @Override
    public String describeRule() {
        return "1 per hour and 1 per bag";
    }
}
