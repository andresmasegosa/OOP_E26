package assignment3.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Tests of pointsFor in the three types of shift, and of what a shift refuses. */
public class ShiftTest {

    private Volunteer twoFestivals;
    private Volunteer threeFestivals;

    @BeforeEach
    public void setUp() {
        twoFestivals = new Volunteer("Malik", 2);
        threeFestivals = new Volunteer("Ida", 3);
    }

    @Test
    public void barShiftEarnsOnePointPerHour() {
        assertEquals(8, new BarShift(8, "Beer bar").pointsFor(twoFestivals));
    }

    @Test
    public void recyclingShiftEarnsOnePointPerHourAndPerBag() {
        assertEquals(14, new RecyclingShift(8, "Cup recycling", 6).pointsFor(twoFestivals));
    }

    @Test
    public void leaderShiftEarnsTwoPerHourBeforeThreeFestivals() {
        assertEquals(8, new LeaderShift(4, "Recycling team leader").pointsFor(twoFestivals));
    }

    @Test
    public void leaderShiftEarnsThreePerHourAfterThreeFestivals() {
        assertEquals(24, new LeaderShift(8, "Bar team leader").pointsFor(threeFestivals));
    }

    @Test
    public void shiftPrintsItsHoursAndTask() {
        assertEquals("8 h, Beer bar", new BarShift(8, "Beer bar").toString());
    }

    @Test
    public void shiftOfZeroHoursIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new BarShift(0, "Beer bar"));
    }

    @Test
    public void shiftOfThirteenHoursIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new LeaderShift(13, "Bar team leader"));
    }

    @Test
    public void recyclingShiftWithNegativeBagsIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new RecyclingShift(8, "Cup recycling", -2));
    }
}
