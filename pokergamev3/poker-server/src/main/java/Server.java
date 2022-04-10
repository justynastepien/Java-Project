import java.io.*;
import java.net.*;
import java.util.ArrayList;
import pokerclasses.*;

public class Server {
    public static int PORT = 9000;
    private ServerSocket socket;
    private int numOfPlayers = 0;
    private Player[] players = new Player[4];
    public ArrayList<PokerClient> clients = new ArrayList<PokerClient>();

    public Server() {
        if (!createServerSocket()) System.exit(1);
        waitForClients();
    }

    private boolean createServerSocket() {
        try {
            socket = new ServerSocket(PORT);
            System.out.println("Utworzono gniazdo serwera, port: " + PORT);
            return true;
        } catch (IOException e) {
            System.err.println("Blad tworzenia gniazda, port: " + PORT + ". " + e);
            return false;
        }
    }

    public void waitForClients() {
        try {
            while (numOfPlayers < 4) {
                Socket client = socket.accept();
                System.out.println(client.getInetAddress().getHostAddress());
                System.out.println("Zgłoszenie z: " + client.getInetAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                //new NetReader(client, in, out).start();

                numOfPlayers++;
                PokerClient pom = new PokerClient(client, numOfPlayers);
                clients.add(pom);
                String msg = in.readLine();
                if(msg.equals("2")){
                    clients.remove(pom);
                    numOfPlayers-=1;
                }

            }
           // this.run();
        } catch (IOException e) {
            System.err.println(e + ". Exiting.");
            System.exit(2);
        }
    }

    public void showCards(Game game){
        for(int i=0; i<4;i++){
            int money = players[clients.get(i).getIdclient()].getMoney();
            clients.get(i).getOut().println(money);
            String tal = players[clients.get(i).getIdclient()].show_deck();
            clients.get(i).getOut().println(tal);
            int table = game.getTable();
            clients.get(i).getOut().println(table);
        }
    }

    public void printToEveryone (String a){
        for(int i=0; i<4;i++){
            clients.get(i).getOut().println(a);
    }
    }

    public void run() {
        //clients.get(0).getOut().println("bla bla");
        //clients.get(1).getOut().println("bla bla");
        // clients.get(2).getOut().println("bla bla");
        //clients.get(3).getOut().println("bla bla");

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;

        Game game = new Game(players);
        Deck deck = new Deck();

        //while (true) {
            deck.shuffle();
            for (Player player : players)
                deck.deal(player);

            game.pick_ante();
            printToEveryone("Ante was picked");

            showCards(game);
            printToEveryone("How many cards do you want to change?");

            for(PokerClient client : clients){
                try{
                String a = client.getIn().readLine();
                }catch (IOException e) {
                System.out.println(e);
                return;}
            }

    }
}
