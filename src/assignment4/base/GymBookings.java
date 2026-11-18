package assignment4.base;

/**
 * Assignment 4, the program you start from. Leave this file as it is.
 *
 * The members and the workouts of a gym, with no objects. Member number m has
 * the name memberNames[m] and the membership memberships[m]. Workout number w
 * has the name workoutNames[w] and places[w] places, and taken[w] of them are
 * taken. booked[w][m] is true when member m has a place in workout w. Only
 * positions 0 to memberCount - 1 and 0 to workoutCount - 1 are in use.
 *
 * Each type of membership has a letter.
 *   'B'  basic, 60 kr for each workout the member books in the month
 *   'P'  premium, 300 kr a month, for any number of workouts
 *   'S'  student, 40 kr for each workout, but never more than 100 kr a month
 *
 * A member cannot book a workout that is full, and cannot book the same
 * workout twice.
 *
 * main does three tasks, and each one prints its result. Each task starts
 * with a comment, Task 1, Task 2 and Task 3, that names the methods it uses.
 */
public class GymBookings {

    // The members, one position per person. 10 is enough for this gym.
    static String[] memberNames = new String[10];
    static char[] memberships = new char[10];
    static int memberCount = 0;

    // The workouts, one position per workout. booked[w][m] is about workout w and member m.
    static String[] workoutNames = new String[10];
    static int[] places = new int[10];
    static int[] taken = new int[10];
    static boolean[][] booked = new boolean[10][10];
    static int workoutCount = 0;

    public static void main(String[] args) {
        // Task 1. Four members join the gym, and the program lists them.
        // It uses addMember, printMembers and describe. Exercise 1 rebuilds it.
        System.out.println("Task 1. The members");
        addMember("Freja", 'P');
        addMember("Omar", 'B');
        addMember("Mikkel", 'B');
        addMember("Sofie", 'S');
        printMembers();

        // Task 2. The gym has four workouts on Monday, and the members book them.
        // It uses addWorkout, book and printWorkouts. Exercise 1 rebuilds it.
        System.out.println("Task 2. Monday's workouts");
        addWorkout("Spinning", 2);
        addWorkout("Yoga", 10);
        addWorkout("Boxing", 8);
        addWorkout("Pilates", 12);
        book(0, 0);   // Freja, Spinning
        book(1, 0);   // Omar, Spinning
        book(2, 0);   // Mikkel, Spinning
        book(2, 1);   // Mikkel, Yoga
        book(0, 1);   // Freja, Yoga
        book(0, 1);   // Freja, Yoga again
        book(1, 2);   // Omar, Boxing
        book(2, 2);   // Mikkel, Boxing
        book(3, 1);   // Sofie, Yoga
        book(3, 2);   // Sofie, Boxing
        book(3, 3);   // Sofie, Pilates
        printWorkouts();

        // Task 3. The bills of the month, and what the gym gets in total.
        // It uses printBills, workoutsBooked, bill and describe. Exercise 1 rebuilds it.
        System.out.println("Task 3. The bills");
        printBills();
    }

    /** A new member joins the gym. */
    static void addMember(String name, char membership) {
        memberNames[memberCount] = name;
        memberships[memberCount] = membership;
        memberCount++;
    }

    /** Every member, and their membership. */
    static void printMembers() {
        for (int m = 0; m < memberCount; m++) {
            System.out.println("  " + memberNames[m] + ", " + describe(memberships[m]));
        }
    }

    /** A new workout, with all its places free. */
    static void addWorkout(String name, int numberOfPlaces) {
        workoutNames[workoutCount] = name;
        places[workoutCount] = numberOfPlaces;
        taken[workoutCount] = 0;
        workoutCount++;
    }

    /** Member number member books workout number workout, unless it is booked already or full. */
    static void book(int member, int workout) {
        if (booked[workout][member]) {
            System.out.println("  " + memberNames[member] + " could not book " + workoutNames[workout]
                    + ", already booked");
        } else if (taken[workout] == places[workout]) {
            System.out.println("  " + memberNames[member] + " could not book " + workoutNames[workout]
                    + ", it is full");
        } else {
            booked[workout][member] = true;
            taken[workout] = taken[workout] + 1;
            System.out.println("  " + memberNames[member] + " booked " + workoutNames[workout]);
        }
    }

    /** Every workout, and how many of its places are taken. */
    static void printWorkouts() {
        for (int w = 0; w < workoutCount; w++) {
            System.out.println("  " + workoutNames[w] + ": " + taken[w] + " of " + places[w] + " places taken");
        }
    }

    /** How many workouts member number member has booked. */
    static int workoutsBooked(int member) {
        int count = 0;
        for (int w = 0; w < workoutCount; w++) {
            if (booked[w][member]) {
                count++;
            }
        }
        return count;
    }

    /** What a member with this membership pays for the month. */
    static int bill(char membership, int workouts) {
        switch (membership) {
            case 'B':
                return 60 * workouts;
            case 'P':
                return 300;
            case 'S':
                if (40 * workouts > 100) {
                    return 100;
                }
                return 40 * workouts;
            default:
                return 0;
        }
    }

    /** The membership and what it costs, for the printed lines. */
    static String describe(char membership) {
        switch (membership) {
            case 'B':
                return "basic, 60 kr per workout";
            case 'P':
                return "premium, 300 kr a month";
            case 'S':
                return "student, 40 kr per workout, at most 100 kr a month";
            default:
                return "?";
        }
    }

    /** The bill of every member, and the total. */
    static void printBills() {
        int total = 0;
        for (int m = 0; m < memberCount; m++) {
            int workouts = workoutsBooked(m);
            int amount = bill(memberships[m], workouts);
            total = total + amount;
            System.out.println("  " + memberNames[m] + ": " + workouts + " workouts, " + amount + " kr ("
                    + describe(memberships[m]) + ")");
        }
        System.out.println("  Total: " + total + " kr");
    }
}
