package main.piece;

import main.board.Board;
import main.piece.Piece;
import main.spot.Spot;

public class King extends Piece {

    public King(boolean white)
    {
        super(white,"King");
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end)
    {
        // we can't move the piece to a main.spot.Spot that
        // has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        //check to see if move is valid for king
        // check if this move will not result in the king being attacked
        // if so return true
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1 && !board.kingInDanger()) {
            this.setHasMoved();
            return true;
        }
        //return this.isValidCastling(board, start, end);
        return false;
    }

    private boolean isValidCastling(Board board, Spot start, Spot end) {

        if (!this.getHasMoved() &&
            end.getPiece() != null &&
            end.getPiece().isWhite() == this.isWhite() &&
            !end.getPiece().getHasMoved() &&
            end.getPiece().toString().equals("Rook")
        ) {
            return true;
        }
        return false;
    }
}
