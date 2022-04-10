package pokerclasses;
import java.util.*;
import java.io.IOException;

public class Main {

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public static void main(String[] args) throws IOException {
        showStartInterface();
        Scanner scan = new Scanner(System.in);
        int gameMode= scan.nextInt();



        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player[] players = new Player[4];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        Game game = new Game(players);
        Deck deck = new Deck();

        deck.shuffle();
        for(Player player : players)
            deck.deal(player);

        while(true){
            for(Player player : players)
                showInterface(player,game);

            game.pick_ante();
            System.out.println("Ante was picked");

            for(Player player : players){
                showInterface(player,game);
                System.out.println("How many cards do you want to change?");
                int number = scan.nextInt();
                game.exchange(player,number,deck);
                showInterface(player,game);
           }

            for(int i=0; i<2;i++){
                for(Player player : players){
                    if(player.isGra()==true)
                        if(player.isPass() == true){
                            showInterface(player,game);
                            System.out.println("[1] to pass");
                            System.out.println("[2] to bet");
                            System.out.println();
                            int to = scan.nextInt();
                             if(to == 1)
                                player.setPass(false);
                             else if(to == 2){
                                 System.out.println("How much?");
                                 int cash = scan.nextInt();
                                 game.bet(player,cash);
                             }
                        }
                }
            }

            break;
        }

    }

    private static void showStartInterface(){
        System.out.println("|--------POKER---------|");
        System.out.println();
        System.out.println("Play game [1]");
    }

    private static void showInterface(Player player,Game game){
        System.out.println("Money on the table: " + game.getTable());
        System.out.println("Your money: " + player.getMoney());
        System.out.println();
        System.out.println("Your cards : " ); player.show_deck();
        System.out.println();
        System.out.println();
    }


}
