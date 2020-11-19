package BlackJackV1;

import java.util.Scanner;

/**
 * Runs a game of BlackJack in the console. Supports one user and a dealer. No betting or multiple games implemented
 * yet.
 *
 * @author Cody Brobston
 * @editedBy
 */
public class ConsoleRunner {
    public static void main(String[] args) {

        // init input Scanner
        Scanner scan = new Scanner(System.in);

        // init deck of cards
        Deck deck = new Deck(1, true);

        // init user
        Player usr = new Player("Player");

        // init dealer
        Player dealer = new Player("Dealer");

        // deal two cards to each player
        usr.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        usr.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        // print the starting hand
        System.out.println("\t\t--- Starting Hand ---");
        usr.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        // user and dealer begin as not done
        boolean usrDone = false, dealerDone = false;
        String input;

        // while user or dealer are not done with their turns
        while (!usrDone || !dealerDone) {

            // if user is not done
            if (!usrDone) {
                System.out.print("Hit or Stay? (Enter S or H): ");
                input = scan.next();
                System.out.println();

                // true if input is "h" or "H"
                if (input.compareToIgnoreCase("H") == 0) {

                    // user is done when sum of their hand is <= 21
                    // refer to Player.addCard()
                    usrDone = !usr.addCard(deck.dealCard());
                    usr.printHand(true);

                // any other input, (i.e. "S") causes user to be done
                } else {
                    usrDone = true;
                }
            }

            // if the dealer is not done
            if (!dealerDone) {

                // dealer hits if the sum of its hand is < 17
                if (dealer.getSum() < 17) {
                    System.out.println("Dealer hits");
                    dealerDone = !dealer.addCard(deck.dealCard());
                    dealer.printHand(false);

                // otherwise the dealer stays and is done
                } else {
                    System.out.println("Dealer stays");
                    dealerDone = true;
                }
            }
            // for spacing
            System.out.println();
        }

        // close Scanner to avoid resource leak
        scan.close();

        // print the hand of both users, showing their first cards
        usr.printHand(true);
        dealer.printHand(true);

        // user's sum and dealer's sum are equal to the respective sums of their hands
        int usrSum = usr.getSum(), dealerSum = dealer.getSum();

        // if the user's sum is greater than the dealer's and <= 21, or if the dealer busts
        if (usrSum > dealerSum && usrSum <= 21 || dealerSum > 21) {
            System.out.println("\nYou Win!!!!");

        // if winning conditions are not met
        } else {
            System.out.println("\nThe dealer wins.");
        }
    }
}
