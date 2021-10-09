package main.piece;

import main.board.Board;
import main.spot.Spot;

public abstract class Piece {

    private boolean killed = false;
    private boolean white = false;
    private boolean hasMoved = false;
    private String name;

    public Piece(boolean white, String name) {
        this.setWhite(white);
        this.name = name;
    }

    public boolean isWhite() {

        return this.white;
    }

    public void setWhite(boolean white)
    {
        this.white = white;
    }

    public void setHasMoved() {
        this.hasMoved = true;
    }

    public boolean getHasMoved() {return this.hasMoved;}

    public boolean isKilled()
    {
        return this.killed;
    }

    public void setKilled(boolean killed)
    {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);

    @Override
    public String toString () {
        return this.name;
    }
}
