package BlackJackV1;

import java.util.ArrayList;

/**
 * Represents a player in the game, including a dealer
 *
 * @author Cody Brobston
 * @editedBy
 */
public class Player {

    /**
     * Name of the player
     */
    private String name;

    /**
     *  The number of cards in a player's hand
     */
    private int numCards;

    /**
     * ArrayList of cards representing the player's hand
     */
    private ArrayList<Card> hand = new ArrayList<>();

    /**
     * Constructor
     * @param name      The name of the player
     */
    public Player(String name) {
        this.name = name;

        numCards = 0;

        this.emptyHand();
    }

    /**
     * Empties the hand of the player
     */
    public void emptyHand() {
        this.hand.clear();
    }

    /**
     * Adds a card to the players hand and increases the number of cards in their hand
     * @param card      The card added to the player's hand
     * @return          true if the sum of the player's hand is less than or equal to 21
     */
    public boolean addCard(Card card) {

        this.hand.add(card);
        numCards++;

        return (this.getSum() <= 21);
    }

    /**
     * Calculates the sum of the players hand
     * @return      Sum of the value of the cards in the player's hand
     */
    public int getSum() {

        int numAces = 0;
        int sum = 0;
        int cardNum;

        for (Card card : hand) {
            cardNum = card.getNumber();

            // Aces can be valued as either 1 or 11
            if (cardNum == 1) {
                numAces++;
                sum += 11;
            } else if (cardNum > 10) {
                sum += 10;
            } else {
                sum += cardNum;
            }
        }

        while (sum > 21 && numAces > 0) {
            sum -= 10;
            numAces--;
        }
        return sum;
    }

    /**
     * Prints the hand of the player formatted as such: [a, b, c, d]
     * @param showFirst     True to print the first card, false to print "face-down" for the first card
     */
    public void printHand(boolean showFirst) {
        System.out.printf("%s's hand:\n", this.name.toString());
        System.out.print("\t[");
        for (int i=0; i<this.numCards; i++) {
            if (i == 0 && !showFirst) {
                System.out.print("face-down, ");
            } else if (i == this.numCards - 1) {
                System.out.println(this.hand.get(i) + "]");
            }
            else {
                System.out.print(this.hand.get(i) + ", ");
            }
        }
    }
}
