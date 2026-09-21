package session5.B_Player.players;

import session5.B_Player.ChessBoard;

/**
 * Something that can choose a move. That is all this type says.
 *
 * Session 3 ended wanting to play against the computer instead of against a
 * classmate. Look at what stood in the way. ChessGame owned a Scanner,
 * printed the prompt and pulled four numbers out of a typed line, so a game
 * without a human at the keyboard was not a thing it could have. The game
 * was written around one kind of player.
 *
 * This interface takes the question out of the game. A game asks whoever is
 * to move for a move, and what that somebody is, a person, a program, or
 * something nobody has written yet, is not a question the game can answer
 * and not one it needs to.
 *
 * Look at KeyboardPlayer and RandomPlayer next to this file. One holds a
 * Scanner, the other holds a Random. They share no field at all, so there is
 * no common code for a superclass to hold, and an interface is what fits: a
 * class can implement many interfaces while it can extend only one class.
 *
 * Every member of an interface is public, so the word public is not written
 * on the method below. (Chapter 8, "Interfaces".)
 *
 * THE CONTRACT. An interface has no code, so its javadoc is all the caller
 * has. Read this as the promise a Player makes.
 *
 *   - chooseMove is called only when it is this player's turn.
 *   - color is "White" or "Black", and it is this player's colour.
 *   - board shows the position as it stands now. RandomPlayer reads it;
 *     KeyboardPlayer ignores it, because the person is looking at the picture
 *     the game has just printed. An implementation may ignore a parameter;
 *     what it may not do is leave the method out.
 *   - The answer is a move this player wants to make, or null to stop
 *     playing. A person types q; a program that has given up returns null.
 *   - The move need NOT be legal. Nothing here promises that, and the game
 *     checks it and asks again.
 *
 * That last point is where an interface earns its keep and also where it
 * costs you. A game can work with any Player at all, including ones written
 * after it, precisely because it promises them so little and trusts them
 * with nothing.
 */
public interface Player {

    Move chooseMove(ChessBoard board, String color);
}
