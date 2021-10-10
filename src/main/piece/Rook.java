package main.piece;

import main.board.Board;
import main.piece.Piece;
import main.spot.Spot;

public class Rook extends Piece {

    public Rook(boolean white)
    {
        super(white, "Rook");
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end)
    {
        // we can't move the piece to a main.spot.Spot that
        // has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        // check if move is valid for rook
        // check if this move will not result in the king being attacked
        // if so return true
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (((x > 0 && y == 0) || (x == 0 && y > 0)) && !board.kingInDanger() && !passesThrough(board, start, end)) {
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
                end.getPiece().toString().equals("King")
        ) {
            return true;
        }
        return false;
    }

    /***
     * Method to see if piece passes through another piece(invalid move).
     * @param board
     * @param start
     * @param end
     * @return boolean that corresponds with either unobstructed or obstructed path to destination.
     */
    public boolean passesThrough(Board board, Spot start, Spot end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        //If left/right movement
        if (x > 0) {
            for(int i = 1; i < x; i++ ) {
                //if left movement
                //(1,0) <- (3,0)
                if(start.getX() > end.getX() && board.getBox(start.getX()-i,start.getY()).getPiece() != null) {
                    return true;
                }
                //if right movement
                //(3,0) -> (5,0)
                if(start.getX() < end.getX() && board.getBox(start.getX()+i,start.getY()).getPiece() != null){
                    return true;
                }
            }
        //if up/down movement
        } else if (y > 0) {
            for(int i = 1; i < y; i++ ) {
                //if down movement
                //(3,5) -> (3,1)
                if(start.getY() > end.getY() && board.getBox(start.getX(),start.getY()-i).getPiece() != null) {
                    return true;
                }
                //if up movement
                //(2,4) -> (2,7)
                if(start.getY() < end.getY() && board.getBox(start.getX(),start.getY()+i).getPiece() != null){
                    return true;
                }
            }
        }
        return false;
    }
}
