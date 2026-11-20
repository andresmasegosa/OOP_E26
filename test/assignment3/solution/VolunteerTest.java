package assignment3.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests of work, hasTicket and toString in Volunteer, and of what its constructor refuses. */
public class VolunteerTest {

    private Volunteer oskar;

    @BeforeEach
    public void setUp() {
        oskar = new Volunteer("Oskar", 0);
    }

    @Test
    public void workAddsThePointsOfEachShift() {
        oskar.work(new BarShift(8, "Beer bar"));
        oskar.work(new RecyclingShift(8, "Cup recycling", 4));
        assertEquals(20, oskar.getPoints());
    }

    @Test
    public void ticketAtThirtyPoints() {
        oskar.work(new RecyclingShift(10, "Cup recycling", 20));
        assertTrue(oskar.hasTicket());
    }

    @Test
    public void noTicketAtTwentyNinePoints() {
        oskar.work(new RecyclingShift(10, "Cup recycling", 19));
        assertFalse(oskar.hasTicket());
    }

    @Test
    public void volunteerPrintsNameAndPoints() {
        oskar.work(new BarShift(8, "Beer bar"));
        assertEquals("Oskar 8", oskar.toString());
    }

    @Test
    public void refusedShiftLeavesThePointsAlone() {
        oskar.work(new BarShift(8, "Beer bar"));
        assertThrows(IllegalArgumentException.class, () -> oskar.work(new BarShift(14, "Beer bar")));
        assertEquals(8, oskar.getPoints());
    }

    @Test
    public void volunteerWithNoNameIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new Volunteer("", 1));
    }
}
