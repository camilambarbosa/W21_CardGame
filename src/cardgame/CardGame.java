package cardgame;

import cardgame.Card.Suit;
import cardgame.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 * This class models a simple card guessing game
 * 
 * @author Paul Bonenfant
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);

        // Create an array to hold 7 cards
        Card[] hand = new Card[7];
        
        Value [] cardValues = Value.values();
        Suit [] cardSuits = Suit.values();

        // We'll use Random to generate random numbers
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            Value value = cardValues[random.nextInt(cardValues.length)];
            Suit suit = cardSuits[random.nextInt(cardSuits.length)];

            Card card = new Card(value, suit);
            hand[i] = card;
        }

        // print them out for debugging purposes
        System.out.println("Here are the cards in the hand");
        for (Card card : hand) {
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
        }

        // Now ask the user for a card
        System.out.println("Pick a suit for your card");
       for (int i = 0; i < cardSuits.length; i++) {
            System.out.println((i + 1) + ": " + cardSuits[i]);
        }
        int suitPosition = input.nextInt() -1;

        System.out.println("Enter a value: ");
        
                for ( int i = 0; i < cardValues.length; i++){
                    System.out.println( ( i+1) + ":" + cardValues[i]);
                }
        
        
        int valuePosition = input.nextInt() -1;

        Card userGuess = new Card(cardValues[valuePosition], cardSuits[suitPosition]);

        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && card.getSuit().equals(userGuess.getSuit())) {
                match = true; 
                break;
            }
        }
    
        String response = match ? "Right guess": "No match";
        
        System.out.println(response);
    }
    
}
