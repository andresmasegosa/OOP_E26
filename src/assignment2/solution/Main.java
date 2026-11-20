package assignment2.solution;

/** The festival of FestivalVolunteers.main, told with objects, and then task 4. */
public class Main {

    public static void main(String[] args) {
        // Task 1. The volunteers. Exercise 1.
        System.out.println("Task 1. The volunteers");
        Volunteer ida = new Volunteer("Ida", 3);
        Volunteer malik = new Volunteer("Malik", 2);
        Volunteer oskar = new Volunteer("Oskar", 0);
        Festival festival = new Festival();
        festival.addVolunteer(ida);
        festival.addVolunteer(malik);
        festival.addVolunteer(oskar);
        festival.printVolunteers();

        // Task 2. Day 1, the bars. Exercise 2.
        System.out.println("Task 2. Day 1, the bars");
        ida.work(new BarShift(8, "Beer bar"));
        malik.work(new BarShift(8, "Cocktail bar"));
        oskar.work(new BarShift(8, "Beer bar"));
        oskar.work(new BarShift(8, "Coffee bar"));
        festival.printPoints();

        // Task 3. Day 2, cup recycling. Exercise 3.
        System.out.println("Task 3. Day 2, cup recycling");
        ida.work(new RecyclingShift(8, "Cup recycling", 2));
        malik.work(new RecyclingShift(8, "Cup recycling", 6));
        oskar.work(new RecyclingShift(8, "Cup recycling", 4));
        festival.printPoints();

        // Task 4. Day 3, the team leaders. Exercise 4.
        System.out.println("Task 4. Day 3, the team leaders");
        ida.work(new LeaderShift(8, "Bar team leader"));
        malik.work(new LeaderShift(4, "Recycling team leader"));
        festival.printPoints();
    }
}
