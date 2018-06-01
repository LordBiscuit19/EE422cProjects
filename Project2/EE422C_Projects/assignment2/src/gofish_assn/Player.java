package gofish_assn;

import java.util.ArrayList;

/**
 * Player to be used in go fish card game, contains hand and book as well as common methods relating to card games
 */
public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> book = new ArrayList<Card>();
	String name;

	/**
	 * creates Player with given name
	 * @param name String containing player's name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * adds given Card to player's hand
	 * @param c Card to be added to players hand
	 */
	public void addCardToHand(Card c) {
		hand.add(c);
	}

	/**
	 * removes card from players hand and returns the removed card
 	 * @param c Card to be removed from players hand
	 * @return Card removed is returned if it is in players hand, null is returned if card is not in players hand
	 */
	public Card removeCardFromHand(Card c) {
		if(hand.remove(c)){
			return c;
		} else{
			return null;
		}
	}

	/**
	 * returns String containing player's name
	 * @return String containing player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns String representation of cards in player's hand
	 * @return String containing the rank and suit of each card in the player's hand separated by new line characters
	 * example: "2d\n5h\n"
	 */
	public String handToString() {
	    if(hand.isEmpty()) return null;
		String handString = "";
		for(Card card : hand){
			handString += card.toString() + "\n";
		}
		return handString;
	}

	/**
	 * returns String representation of cards in player's books
	 * @return String containing the rank and suit of each of the player's books separated by new line characters
	 * example: "As, Ac\n"
	 */
	public String bookToString() {
	    if(book.isEmpty()) return null;
	    String bookString = "";
	    for(int i = 0; i < getBookSize() - 1; i += 2){
	        bookString += book.get(i).toString() + ", " + book.get(i+1).toString() + "\n";
        }
		return bookString;
	}

	/**
	 * returns the number of cards in the player's hand
 	 * @return int containing the number of cards in the player's hand
	 */
	public int getHandSize() {
		return hand.size();
	}

	/**
	 * returns the total number of cards the player has in books
 	 * @return int containing total number of cards the player has in books
	 */
	public int getBookSize() {
		return book.size();
	}

	//Here are som ideas for additional functionality that you may want/need

	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

    /**
     * checks the players hand to see if there are any Cards with matching ranks
     * @return true if there are two Cards with matching ranks, false if there are no cards with matching ranks
     */
    public boolean checkHandForBook() {
		for(int i = 0; i < hand.size() - 1; i++){
			for(int j = i + 1; j < hand.size(); j++){
				if(hand.get(i).getRank() == hand.get(j).getRank()){
					return true;
				}
			}
		}
    	return false;
    }

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?

    /**
     * checks if player has a Card in their hand that has the same rank as card passed in
     * @param c Card passed in to check if player has matching rank in hand
     * @return returns true if card of matching rank is in players hand, false if no card of matching rank
     */
    public boolean rankInHand(Card c) {
		for(Card card : hand){
			if(card.getRank() == c.getRank()){
				return true;
			}
		}
    	return false;
    }
    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"

    /**
     * returns the first card (0 element) from player's hand
     * @return first Card from player's hand
     */
    public Card chooseCardFromHand() {
		if(hand.isEmpty()){
			return null;
		} else{
			return hand.get(0);
		}
    }

//    //Does the player have the card with rank c in her hand?
//    public boolean cardInHand(Card c) {
//    	return false; //stubbed
//    }
//    //OPTIONAL
//    // comment out if you decide to not use it
//    //Does the player have a card with the same rank as c in her hand?
//    //e.g. will return true if the player has a 7d and the parameter is 7c
//    public boolean sameRankInHand(Card c) {
//    	return false; //stubbed
//    }

    /**
     * deals specified number of cards from Deck into players hand
     * @param deck Deck from which cards will be dealt
     * @param numCards number of cards from deck to be dealt into players hand
     */
	public void dealHand(Deck deck, int numCards) {
		for(int i = 0; i < numCards; i++){
			addCardToHand(deck.dealCard());
		}
	}

    /**
     * removes a Card from the player's hand which matches rank of card passed in.
     * @param inputCard Card whose rank will be used to search players hand for card of matching rank
     * @return if card of matching rank exists in players hand it will be removed and returned, if no card of matching
     * rank exists null is returned
     */
	public Card removeRank(Card inputCard){
		for(Card card : hand){
			if(inputCard.getRank() == card.getRank()){
				return removeCardFromHand(card);
			}
		}
		return null;
	}

    /**
     * adds pair of Cards into player's book
     * @param c1 first Card to be added to player's book
     * @param c2 second Card to be added to Player's book
     */
	public void addToBook(Card c1, Card c2){
		book.add(c1);
		book.add(c2);
	}

    /**
     * searches player's hand for a pair of cards, removes first pair found and adds the two cards to player's book
     * @return true if a pair of Cards was found in hand and added to book, false if no pairs found
     */
	public boolean makeBookFromHand(){
		for(int i = 0; i < hand.size() -1; i++){
			for(int j = i + 1; j < hand.size(); j++){
				if(hand.get(i).getRank() == hand.get(j).getRank()){
					Card c1 = hand.get(i), c2 = hand.get(j);
				    addToBook(c1, c2);
					removeCardFromHand(c1);
					removeCardFromHand(c2);
					return true;
				}
			}
		}
		return false;
	}


}
