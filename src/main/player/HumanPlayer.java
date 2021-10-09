package main.player;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(boolean whiteSide, String name)
    {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}