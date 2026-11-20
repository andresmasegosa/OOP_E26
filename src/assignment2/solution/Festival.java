package assignment2.solution;

/** The volunteers of the festival, in the order they joined. */
public class Festival {

    private Volunteer[] volunteers = new Volunteer[10];
    private int count = 0;

    public void addVolunteer(Volunteer volunteer) {
        volunteers[count] = volunteer;
        count++;
    }

    /** Task 1, one line for each volunteer. */
    public void printVolunteers() {
        for (int i = 0; i < count; i++) {
            volunteers[i].printIntroduction();
        }
    }

    /** The points of every volunteer on one line, and who has earned a ticket. */
    public void printPoints() {
        System.out.print("  Points:");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + volunteers[i].getName() + " " + volunteers[i].getPoints());
            if (volunteers[i].hasTicket()) {
                System.out.print(" (ticket)");
            }
            if (i < count - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
