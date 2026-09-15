package session4.C_ChessGame.players;

import session4.C_ChessGame.ChessBoard;

import java.util.Scanner;

/**
 * A player at the keyboard. This is session 3's ChessGame.play, from the
 * prompt to the four numbers, moved into a class of its own.
 *
 * Read it next to session3/E_ChessGame/ChessGame.java. The Scanner, the
 * line that explains how to type a move, the forgiving parsing and the q to
 * quit were all in the game, mixed with the turn and the board. Here they
 * are the whole of one class, and the game does not know they exist. What
 * the game knows is that it has a Player and can ask it for a move.
 *
 * Its whole state is one Scanner. It shares no field with ScriptedPlayer,
 * and like ScriptedPlayer it never looks at the board it is handed: the
 * human looks at the picture the game has just printed.
 */
public class KeyboardPlayer implements Player {

    private Scanner keyboard = new Scanner(System.in);

    /**
     * Ask this human for a move, and keep asking until the line makes sense
     * or the human gives up. Returns null when the player types q, or when
     * the input ends; the contract in Player says what null means.
     */
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

            // Be forgiving about punctuation: "7,3 4,3" and "(7,3) -> (4,3)",
            // which is how the game itself writes a move, both mean 7 3 4 3.
            String cleaned = line.replace(",", " ").replace("(", " ").replace(")", " ").replace("->", " ");

            // Pull the four numbers out of the line, as in session 3. A
            // second Scanner reads the line the way the first one reads the
            // keyboard, and hasNextInt lets us look before we take.
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
