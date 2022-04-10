package pokerclasses;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> player_deck=new ArrayList<Card>();
    private int money; //ilość posiadanych pieniędzy
    private boolean gra = true; //czy dany gracz bierze udział w rozgrywce
    private boolean pass;
    private int table ; //na stole przez gracza
    private String uklad;
    private Card bestcard;
    private int idUklad;

    public Player(){
        this.money = 100;
        this.table = 0;
        pass = true;
    }

    public Player(Card a,Card b,Card c,Card d, Card e){
        player_deck.add(a);
        player_deck.add(b);
        player_deck.add(c);
        player_deck.add(d);
        player_deck.add(e);
    }

    public String getUklad(){
        return uklad;
    }
    public Card getBestcard(){
        return bestcard;
    }

    public int getIdUklad() {
        return idUklad;
    }

    public int getTable() {
        return table;
    }

    public boolean isGra() {
        return gra;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Card> getPlayer_deck() {
        return player_deck;
    }

    public void give_money(int n){
        money = money - n;
    }

    //przy rozdawaniu
    public void add_to_deck(Card card, int karta){
        player_deck.add(karta,card);
    }

    public void remove_from_deck(int karta){
        player_deck.remove(karta);
    }

    public void add_to_table(int n){
        this.table = this.table +n;
    }

    public String show_deck(){
        String temp = new String();
        String all = new String();

        for(Card e : player_deck){
            //System.out.println(e.getRank().toString() + " " + e.getSuit().toString());
            temp = e.getRank().toString() + " " + e.getSuit().toString();
            all = all + " | " +temp;
        }
        return all;
    }

    public void setUkladzik (String ukladx, Card bestcardx, int iduklad){
        this.uklad = ukladx;
        this.bestcard = bestcardx;
        this.idUklad = iduklad;
    }
}
