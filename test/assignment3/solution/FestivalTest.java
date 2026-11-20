package assignment3.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Tests of addVolunteer in Festival. */
public class FestivalTest {

    private Festival festival;

    @BeforeEach
    public void setUp() {
        festival = new Festival();
        festival.addVolunteer(new Volunteer("Ida", 3));
        festival.addVolunteer(new Volunteer("Malik", 2));
    }

    @Test
    public void festivalTakesMoreThanTenVolunteers() {
        for (int i = 1; i <= 12; i++) {
            festival.addVolunteer(new Volunteer("Volunteer " + i, 0));
        }
        assertEquals(14, festival.getVolunteerCount());
    }

    @Test
    public void secondVolunteerWithTheSameNameIsRefused() {
        DuplicateVolunteerException e = assertThrows(DuplicateVolunteerException.class,
                () -> festival.addVolunteer(new Volunteer("Ida", 1)));
        assertEquals("Ida", e.getName());
        assertEquals(2, festival.getVolunteerCount());
    }
}
