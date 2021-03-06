package main.world;

import main.board.Board;
import main.move.Move;
import main.piece.King;
import main.piece.Piece;
import main.player.Player;
import main.spot.Spot;

import java.util.List;

public class Game {
    private Player[] players = new Player[2];
    private Board board;
    public Player currentTurn;
    private GameStatus status;
    //private List<Move> movesPlayed;

    public Game(Player p1, Player p2){
        this.board = new Board();
        this.initialize(p1,p2);
        this.board.printBoard();
    }

    private void initialize(Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }

        this.setStatus(GameStatus.ACTIVE);

        //movesPlayed.clear();
    }

    public boolean isEnd()
    {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(GameStatus status)
    {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player)
    {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        // if not current turn player
        if (player != currentTurn) {
            return false;
        }
        //if not your piece
        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // castling?
//        if (sourcePiece != null && sourcePiece instanceof King
//                && ((King) sourcePiece).isCastlingMove(move)) {
//            move.setCastlingMove(true);
//        }

        // store the move
        //movesPlayed.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);
        this.board.printBoard();

        if (destPiece != null && destPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
        }

        return true;

    }
}


