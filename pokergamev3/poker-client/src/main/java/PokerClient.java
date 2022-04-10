import java.io.*;
import java.net.*;
//import pokerclasses.*;

public class PokerClient {
    public Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private int idclient;
    //private Player player;


    public PokerClient(Socket s,int num){

        try{
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            client = s;
           // player = new Player();
            idclient = num-1;
        }catch(IOException e){
            System.out.println("[Server] Error initializing client");
        }
    }

    public int getIdclient() {
        return idclient;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public PrintWriter getOut() {
        return out;
    }

//    public Player getPlayer() {
//        return player;
//    }
}
