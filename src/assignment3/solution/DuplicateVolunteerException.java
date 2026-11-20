package assignment3.solution;

/** A volunteer joins a festival that already has a volunteer with that name. */
public class DuplicateVolunteerException extends RuntimeException {

    private String name;

    public DuplicateVolunteerException(String name) {
        super(name + " is already a volunteer.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
