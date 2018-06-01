package gofish_assn;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>();	//hand of the player
	ArrayList<Card> book = new ArrayList<Card>();	//book of the player
	String name;	//name of the player
	
	
	
	
	/**
	 * constructor for player object
	 * Object has an array list of cards called hand the represents the hand of the player
	 * Object has an array list of cards called book that represents the pairs the player has
	 * @param name is the name of the new player object
	 */
	public Player(String name) {
		this.name = name;
	}
	
	
	
	
	
	/**
	 * Adds a new card to the player's hand
	 * @param c is the card to add
	 */
	public void addCardToHand(Card c) {
		hand.add(c);
	}
	
	
	
	
	
	/**
	 * Adds a pair of matching cards to the players book
	 * @param c1 First card to be added
	 * @param c2 Second card to be added
	 */
	public void addCardsToBook(Card c1, Card c2) {
		book.add(c1);
		book.add(c2);
	}
	
	
	
	
	
	/**
	 * removes a card from the player's had if present.
	 * returns a null pointer if the card is not present
	 * @param c	is the card to remove
	 * @return	returns the card removed from the hand if present
	 */
	public Card removeCardFromHand(Card c) {
		if (hand.indexOf(c) == -1) {
			return null;
		}
		int tempIndex = hand.indexOf(c);	//index of card to remove
		Card retCard = hand.get(tempIndex);	//card to return
		hand.remove(tempIndex);
		return retCard;
	}
	
	
	
	
	/**
	 * getter function for player name
	 * @return name of player as string
	 */
	public String getName() {
		return name;
	}
	
	
	
	/**
	 * @return string representation of the hand of the player
	 */
	public String handToString() {
		String s = new String();	//string to return
		for (Card c : hand) {
			s = s + c.toString() + "\r\n";
		}
		return s;
	}
	
	
	
	/**
	 * @return a string representation of the book of the player
	 */
	public String bookToString() {
		String s = new String();	//string to return
		for (Card c : book) {
			s = s + c.toString() + "\r\n";
		}
		return s;
	}
	
	
	
	
	/**
	 * @return an integer representing the number of cards in the player's hand
	 */
	public int getHandSize() {
		int i = 0;
		for (Card c : hand) {
			i++;
		}
		return i;
	}
	
	

	
	
	/**
	 * @return an integer representing the number of pairs in the player's book
	 */
	public int getBookSize() {
		int i = 0;
		for (Card c : book) {
			i++;
		}
		return i/2;
	}
	

	
	
	
	/**
	 * this function will check a players hand for a pair. 
	 * @return If a pair is found, it moves the cards to the book and returns true, otherwise returns false
	 */
    public boolean checkHandForBook() {
    	int handSize = getHandSize();	//size of player's hand
    	if (handSize < 2) {
    		return false;
    	}
    	for (int i = 0; i < handSize; i++) {
    		for (int j = i+1; j < handSize; j++) {
    			if (hand.get(i).getRank() == hand.get(j).getRank()) {
    				addCardsToBook(hand.get(i), hand.get(j));
    				Card temp1 = hand.get(i);
    				Card temp2 = hand.get(j);
    				removeCardFromHand(temp1);
    				removeCardFromHand(temp2);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    
    
    

    
    /**
     * Returns true if player has as card with the same rank as the card c in their hand
     * @param c card to check is player has card with same rank
     * @return	true if player has a card with same rank false otherwise
     */
    public boolean rankInHand(Card c) {
    	for (Card temp : hand) {
    		if (c.getRank() == temp.getRank()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    

    /**
     * Pick a random card from the player's hand so they can ask if the other player has it
     * @return the random card
     */
    public Card chooseCardFromHand() {
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, hand.size());	//random integer from 0 to size of the players hand
    	Card c = hand.get(randomNum1);
		return c;
    }
    
    
    
    
    /**
     * Does the player have the card c in her hand?
     * @param c the card we are looking for
     * @return	true if they have the card and false otherwise
     */
    public boolean cardInHand(Card c) {
    	for (Card temp : hand) {
    		if (temp.equals(c)) {
    			return true;
    		}
    	}
    	return false;
    }
    

    
    
    
    /**
     * Does the player have a card with the same rank as c in her hand?
     * If they do remove that card
     * @param c the card we are looking for in the player's hand
     * @return	returns a pointer to the card if they player has it and null otherwise
     */
    public Card sameRankInHand(Card c) {
    	for (Card temp : hand) {
    		if (temp.getRank() == c.getRank()) {
    			return removeCardFromHand(temp);
    		}
    	}
    	return null;
    }

}
