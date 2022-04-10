//import org.junit.Test;
import org.junit.jupiter.api.Test;
import pokerclasses.Card;
import pokerclasses.Game;
import pokerclasses.Player;

import static junit.framework.TestCase.assertEquals;

public class TestPoker {
    private final pokerclasses.Game junit = new Game();
    //private final pokerclasses.Player player = new Player();
    @Test
    void higher_CardTest(){
        Player player = new Player(new Card(Card.Rank.QUEEN, Card.Suit.Karo), new Card(Card.Rank.JACK, Card.Suit.Karo) , new Card(Card.Rank.SEVEN, Card.Suit.Karo), new Card(Card.Rank.QUEEN, Card.Suit.Kier),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(14, junit.higher_Card(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void pairTest(){
        Player player = new Player(new Card(Card.Rank.KING, Card.Suit.Karo), new Card(Card.Rank.JACK, Card.Suit.Karo) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Kier),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(14, junit.pair(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void twopairsTest(){
        Player player = new Player(new Card(Card.Rank.KING, Card.Suit.Karo), new Card(Card.Rank.JACK, Card.Suit.Karo) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Kier),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(14, junit.two_Pairs(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void threeTest(){
        Player player = new Player(new Card(Card.Rank.KING, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Kier) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Trefl),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(13, junit.three(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void streatTest(){
        Player player = new Player(new Card(Card.Rank.TWO, Card.Suit.Karo), new Card(Card.Rank.THREE, Card.Suit.Kier) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.FOUR, Card.Suit.Trefl),new Card(Card.Rank.FIFE, Card.Suit.Trefl));
        assertEquals(5, junit.streat(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void colourTest(){
        Player player = new Player(new Card(Card.Rank.TWO, Card.Suit.Karo), new Card(Card.Rank.THREE, Card.Suit.Karo) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.FOUR, Card.Suit.Karo),new Card(Card.Rank.FIFE, Card.Suit.Karo));
        assertEquals(5, junit.colour(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void fullTest(){
        Player player = new Player(new Card(Card.Rank.KING, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Kier) , new Card(Card.Rank.ACE, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Trefl),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(13, junit.full(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void caretsTest(){
        Player player = new Player(new Card(Card.Rank.KING, Card.Suit.Karo), new Card(Card.Rank.KING, Card.Suit.Kier) , new Card(Card.Rank.KING, Card.Suit.Pik), new Card(Card.Rank.KING, Card.Suit.Trefl),new Card(Card.Rank.ACE, Card.Suit.Trefl));
        assertEquals(13, junit.carets(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void pokerTest(){
        Player player = new Player(new Card(Card.Rank.TWO, Card.Suit.Trefl), new Card(Card.Rank.THREE, Card.Suit.Trefl) , new Card(Card.Rank.ACE, Card.Suit.Trefl), new Card(Card.Rank.FOUR, Card.Suit.Trefl),new Card(Card.Rank.FIFE, Card.Suit.Trefl));
        assertEquals(5, junit.poker(player.getPlayer_deck()).getRank().getValues());
    }

    @Test
    void checkingTest(){
        Player player1 = new Player(new Card(Card.Rank.TWO, Card.Suit.Trefl), new Card(Card.Rank.THREE, Card.Suit.Trefl) , new Card(Card.Rank.ACE, Card.Suit.Trefl), new Card(Card.Rank.FOUR, Card.Suit.Trefl),new Card(Card.Rank.FIFE, Card.Suit.Trefl));
        Player player2 = new Player(new Card(Card.Rank.NINE, Card.Suit.Trefl), new Card(Card.Rank.TEN, Card.Suit.Trefl) , new Card(Card.Rank.JACK, Card.Suit.Trefl), new Card(Card.Rank.QUEEN, Card.Suit.Trefl),new Card(Card.Rank.KING, Card.Suit.Trefl));
        Player player3 = new Player(new Card(Card.Rank.TWO, Card.Suit.Trefl), new Card(Card.Rank.SIX, Card.Suit.Pik) , new Card(Card.Rank.ACE, Card.Suit.Trefl), new Card(Card.Rank.FOUR, Card.Suit.Trefl),new Card(Card.Rank.FIFE, Card.Suit.Trefl));
        Player player4 = new Player(new Card(Card.Rank.TWO, Card.Suit.Trefl), new Card(Card.Rank.SEVEN, Card.Suit.Trefl) , new Card(Card.Rank.ACE, Card.Suit.Trefl), new Card(Card.Rank.FOUR, Card.Suit.Trefl),new Card(Card.Rank.FIFE, Card.Suit.Trefl));

        Player[] players = new Player[4];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        Game game = new Game(players);
        assertEquals(player2,game.checking());

    }

}
