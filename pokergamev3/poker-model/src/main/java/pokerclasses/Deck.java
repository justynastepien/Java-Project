package pokerclasses;

import java.util.ArrayList;


/**
 * Klasa reprezentująca talię kart
 * @version 1.0
 * @author Justyna Stępień
 * */
public class Deck {
    private Card theCard;
    private ArrayList<Card> deck = new ArrayList<Card>();
    /*public Deck()
    {
        theCard = new Card();
    }*/

    //ArrayList<Card> Player1=new ArrayList<Card>();
    //ArrayList<Card> Player2=new ArrayList<Card>();
    //ArrayList<Card> Player3=new ArrayList<Card>();
    //ArrayList<Card> Player4=new ArrayList<Card>();




    public Deck() {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                deck.add(new Card(rank, suit));
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void fabryki(Deck deck) {
        deck = new Deck();
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int index = (int) (Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
        }
    }

    public void give_one_card(Player player,int karta) {
        player.add_to_deck(deck.get(0), karta);
        deck.remove(0);
    }

    public void deal(Player player) {
        //this.shuffle();
        for (int i = 0; i < 5; i++) {
            player.add_to_deck(deck.get(0),i);
            deck.remove(0);
        }
    }
}