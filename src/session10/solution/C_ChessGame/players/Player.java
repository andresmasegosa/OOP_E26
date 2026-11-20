package session10.solution.C_ChessGame.players;

import session10.solution.C_ChessGame.ChessBoard;
import session10.solution.C_ChessGame.Color;

/**
 * Something that can choose a move. ChessGame calls Player.chooseMove when it
 * is this player's turn, with the board as it stands and the player's colour.
 * The answer is the move the player wants to make, or null to stop playing.
 * ChessGame checks the move, and asks again when it is illegal.
 */
public interface Player {

    Move chooseMove(ChessBoard board, Color color);
}
