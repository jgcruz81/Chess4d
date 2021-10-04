import main.piece.Bishop;
import main.player.HumanPlayer;
import main.player.Player;
import main.world.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Intialization of needed game, players and move
         */

        HumanPlayer gutti = new HumanPlayer(true);
        HumanPlayer me = new HumanPlayer(false);
        Game game = new Game(gutti, me);
        String move = "1";
        Scanner scanner = new Scanner(System.in);

        Player mover = gutti;
        while(move != "0"){
            /*
            Expected input in format:
                0011
            player will move piece at 00 to 11
             */
            //x = scanner.nextLine();
            move = "1030";
            while(!dissectMove(move)){
                System.out.println("Invalid move, must be in the format of: 0123");
                move = scanner.nextLine();
            }

            int a = Character.getNumericValue(move.charAt(0));
            int b = Character.getNumericValue(move.charAt(1));
            int c = Character.getNumericValue(move.charAt(2));
            int d = Character.getNumericValue(move.charAt(3));
            boolean placeholder = game.playerMove(mover, a, b, c, d);
            if(!placeholder){
                System.out.println("Please enter a valid move");
                break;
            }


            placeholder = game.playerMove(me, a, b, c, d);
            if(mover == gutti){
                mover = me;
            }else{
                mover = gutti;
            }

        }

    }

    public static boolean dissectMove(String move){
        return true;
    }
}
