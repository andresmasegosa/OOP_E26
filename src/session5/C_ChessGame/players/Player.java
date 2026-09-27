package session5.C_ChessGame.players;

import session5.C_ChessGame.ChessBoard;

/**
 * Something that can choose a move. Step B's interface, with the same
 * one method.
 *
 * The board is a parameter because a player that decides for itself has to
 * see the position. KeyboardPlayer ignores it and RandomPlayer needs it.
 *
 * THE CONTRACT. This is the whole of what a Player promises, and the whole
 * of what it may expect. Read it before exercise 2, and read it again
 * after.
 *
 *   - chooseMove is called only when it is this player's turn.
 *   - color is "White" or "Black", and it is this player's color.
 *   - board shows the position as it stands now.
 *   - The answer is a move this player wants to make, or null to stop
 *     playing. A person types q, and a program that has given up returns
 *     null. Either way the game ends.
 *   - The move need NOT be legal. Nothing here promises that, and the game
 *     checks it: a piece of yours has to stand on the first square, the
 *     piece's rules have to allow the move, and the target may not hold a
 *     piece of your own color. A player that proposes an illegal move is
 *     told so and asked again.
 *
 * That last point is where an interface earns its keep and also where it
 * costs you. ChessGame can work with any Player at all, including ones
 * written after it, precisely because it promises them so little and trusts
 * them with nothing.
 */
public interface Player {

    Move chooseMove(ChessBoard board, String color);
}
