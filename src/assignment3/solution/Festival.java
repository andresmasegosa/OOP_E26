package assignment3.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * The volunteers of the festival, in a List: they are printed in the order
 * they joined, and the list takes as many as join. A second volunteer with the
 * same name is refused.
 */
public class Festival {

    private List<Volunteer> volunteers = new ArrayList<>();

    public void addVolunteer(Volunteer volunteer) {
        if (volunteers.contains(volunteer)) {
            throw new DuplicateVolunteerException(volunteer.getName());
        }
        volunteers.add(volunteer);
    }

    public int getVolunteerCount() {
        return volunteers.size();
    }

    /** Task 1, one line for each volunteer. */
    public void printVolunteers() {
        for (Volunteer volunteer : volunteers) {
            System.out.println("  " + volunteer.introduction());
        }
    }

    /** The points of every volunteer on one line, each printed by its toString. */
    public void printPoints() {
        System.out.print("  Points:");
        for (int i = 0; i < volunteers.size(); i++) {
            System.out.print(" " + volunteers.get(i));
            if (i < volunteers.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
