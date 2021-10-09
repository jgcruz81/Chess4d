package main.piece;

import main.board.Board;
import main.piece.Piece;
import main.spot.Spot;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white, "Pawn");
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // we can't move the piece to a main.spot.Spot that
        // has a piece of the same color
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }

        return false;
    }

}