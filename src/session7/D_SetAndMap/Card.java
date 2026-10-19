package session7.D_SetAndMap;

/**
 * A playing card, known by its name, such as "Ace of Hearts".
 *
 * It has the shape of President.java next to it, one private field, a
 * constructor, a getter and toString. President also has equals and hashCode,
 * and Card has neither. In exercise D you write the two here.
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
}
