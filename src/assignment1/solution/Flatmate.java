package assignment1.solution;

/**
 * One person who lives in the flat.
 *
 * What FlatShare kept at the same position of three parallel arrays is now
 * one object. A variable that holds a Flatmate keeps pointing at the same
 * person, whatever the flat does with its arrays.
 */
public class Flatmate {

    private String name;
    private int roomSize;   // square meters
    private int balance;    // kroner, positive when the others owe this person money

    public Flatmate(String name, int roomSize) {
        this.name = name;
        this.roomSize = roomSize;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * The one way a balance changes. It has no modifier, so it is visible only
     * inside the package assignment1, and Flat is the only class that calls
     * it. There is no public setter, because a balance that anyone can set is
     * the sabotage again.
     */
    void changeBalance(int amount) {
        balance = balance + amount;
    }
}
