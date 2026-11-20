package assignment1.solution;

/**
 * The same month as FlatShare.main, told with objects. Its output is
 * expected-output.txt, line for line.
 */
public class Main {

    public static void main(String[] args) {
        // Cost of the rent, FlatShare.java:  places touched: 3   of which switches: 2   did anything warn me: no
        // Cost of the rent, my design:       places touched: 3   of which switches: 2   did anything warn me: no

        Flat flat = new Flat();
        System.out.println("September in the flat");

        Flatmate freja = new Flatmate("Freja", 14);
        Flatmate ali = new Flatmate("Ali", 12);
        Flatmate mathilde = new Flatmate("Mathilde", 10);
        Flatmate jonas = new Flatmate("Jonas", 14);
        flat.moveIn(freja);
        flat.moveIn(ali);
        flat.moveIn(mathilde);
        flat.moveIn(jonas);

        flat.addExpense(new Expense("Rent", freja, 10000, "Rent"));
        flat.addExpense(new Expense("Equal", mathilde, 480, "Groceries"));
        flat.addExpense(new Expense("Equal", jonas, 320, "Internet"));
        flat.addExpense(new Expense("One flatmate", ali, 450, "Concert ticket for Jonas", jonas));

        // Mathilde pays Freja back and moves out. Then Sofie moves in.
        flat.addExpense(new Expense("One flatmate", mathilde, 1720, "Paying Freja back", freja));
        flat.moveOut(mathilde);
        Flatmate sofie = new Flatmate("Sofie", 10);
        flat.moveIn(sofie);
        flat.addExpense(new Expense("Equal", sofie, 200, "Cleaning supplies"));

        // Jonas wants to move out too, and still owes money.
        flat.moveOut(jonas);

        flat.printBalances();
        flat.printHistory();

        // The sabotage of FlatShare.java, in this design:
        //
        // freja.balance = freja.balance + 500;
        //
        // error: balance has private access in Flatmate
    }
}
