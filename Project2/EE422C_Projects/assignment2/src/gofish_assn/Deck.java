package gofish_assn;

import java.util.ArrayList;

import gofish_assn.Card.Suits;
import java.util.Random;

/**
 * creates a deck of playing cards by organizing sets of Card data types, and contains methods to perform common
 * operations of playing card games.
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	private final int NUM_SHUFFLE_SWAPS = 1000;

    /**
     * Creates a new deck of 52 cards ordered Ace - King of Hearts, Clubs, Diamonds, Spades
     */
	public Deck() {
		char suits[] = {'h', 'c', 'd', 's'};
		for(char suit : suits ){
			for(int i = 1; i <= 13; i++){
				deck.add(new Card(i, suit));
			}
		}
	}

    /**
     * Randomly re-arranges elements of the deck simulating a shuffle
     */
	public void shuffle() {
		Random rnd = new Random();
		for(int i = 0; i < NUM_SHUFFLE_SWAPS; i++){
		    int index1 = rnd.nextInt(52);
            int index2 = rnd.nextInt(52);
            Card temp = deck.get(index1);
            deck.set(index1, deck.get(index2));
            deck.set(index2, temp);
        }
	}

    /**
     * Prints the value and suit of each card in the deck
     */
	public void printDeck() {
		String deckString = "";
		for(Card card : deck){
			deckString += card.toString() + "\n";
		}
		System.out.println(deckString);
	}

    /**
     * Deals the first card in the deck (at index 0) by removing it from the deck and returning it
     * @return returns a card if deck is non empty, if deck is empty returns null
     */
	public Card dealCard() {
	    if(deck.size() == 0) return null;

	    Card dealtCard = deck.get(0);
	    deck.remove(0);

		return dealtCard;
	}

	public int deckSize(){
	    return deck.size();
    }

}
