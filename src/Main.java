import main.piece.Bishop;
import main.player.HumanPlayer;
import main.player.Player;
import main.world.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bishop bishop = new Bishop(true);
        HumanPlayer gutti = new HumanPlayer(true);
        HumanPlayer me = new HumanPlayer(false);
        Game game = new Game();
        int x = 0;
        Scanner scanner = new Scanner(System.in);
        while(x == 0){
            x = scanner.nextInt();
            System.out.println("test");
        }

    }
}
