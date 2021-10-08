package main.piece;

import main.board.Board;
import main.piece.Piece;
import main.spot.Spot;

public class Bishop extends Piece {
    private boolean castlingDone = false;

    public Bishop(boolean white)
    {
        super(white, "Bishop");
    }

    public boolean isCastlingDone()
    {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone)
    {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end)
    {
        // we can't move the piece to a main.spot.Spot that
        // has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }

        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board,
                                    Spot start, Spot end)
    {

        if (this.isCastlingDone()) {
            return false;
        }
        return true;

        // Logic for returning true or false
    }

    public boolean isCastlingMove(Spot start, Spot end)
    {
        // check if the starting and
        // ending position are correct
        return true;
    }
}
