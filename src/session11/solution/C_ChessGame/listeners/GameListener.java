package session11.solution.C_ChessGame.listeners;

import session11.solution.C_ChessGame.ChessPiece;
import session11.solution.C_ChessGame.players.Move;

/**
 * A class that ChessGame notifies about its moves. ChessGame calls
 * GameListener.moveMade on each of its listeners after every move it makes.
 */
public interface GameListener {

    /** piece has just made move. captured is the piece it captured, or null if it captured nothing. */
    void moveMade(ChessPiece piece, Move move, ChessPiece captured);
}
