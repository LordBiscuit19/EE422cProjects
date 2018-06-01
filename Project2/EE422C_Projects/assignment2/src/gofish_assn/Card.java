package gofish_assn;

/**
 * Card class creates Card representations of standard playing cards with integers representing card ranks, 1 is Ace,
 * 2 - 10 are face cards, 11 is Jack, 12 is Queen, 13 is King. Suits are represented with char where 'c' is Club,
 * 'd' is Diamond, 'h' is Heart, 's' is Spade, or enumerated Suits data type.
 */
public class Card {
	
	public enum Suits {club, diamond, heart, spade};
	
	static int TOP_RANK = 13; //King
	static int LOW_RANK = 1; //Ace
    private final static int ACE_VALUE = 1;
	
	private int rank;
	private Suits suit;

	/**
	 * Creates an Ace of Spades Card
 	 */
	public Card() {
		rank = ACE_VALUE;
		suit = Suits.spade;
	}

	/**
	 * creates a Card of specified rank and suit
	 * @param r Card rank, valid inputs are int 1 - 13 where 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
	 * @param s Card suit, valid inputs 'c', 'd', 'h', 's', where 'c' is Clubs, 'd' is Diamonds, 'h' is Hearts, 's' is Spades
	 */
	public Card(int r, char s) {
        rank = r;
        suit = toSuit(s);
	}

	/**
	 * creates a Card of specified rank and suit
	 * @param r Card rank, valid inputs are int 1 - 13 where 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
	 * @param s Card suit where s is an enumerated data type Suits
	 */
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}

	/**
	 * Takes char suit input and returns corresponding enumerated Suits data type
	 * @param c char representing desired suit, valid inputs 'c', 'd', 'h', 's' where 'c' is Club, 'd' is Diamond,
	 *             'h' is Heart, and 's' is Spade
	 * @return returns enumerated Suits data type based on input char, returns null if invalid input
	 */
	private Suits toSuit(char c) {
		switch(c){
            case 'c': return Suits.club;
            case 'd': return Suits.diamond;
            case 'h': return Suits.heart;
            case 's': return Suits.spade;
        }
		return null;
	}

	/**
	 * Takes Suits input and returns String corresponding to input suit
	 * @param s enumerated Suits data type
	 * @return returns String corresponding to the first letter of input suit, returns "Bad Input" if bad input
	 */
	private String suitToString(Suits s) {
	    switch(s){
            case club: return "c";
            case diamond: return "d";
            case heart: return "h";
            case spade: return "s";
        }
        return "Bad input";
    }

	/**
	 * Takes int rank and returns String corresponding to input rank
	 * @param r Card rank, valid inputs are int 1 - 13 where 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
	 * @return returns String "2" - "10" if r is between 2 and 10, "A" if r is 1, "J" if r is 11, "Q" if r is 12,
	 * 				"K" if r is 13, returns "Bad input" if r is invalid
	 */
	private String rankToString(int r) {
	    if(r >= 2 && r <= 10) return  Integer.toString(r);
	    switch(r){
            case ACE_VALUE: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
        }
        return "Bad input";
	}

	/**
	 * returns the rank of the Card
	 * @return int 1 - 13 corresponding to rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * returns the suit of the Card
 	 * @return enumerated Suits data type containing suit of the Card
	 */
	public Suits getSuit() {
		return suit;
	}

	/**
	 * returns String representation of the Card
	 * @return String containing the rank and suit of the Card, example: Ace of Spades is "As", 2 of Diamonds is "2d"
	 */
	public String toString() {
		String s = "";
		s = s + rankToString(getRank()) + suitToString(getSuit());
		return s;
	}
}
