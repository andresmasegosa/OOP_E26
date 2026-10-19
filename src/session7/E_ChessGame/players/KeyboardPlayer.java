package session7.E_ChessGame.players;

import session7.E_ChessGame.ChessBoard;

import java.util.Scanner;

/**
 * A player at the keyboard. It reads a move as four numbers, and asks again
 * until the line makes sense. It returns null when the player types q, or when
 * the input ends.
 */
public class KeyboardPlayer implements Player {

    private Scanner keyboard = new Scanner(System.in);

    @Override
    public Move chooseMove(ChessBoard board, String color) {
        while (true) {
            System.out.println(color + " to move. Type the square of the piece and the square it goes to,");
            System.out.println("as four numbers: fromRow fromCol toRow toCol   (for example: 7 3 4 3). Type q to quit.");
            System.out.print(color + " > ");

            if (!keyboard.hasNextLine()) {      // the input ended (Ctrl-D, or a file ran out)
                System.out.println();
                return null;
            }
            String line = keyboard.nextLine().trim();
            if (line.equals("q") || line.equals("quit")) {
                return null;
            }

            // "7,3 4,3" and "(7,3) -> (4,3)" both mean 7 3 4 3.
            String cleaned = line.replace(",", " ").replace("(", " ").replace(")", " ").replace("->", " ");

            // A second Scanner reads the four numbers out of the line.
            Scanner numbers = new Scanner(cleaned);
            int[] squares = new int[4];
            int found = 0;
            while (found < 4 && numbers.hasNextInt()) {
                squares[found] = numbers.nextInt();
                found++;
            }

            if (found < 4 || numbers.hasNext()) {
                System.out.println("Sorry, I did not understand \"" + line + "\"."
                        + " A move is four numbers between 0 and 7, for example: 7 3 4 3");
            } else {
                return new Move(squares[0], squares[1], squares[2], squares[3]);
            }
        }
    }
}
