package BlackJackV1;


/**
 * Represents a card in a deck of cards
 *
 * @author Cody Brobston
 * @editedBy
 */
public class Card {

    /**
     *  One of the four enum Suit types
     */
    private Suit suit;

    /**
     * 1 -13, 1 is Ace, 13 is King
     */
    private int number;

    /**
     * Card constructor
     *  @param suit      enum type of card in class Suit
     * @param number    number to represent the value of the card*/
    public Card(Suit suit, int number) throws IndexOutOfBoundsException {

        this.suit = suit;

        if (number >= 1 && number <= 13) {
            this.number = number;
        } else {
            throw new IndexOutOfBoundsException("Card number must be between 1 and 13.");
        }
    }

    /**
     * retrieves the card value
     * @return      the card number
     */
    public int getNumber() {
        return number;
    }

    /**
     * The value of the card in word notaion
     * @return      the name of the card
     */
    @Override
    public String toString() {

        String cardName;

        switch(this.number) {

            case 1:
                cardName = "Ace";
                break;
            case 2:
                cardName = "Two";
                break;
            case 3:
                cardName = "Three";
                break;
            case 4:
                cardName = "Four";
                break;
            case 5:
                cardName = "Five";
                break;
            case 6:
                cardName = "Six";
                break;
            case 7:
                cardName = "Seven";
                break;
            case 8:
                cardName = "Eight";
                break;
            case 9:
                cardName = "Nine";
                break;
            case 10:
                cardName = "Ten";
                break;
            case 11:
                cardName = "Jack";
                break;
            case 12:
                cardName = "Queen";
                break;
            case 13:
                cardName = "King";
                break;
            default:
                cardName = "ERROR";
                break;
        }

        return cardName + " of " + this.suit.toString();
    }
}
