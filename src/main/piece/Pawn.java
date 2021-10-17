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

        //check to see if white moves in positive direction
        int y = end.getY() - start.getY();
        if(this.isWhite() && y < 0){
            return false;
        }
        //check to see if black moves in negative direction
        if(!this.isWhite() && y > 0)  {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        y = Math.abs(start.getY() - end.getY());
        //check to
        // check if this move will NOT result in the king
        // being attacked if so return true
        if (!this.getHasMoved() && y == 2 && x == 0 && !board.kingInDanger()) {
            this.setHasMoved();
            return true;
        }
        if (((y == 1 && x == 0) || x + y == 2 ) && !board.kingInDanger()) {
            this.setHasMoved();
            return true;
        }
        return false;
    }



}