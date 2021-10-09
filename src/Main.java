import main.player.HumanPlayer;
import main.player.Player;
import main.world.Game;
import main.world.GameStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Intialization of game, players and move
         */

        HumanPlayer player1 = new HumanPlayer(true, "player1");
        HumanPlayer player2 = new HumanPlayer(false, "player2");
        Game game = new Game(player1, player2);
        Player mover = player1;

        while(game.getStatus() == GameStatus.ACTIVE ){
            while(mover.equals(game.currentTurn)) {
                /*
                 * While turn is true keep reading inputs to see if valid format then valid move
                 * After the while loop is complete next player's turn
                 *
                 * Expected input in format:
                 *    0011
                 * player will move piece at 00 to 11
                 */
                boolean turn = true;
                while(turn){
                    String move = dissectMove(game.currentTurn);
                    move = convertMovetoInts(move);
                    int a = Character.getNumericValue(move.charAt(0));
                    int b = Character.getNumericValue(move.charAt(1));
                    int c = Character.getNumericValue(move.charAt(2));
                    int d = Character.getNumericValue(move.charAt(3));
                    turn = !game.playerMove(mover, a, b, c, d);
                }

                if (mover == player1) {
                    mover = player2;
                } else {
                    mover = player1;
                }
            }
            //game.setStatus(GameStatus.FORFEIT);
        }

    }


    /***
     * Method takes in that currentPlayers input
     * @param currentPlayer - displays current player's name,
     * @return String -
     */
    public static String dissectMove(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        System.out.println(currentPlayer.toString() + "'s turn...");
        boolean input = true;
        while(input) {
            String move = scanner.nextLine();
            if (
                move.charAt(0) >= 97 && move.charAt(0) <= 102 &&
                Character.getNumericValue(move.charAt(1)) >= 1 && Character.getNumericValue(move.charAt(1)) <= 8 &&
                move.charAt(2) >= 97 && move.charAt(2) <= 102 &&
                Character.getNumericValue(move.charAt(3)) >= 1 && Character.getNumericValue(move.charAt(3)) <= 8
            ) {
                input = false;
                return move;
            } else {
                System.out.println("Invalid move, must be in the format of: a4b5");
            }
        }
        return "";
    }

    /***
     * Converts a1b2 move to string the computer can understand
     * @param move
     * @return
     */
    public static String convertMovetoInts(String move){
        int a = (int) move.charAt(0) - 97;
        int b = Character.getNumericValue(move.charAt(1)) - 1;
        int c = (int) move.charAt(2) -97;
        int d = Character.getNumericValue(move.charAt(3)) - 1;
        String combinedString = String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d);
        return combinedString;
    }
}
