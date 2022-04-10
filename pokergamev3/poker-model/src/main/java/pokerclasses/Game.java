package pokerclasses;

import java.util.*;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private int table;
    private static int ante = 2;
    private Player[]players = new Player[4];


    public Game(){}
    public Game(Player[] playersx){
        this.players = playersx;
        table = 0;
    }

    public int getTable() {
        return table;
    }

    public void pick_ante(){
        for(Player e: players){
            if(e.isGra() == true)
                if(e.getMoney() >= ante){
                    e.give_money(ante);
                    table += ante;
            }
            else if(e.getMoney() < ante){
                e.setPass(false);
                }
        }
    }

    public void exchange (Player player, int n, Deck deck) {   //player i ile kart chcę wymienić dla danego playera
        int i = 0;
        int[] tab = new int[n];
        Card cardb = new Card();
        Scanner scan = new Scanner(System.in);
        while (i < n) {
            System.out.println("Ktora karte chcesz wymienic?");
            int karta = scan.nextInt();
            tab[i] = karta-1;
            i++;
        }
        Arrays.sort(tab);
        for(int j=tab.length-1; j>=0; j--){
                    player.remove_from_deck(tab[j]);
                    deck.give_one_card(player,tab[j]);
            }
    }

    public void bet (Player player, int n){ //postawione pieniadze
        //Scanner scan = new Scanner(System.in);
        player.give_money(n);
        player.add_to_table(n);
        table = table + n;
    }
    //System.out.println(Card.Rank.FOUR.getValues()+ " "+ Card.Rank.QUEEN.getValues());

    public Card higher_Card(ArrayList<Card> deckp){
        int v = 0;
        Card cardb = new Card();
        for(Card card : deckp){
            if((card.getRank()).getValues() > v) {
                v = (card.getRank()).getValues();
                cardb = card;
            }
        }
        return cardb;
    }

    public Card pair(ArrayList<Card> deckp){
        int v = 0;
        Card cardb = new Card();
        for(int i=0; i<deckp.size();i++)
            for(int j=i+1; j<deckp.size(); j++){
                if(deckp.get(i).getRank().getValues() == deckp.get(j).getRank().getValues() && deckp.get(i).getRank().getValues() > v){
                    v = deckp.get(i).getRank().getValues();
                    cardb = deckp.get(i);
                }
            }
        if(v==0)
            return null;

        return cardb;
    }

    public Card two_Pairs(ArrayList<Card> deckp){

        Card cardb = this.pair(deckp);
        if(cardb == null)
            return null;

        //v = cardb.getRank().getValues();
        for(int i=0; i<5; i++){
            if(deckp.get(i).equals(cardb)){
                deckp.remove(i);
            break;
            }
        }
        Card cardk = this.pair(deckp);
         if(cardk == null)
             return null;

         if(cardb.getRank().getValues() >= cardk.getRank().getValues())
             return cardb;

         return cardk;
    }

    public Card three(ArrayList<Card> deckp){
        if(this.pair(deckp) == null) return null;
        Card cardb;

        for(int i=0; i<3; i++)
            for(int j=i+1; j<4; j++)
                for(int k=j+1; k<5; k++){
                    if(deckp.get(i).getRank().getValues() == deckp.get(j).getRank().getValues() && deckp.get(i).getRank().getValues() == deckp.get(k).getRank().getValues()) {
                        cardb = deckp.get(i);
                        return cardb;
                    }
                }
        return null;
    }

    public Card streat(ArrayList<Card> deckp){
        Card cardb = new Card();

        for (int i = 0; i < deckp.size() - 1; i++)
            for (int j = 0; j < deckp.size() - 1; j++){
                if(deckp.get(j).getRank().getValues() > deckp.get(j+1).getRank().getValues()){
                    Collections.swap(deckp,j, j+1);
                }
            }
        if(deckp.get(4).getRank().getValues()==14 && deckp.get(0).getRank().getValues()==2 && deckp.get(1).getRank().getValues()==3 && deckp.get(2).getRank().getValues()==4 && deckp.get(3).getRank().getValues()==5){
            cardb = deckp.get(3);
            return cardb;
        }
        int  previous = deckp.get(0).getRank().getValues();
        for(int i=1; i<5;i++){
            if(deckp.get(i).getRank().getValues() == previous +1){
                previous = deckp.get(i).getRank().getValues();
                continue;
            }
            else
                return null;
        }
        cardb = deckp.get(4);
        return cardb;

    }
    public Card colour(ArrayList<Card> deckp){
        Card cardb = deckp.get(0);

        for(Card e : deckp){
            if(cardb.getSuit().equals(e.getSuit())){
                continue;
            }
            return null;
        }

        cardb = deckp.get(4);
        return cardb;
    }
    public Card full(ArrayList<Card> deckp){
        Card cardb = this.three(deckp);
        if(cardb == null)
            return  null;
        for(int i=0; i< deckp.size();i++){
            if(deckp.get(i).getRank().getValues()==cardb.getRank().getValues()){
                deckp.remove(i);
            }
        }
        Card b = this.pair(deckp);
        if(b == null)
            return null;
        return cardb;
    }
    public Card carets(ArrayList<Card> deckp) {
        for(int i=0; i<2; i++)
            for(int j=i+1; j<3; j++)
                for(int k=j+1; k<4; k++)
                    for(int l=k+1; l<5; l++) {
                        if(deckp.get(i).getRank().getValues() == deckp.get(j).getRank().getValues() &&
                                deckp.get(i).getRank().getValues() == deckp.get(k).getRank().getValues() &&
                                deckp.get(i).getRank().getValues() == deckp.get(k).getRank().getValues()) {
                            return deckp.get(i);
                        }
                    }
        return null;
    }
    public Card poker(ArrayList<Card> deckp){
        Card cardb = this.streat(deckp);
        if(cardb == null)
            return null;
        if(this.colour(deckp) == null)
            return null;
        return cardb;
    }

    public Player checking (){
        ArrayList<Card> deckp;
        Player bestPlayer = new Player();
        int best=0;
        Card cardb;
        int[] tab = {0,0,0,0};

        for(Player player : players){
            deckp = player.getPlayer_deck();

            if(this.poker(deckp) != null){
                cardb = this.poker(deckp);
                player.setUkladzik("Poker", cardb, 9);
                continue;
            }

            if(this.carets(deckp) != null){
                cardb = this.carets(deckp);
                player.setUkladzik("Carets", cardb, 8);
                continue;
            }

            if(this.full(deckp) != null){
                cardb = this.full(deckp);
                player.setUkladzik("Full", cardb, 7);
                continue;
            }

            if(this.colour(deckp) != null){
                cardb = this.colour(deckp);
                player.setUkladzik("Colour", cardb, 6);
                continue;
            }

            if(this.streat(deckp) != null){
                cardb = this.streat(deckp);
                player.setUkladzik("Streat", cardb, 5);
                continue;
            }

            if(this.three(deckp) != null){
                cardb = this.three(deckp);
                player.setUkladzik("Three", cardb, 4);
                continue;
            }

            if(this.two_Pairs(deckp) != null){
                cardb = this.two_Pairs(deckp);
                player.setUkladzik("TwoPairs", cardb, 3);
                continue;
            }

            if(this.pair(deckp) != null){
                cardb = this.pair(deckp);
                player.setUkladzik("Pair", cardb, 2);
                continue;
            }

            if(this.higher_Card(deckp) != null){
                cardb = this.higher_Card(deckp);
                player.setUkladzik("HigherCard", cardb, 1);
                continue;
            }
        }
        int p = 0;
        for(Player player : players){
            tab[p] = player.getIdUklad(); p++;
            if(player.getIdUklad()>best){
                bestPlayer = player;
                best = player.getIdUklad();
            }
        }
        for(int i = 0; i<4; i++){
            if(tab[i]==best){
                if(players[i].getBestcard().getRank().getValues() > bestPlayer.getBestcard().getRank().getValues()){
                    bestPlayer = players[i];
                }
            }
        }
        return bestPlayer;

    }

}
