package main.board;

import main.piece.*;
import main.spot.Spot;

import java.util.Locale;

public class Board {
    Spot[][] boxes = new Spot[8][8];

    public Board()
    {
        this.resetBoard();
    }

    public Spot getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return boxes[x][y];
    }

    public void resetBoard()
    {
        // initialize white pieces
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[1][0] = new Spot(1, 0, new Knight(true));
        boxes[2][0] = new Spot(2, 0, new Bishop(true));
        boxes[3][0] = new Spot(3, 0, new Queen(true));
        boxes[4][0] = new Spot(4, 0, new King(true));
        boxes[5][0] = new Spot(5, 0, new Bishop(true));
        boxes[6][0] = new Spot(6, 0, new Knight(true));
        boxes[7][0] = new Spot(7, 0, new Rook(true));
        //...
        boxes[0][1] = new Spot(0, 1, new Pawn(true));
        boxes[1][1] = new Spot(1, 1, new Pawn(true));
        boxes[2][1] = new Spot(2, 1, new Pawn(true));
        boxes[3][1] = new Spot(3, 1, new Pawn(true));
        boxes[4][1] = new Spot(4, 1, new Pawn(true));
        boxes[5][1] = new Spot(5, 1, new Pawn(true));
        boxes[6][1] = new Spot(6, 1, new Pawn(true));
        boxes[7][1] = new Spot(7, 1, new Pawn(true));
        //...
        // initialize black pieces
        boxes[0][7] = new Spot(0, 7, new Rook(false));
        boxes[1][7] = new Spot(1, 7, new Knight(false));
        boxes[2][7] = new Spot(2, 7, new Bishop(false));
        boxes[3][7] = new Spot(3, 7, new Queen(false));
        boxes[4][7] = new Spot(4, 7, new King(false));
        boxes[5][7] = new Spot(5, 7, new Bishop(false));
        boxes[6][7] = new Spot(6, 7, new Knight(false));
        boxes[7][7] = new Spot(7, 7, new Rook(false));
        //...
        boxes[0][6] = new Spot(0, 6, new Pawn(false));
        boxes[1][6] = new Spot(1, 6, new Pawn(false));
        boxes[2][6] = new Spot(2, 6, new Pawn(false));
        boxes[3][6] = new Spot(3, 6, new Pawn(false));
        boxes[4][6] = new Spot(4, 6, new Pawn(false));
        boxes[5][6] = new Spot(5, 6, new Pawn(false));
        boxes[6][6] = new Spot(6, 6, new Pawn(false));
        boxes[7][6] = new Spot(7, 6, new Pawn(false));
        //...

        // initialize remaining boxes without any piece
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
    }

    /**
     * Prints out board with row being inner, column being outer.
     */
    public void printBoard(){
        for(int i = 7; i >= 0; i--){
            for(int j = 0; j < 8; j++) {
                if (boxes[j][i].getPiece() != null) {
                    printPiece(boxes[j][i].getPiece());
                } else {
                    System.out.print('_');
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints given piece by first char, while taking into account King and Knight.
     * @param piece
     */
    public void printPiece(Piece piece) {
        if(piece.toString().charAt(0) == 'K') {
            //Check for King or Knight piece
            if(piece.toString().equals("King")) {
                if(piece.isWhite()){
                    System.out.print("K");
                } else {
                    System.out.print("k");
                }
            //Knight
            } else {
                if(piece.isWhite()){
                    System.out.print("N");
                } else {
                    System.out.print("n");
                }
            }
        //rest of pieces
        } else {
            if (piece.isWhite()) {
                System.out.print(piece.toString().charAt(0));
            } else {
                String placeholder = piece.toString();
                placeholder = placeholder.toLowerCase(Locale.ROOT);
                System.out.print(placeholder.charAt(0));
            }
        }
    }
    public boolean kingInDanger(){
        return false;
    }

}
