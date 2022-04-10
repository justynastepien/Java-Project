package pokerclasses;

/**
 * Klasa reprezentującą kartę
 * @version 1.0
 * @author Justyna Stępień
 */
public class Card {

    private Rank rank;
    private Suit suit;

    public enum Rank
    {   ACE("ACE", 14),
        KING("KING", 13),
        QUEEN("QUEEN", 12),
        JACK("JACK", 11),
        TEN("TEN", 10),
        NINE("NINE", 9),
        EIGHT("EIGHT", 8),
        SEVEN("SEVEN", 7),
        SIX("SIX", 6),
        FIFE("FIFE", 5),
        FOUR("FOUR", 4),
        THREE("THREE", 3),
        TWO("TWO", 2);
        private int values;
        private String rank;
        Rank(String rank, int values)
        {
            this.values = values;
            this.rank = rank;
        }

        public int getValues() {
            return values;
        }
    }

    public enum Suit
    {
        Trefl("Trefl",2),
        Pik("Pik",1),
        Karo("Karo",3),
        Kier("Kier",4);

        int values;
        String suit;
        Suit(String suit, int values)
        {
            this.values = values;
            this.suit = suit;
        }

        public int getValues() {
            return values;
        }
    }


    public Card() {
    }

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
}