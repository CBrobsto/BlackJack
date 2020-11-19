package BlackJackV1;

/**
 * Tester class separate from the game runner. Test code for the ConsoleRunner here.
 *
 * @author Cody Brobston
 * @editedBy
 */
public class Tester {
    public static void main(String[] args) {
        Deck testDeck1 = new Deck(1,true);

        Player test = new Player("Test");

        test.addCard(testDeck1.dealCard());
        test.addCard(testDeck1.dealCard());

        test.printHand(false);
    }
}
