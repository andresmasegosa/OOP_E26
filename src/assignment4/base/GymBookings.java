package assignment4.base;

/**
 * Assignment 4, the program you start from. Leave this file as it is.
 *
 * The members and the workouts of a gym, with no objects. Member number m has
 * the name memberNames[m] and has booked workoutsBooked[m] workouts this
 * month. Workout number w has the name workoutNames[w] and places[w] free
 * places. Only positions 0 to memberCount - 1 and 0 to workoutCount - 1 are
 * in use.
 *
 * A member cannot book a workout that is full. A member pays 60 kr for each
 * workout booked in the month.
 *
 * main does three tasks, and each one prints its result. Each task starts
 * with a comment, Task 1, Task 2 and Task 3, that names the methods it uses.
 */
public class GymBookings {

    // The members, one position per person. 10 is enough for this gym.
    static String[] memberNames = new String[10];
    static int[] workoutsBooked = new int[10];
    static int memberCount = 0;

    // The workouts, one position per workout.
    static String[] workoutNames = new String[10];
    static int[] places = new int[10];
    static int workoutCount = 0;

    public static void main(String[] args) {
        // Task 1. Three members join the gym, and the program lists them.
        // It uses addMember and printMembers. Exercise 1 rebuilds it.
        System.out.println("Task 1. The members");
        int freja = addMember("Freja");
        int omar = addMember("Omar");
        int sofie = addMember("Sofie");
        printMembers();

        // Task 2. The gym has two workouts on Monday, and the members book them.
        // It uses addWorkout, book and printWorkouts. Exercise 1 rebuilds it.
        System.out.println("Task 2. Monday's workouts");
        int spinning = addWorkout("Spinning", 2);
        int yoga = addWorkout("Yoga", 10);
        book(freja, spinning);
        book(sofie, spinning);
        book(omar, spinning);
        book(omar, yoga);
        book(sofie, yoga);
        printWorkouts();

        // Task 3. The bills of the month, and what the gym gets in total.
        // It uses printBills and bill. Exercise 1 rebuilds it.
        System.out.println("Task 3. The bills");
        printBills();
    }

    /** A new member joins the gym. Returns the number of the member. */
    static int addMember(String name) {
        int member = memberCount;
        memberNames[member] = name;
        memberCount++;
        return member;
    }

    /** The name of every member. */
    static void printMembers() {
        for (int m = 0; m < memberCount; m++) {
            System.out.println("  " + memberNames[m]);
        }
    }

    /** A new workout, with all its places free. Returns the number of the workout. */
    static int addWorkout(String name, int numberOfPlaces) {
        int workout = workoutCount;
        workoutNames[workout] = name;
        places[workout] = numberOfPlaces;
        workoutCount++;
        return workout;
    }

    /** Member number member books workout number workout, unless it is full. */
    static void book(int member, int workout) {
        if (places[workout] == 0) {
            System.out.println("  " + memberNames[member] + " could not book " + workoutNames[workout]
                    + ", it is full");
        } else {
            places[workout] = places[workout] - 1;
            workoutsBooked[member] = workoutsBooked[member] + 1;
            System.out.println("  " + memberNames[member] + " booked " + workoutNames[workout]);
        }
    }

    /** Every workout, and how many of its places are free. */
    static void printWorkouts() {
        for (int w = 0; w < workoutCount; w++) {
            System.out.println("  " + workoutNames[w] + ": " + places[w] + " free places");
        }
    }

    /** What member number member pays for the month. */
    static int bill(int member) {
        return 60 * workoutsBooked[member];
    }

    /** The bill of every member, and the total. */
    static void printBills() {
        int total = 0;
        for (int m = 0; m < memberCount; m++) {
            int amount = bill(m);
            total = total + amount;
            System.out.println("  " + memberNames[m] + ": booked " + workoutsBooked[m] + ", pays " + amount + " kr");
        }
        System.out.println("  Total: " + total + " kr");
    }
}
