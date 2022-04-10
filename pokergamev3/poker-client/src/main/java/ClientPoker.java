import java.io.*;
import java.util.Scanner;
//import pokerclasses.*;

public class ClientPoker {

    private static Client2 server;
    //private static Player player;
    private static Scanner sc;
    private static String name;

    public static void main(String[] args){
        System.out.println("---------------------");
        System.out.println("| Poker Client v1.3 |");
        System.out.println("---------------------");

        String hostName = "localhost";
        int portNumber = 4444;

        sc = new Scanner(System.in);

        System.out.print("Enter server name: ");
        hostName = sc.next();

                /*System.out.print("Enter your name: ");
                name = sc.next();*/

        server = new Client2(hostName,portNumber);
        //server.tell(name);
        System.out.printf("Connected to server %s\n",server.address);
        //player = new Player();

    }

}
