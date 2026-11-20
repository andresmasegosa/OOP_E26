package assignment2.solution;

/** 1 point per hour and 1 per bag of cups. FestivalVolunteers's 'R'. */
public class RecyclingShift extends Shift {

    private int bags;

    public RecyclingShift(int hours, String task, int bags) {
        super(hours, task);
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
