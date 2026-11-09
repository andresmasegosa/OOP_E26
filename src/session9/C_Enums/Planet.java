package session9.C_Enums;

/**
 * The four planets closest to the sun. An enum can have fields, a constructor
 * and methods. Each value is made by the constructor, with the number in
 * brackets after its name.
 */
public enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4);

    private int position;

    Planet(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
