package assignment2;

/**
 * Assignment 2, the program you start from. Leave this file as it is.
 *
 * The volunteers of a music festival, with no objects. Volunteer number i
 * has the name names[i], has helped at festivals[i] festivals before this
 * one, and has earned points[i] points at this one. Only positions 0 to
 * count - 1 are in use. A volunteer with 30 points or more gets their
 * festival ticket for free.
 *
 * Each type of shift has a letter.
 *   'B'  a bar shift, 1 point per hour
 *   'R'  a recycling shift, 1 point per hour and 1 per bag of cups collected
 *
 * main does three tasks, and each one prints its result. Each task starts
 * with a comment, Task 1, Task 2 and Task 3, that names the methods it uses.
 */
public class FestivalVolunteers {

    // The volunteers, one position per person. 10 is enough for this festival.
    static String[] names = new String[10];
    static int[] festivals = new int[10];   // festivals before this one
    static int[] points = new int[10];
    static int count = 0;

    public static void main(String[] args) {
        // Task 1. Three volunteers join the festival, and the program lists them.
        // It uses addVolunteer and printVolunteers. Exercise 1 rebuilds it.
        System.out.println("Task 1. The volunteers");
        addVolunteer("Ida", 3);
        addVolunteer("Malik", 2);
        addVolunteer("Oskar", 0);
        printVolunteers();

        // Task 2. On the first day the volunteers work bar shifts and earn points.
        // It uses addShift with the type 'B', ruleName and printPoints. Exercise 2 rebuilds it.
        System.out.println("Task 2. Day 1, the bars");
        addShift('B', 0, 8, "Beer bar", 0);
        addShift('B', 1, 8, "Cocktail bar", 0);
        addShift('B', 2, 8, "Beer bar", 0);
        addShift('B', 2, 8, "Coffee bar", 0);
        printPoints();

        // Task 3. On the second day the volunteers collect cups for recycling.
        // It uses addShift with the type 'R', ruleName and printPoints. Exercise 3 rebuilds it.
        System.out.println("Task 3. Day 2, cup recycling");
        addShift('R', 0, 8, "Cup recycling", 2);
        addShift('R', 1, 8, "Cup recycling", 6);
        addShift('R', 2, 8, "Cup recycling", 4);
        printPoints();
    }

    /** A new volunteer joins, with 0 points. */
    static void addVolunteer(String name, int festivalsBefore) {
        names[count] = name;
        festivals[count] = festivalsBefore;
        points[count] = 0;
        count++;
    }

    /** Every volunteer, and how many festivals they have helped at before. */
    static void printVolunteers() {
        for (int i = 0; i < count; i++) {
            System.out.println("  " + names[i] + " has helped at " + festivals[i] + " festivals before");
        }
    }

    /** The volunteer at names[volunteer] worked a shift. Only 'R' uses bags. */
    static void addShift(char type, int volunteer, int hours, String task, int bags) {
        int earned = 0;
        switch (type) {
            case 'B':
                earned = hours;
                break;
            case 'R':
                earned = hours + bags;
                break;
        }
        points[volunteer] = points[volunteer] + earned;
        System.out.println("  " + names[volunteer] + " worked " + hours + " h, " + task + ": "
                + earned + " points (" + ruleName(type) + ")");
    }

    /** How a shift of this type earns points, for the printed line. */
    static String ruleName(char type) {
        switch (type) {
            case 'B':
                return "1 per hour";
            case 'R':
                return "1 per hour and 1 per bag";
            default:
                return "?";
        }
    }

    /** The points of every volunteer on one line, and who has earned a ticket. */
    static void printPoints() {
        System.out.print("  Points:");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + names[i] + " " + points[i]);
            if (points[i] >= 30) {
                System.out.print(" (ticket)");
            }
            if (i < count - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
