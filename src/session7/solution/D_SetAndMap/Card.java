package session7.solution.D_SetAndMap;

import java.util.Objects;

/**
 * A playing card, known by its name, such as "Ace of Hearts".
 *
 * It has the shape of President.java next to it, one private field, a
 * constructor, a getter and toString. President also has equals and hashCode,
 * and in the provided folder Card has neither.
 *
 * Exercise D. Card now has both, below, written the way President writes
 * them. The import line for Objects comes with them.
 */
public class Card {

    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * The card prints as its name, so a list of cards prints as a list of
     * names. (Chapter 7, "The Object Class".)
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Exercise D. Two cards are equal when they have the same name.
     *
     * The parameter is an Object, as in Object.equals, so that this method
     * overrides it. A HashSet and a HashMap call equals(Object), and a method
     * equals(Card other) would be a second method that neither of them ever
     * calls. getClass() is the shape President uses. other instanceof Card,
     * without a variable name, is just as correct here.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Card that = (Card) other;
        return Objects.equals(name, that.name);
    }

    /**
     * Exercise D. Computed from name, the field equals compares, so two equal
     * cards always have the same hash code. Without this method the set of
     * part 3 still holds six cards, and the map answers null for a new Ace of
     * Hearts. That is the discussion question of exercise D.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
