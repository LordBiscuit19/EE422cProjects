package gofish_assn;

import java.util.ArrayList;
import gofish_assn.Card.Suits;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
	static int ACE = 1;
	static int KING = 13;
	static int SHUFFLE = 5000;
	ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	
	
	
	
	/**
	 * creates a new sorted deck sorted from clubs, to diamonds, to hearts, to spades. Ranks are in ascending order
	 */
	public Deck() {
		for (Suits suit : Suits.values()) {
			for (int i = ACE; i <= KING; i++) {
				Card card = new Card(i,suit);
				deck.add(card);
			}
				
		}
		
	}
	
	
	
	
	
	
	/**
	 * Shuffles the deck of cards randomly using a randomly generated number form java.util.concurrent.ThreadLocalRandom;
	 */
	public void shuffle() {
		
		for (int i = 0; i < SHUFFLE; i++) {	//shuffle the deck SHUFFLE number of times
			int randomNum1 = ThreadLocalRandom.current().nextInt(0, NUM_CARDS);	//random integer from 0 to NUM_CARDS - 1
			int randomNum2 = ThreadLocalRandom.current().nextInt(0, NUM_CARDS);
			while (randomNum1 == randomNum2) {	
				randomNum2 = ThreadLocalRandom.current().nextInt(0, NUM_CARDS);	//if the two random number are the same draw a new random number untill they are differnt
			}
			Card temp = new Card(deck.get(randomNum1).getRank(), deck.get(randomNum1).getSuit());
			deck.set(randomNum1, deck.get(randomNum2));
			deck.set(randomNum2, temp);		//swaps the elements at the randomly chosen indices of deck
		}
	}
	
	
	
	/**
	 * prints the deck to the console
	 */
	public void printDeck() {
		for (Card temp : deck) {
			System.out.println(temp.toString());
		}
	}
	
	
	
	/**
	 * Returns the top card of the deck. Returned card is deleted
	 * @return returns the top card of the deck
	 */
	public Card dealCard() {
		Card c = deck.get(0);
		deck.remove(0);
		return c;
		
	}
	
	
	
	
	/**
	 * @return true if deck is empty false otherwise
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}
}
