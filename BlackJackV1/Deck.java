package BlackJackV1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of cards
 *
 * @author Cody Brobston
 * @editedBy
 */
public class Deck {

    /**
     *  number of cards in the deck
     */
    private int numCards;

    /**
     *  ArrayList of type Card to represent a deck of cards
     */
    private ArrayList<Card> deck;

    /**
     *  Default constructor to make one, unshuffled deck
     */
    public Deck() {
        this(1, false);
    }

    /**
     * Constructor
     * @param numDeck       number of decks to be used
     * @param shuffle      boolean if deck should be shuffled or not
     */
    public Deck(int numDeck, boolean shuffle) {

        // 52 is the standard number of cards in a deck
        this.numCards = numDeck * 52;

        // create an arrayList of the size specified by the number of cards
        this.deck = new ArrayList<>(this.numCards);

        // for each deck
        for (int i=0; i < numDeck; i++) {

            // for each suit
            for (int j=0; j < 4; j++) {

                // for each number
                for (int k=1; k <= 13; k++) {

                    this.deck.add(new Card(Suit.values()[j], k));
                }
            }
        }

        // if constructor wants a shuffled deck, call shuffle method
        if (shuffle) {
            shuffle();
        }

    }

    /**
     *  Shuffles the cards in the deck
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    /**
     * deals the card on the top of the deck
     * @return      the top card
     */
    public Card dealCard() {

        Card top = this.deck.get(0);

        this.deck.remove(0);

        this.numCards--;

        return top;
    }

    /**
     * prints the deck of cards (for testing purposes)
     */
    public void printDeck(){
        for (Card i: this.deck) {
            System.out.println(i);
        }
        System.out.println("\nThe number of cards in the deck is: " + this.numCards);
    }
}
