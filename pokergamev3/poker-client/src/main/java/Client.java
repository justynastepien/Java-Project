//import pokerclasses.Game;
//import pokerclasses.Player;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static void showStartInterface(){
        System.out.println("|--------POKER---------|");
        System.out.println();
        System.out.println("Play game [1]");
        System.out.println("Exit [2]");
    }

    private static void showInterface(String money,String deck,String table){
        System.out.println("Money on the table: " + table);
        System.out.println("Your money: " + money);
        System.out.println();
        System.out.println("Your cards : " + deck);
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        String host = "localhost";
        if (args.length > 0)
            host = args[0];
        Socket socket;
        try {
            socket = new Socket(host, 9000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            //setIn(in);
            Scanner scan = new Scanner(System.in);
//            String firstname = scan.nextLine();
//            out.println(firstname);
//            //System.out.println(server.);
//            System.out.println("Sent: PING");
            showStartInterface();
            int gamemode = scan.nextInt();
            scan.nextInt();
//            if(gamemode == 2)
//                socket.close();

            String msg = in.readLine();
            System.out.println(msg);

            System.out.println();

            String money = in.readLine();
            String deck = in.readLine();
            String table = in.readLine();
            showInterface(money,deck,table);

            System.out.println();

            msg = in.readLine();
            System.out.println(msg);

            System.out.println();

            int num = scan.nextInt();
            scan.nextInt();
            //String msg = in.readLine();
            //System.out.println("Received: " + msg);
            //socket.close();
            //while(true);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
