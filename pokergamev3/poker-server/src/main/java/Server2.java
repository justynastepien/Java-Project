import java.io.*;
import java.net.*;

public class Server2 {
    private static ServerSocket socket;

    public static void main(String[] args){
        System.out.println("---------------------");
        System.out.println("| Poker Server v1.3 |");
        System.out.println("---------------------");

        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            socket = serverSocket;


            // Listen for clients
            while (true) {
                System.out.println("[PokerServer] awaiting connection...");

            }

        } catch (IOException e) {
            System.err.println("[PokerServer] Could not listen on port 4444");
            System.exit(-1);
        }
        Client2 a = getClient();
        //a.player.getPlayer_deck();
    }

//    public void run(){
//
//    }

    public static Client2 getClient(){
        Client2 a = null;
        try{
            a = new Client2(socket.accept());
            System.out.println("[PokerServer] Client accepted.");
        } catch (IOException e) {
            System.out.println("[PokerServer] Unable to accept client!");
        }
        return a;
    }
}

