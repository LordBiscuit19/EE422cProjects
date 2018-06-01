package gofish_assn;

public class Card {
	
	public enum Suits {club, diamond, heart, spade};
	
	static int TOP_RANK = 13; //King
	static int LOW_RANK = 1; //Ace
	
	int rank;  //1 is an Ace
	Suits suit;
	
	
	/**
	 * This method creates a new card without any input
	 * The card defaults to a 1 of spades
	 */
	public Card() {
		rank = 1;
		suit = Suits.spade;
	}
	
	
	
	
	/**
	 * This method creates a card based on an integer and character input.
	 * @param r is the integer value for the rank of the card. 1 is ace and 13 is king
	 * @param s	is the suit value for the card. s for spades, d for diamonds, h for hearts, and c for clubs
	 */
	public Card(int r, char s) {
		rank = r;
		suit = toSuit(s);
	}
	
	
	
	
	
	/**
	 * This method creates a card based on an integer and Suits enum input.
	 * @param r is the integer value for the rank of the card. 1 is ace and 13 is king
	 * @param s	is the suit value for the card
	 */
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}
	
	
	
	
	/**
	 * This method converts a character into a Suits enum
	 * @param c, the character to be converted in a suit
	 * @return	the suit that corresponds to the given character
	 */
	private Suits toSuit(char c) {
		switch(c) {
			case 's' :
				return Suits.spade;
			case 'd' :
				return Suits.diamond;
			case 'h' :
				return Suits.heart;
			case 'c' :
				return Suits.club;
			case 'S' :
				return Suits.spade;
			case 'D' :
				return Suits.diamond;
			case 'H' :
				return Suits.heart;
			case 'C' :
				return Suits.club;
			default : 
				return Suits.club;
		}
	}
	
	
	
	
	/**
	 * This function returns a string representation of the Suit enum
	 * @param s is the Suit enum to be changes to a string
	 * @return the string representation of s
	 */
	private String suitToString(Suits s){
		switch (s) {
			case club :
				return "c";
			case spade :
				return "s";
			case diamond :
				return "d";
			case heart :
				return "h";
			default :
				return "default";
		}
	}
	
	
	
	
	
	/**
	 * This function returns a string representation of the rank passed to the function
	 * @param r	the rank to be returned as a string
	 * @return	the string representation of r
	 */
	private String rankToString(int r)
	{
		switch (r) {
			case 1 :
				return "A";
			case 11 :
				return "j";
			case 12 :
				return "q";
			case 13 :
				return "k";
			default :
				return Integer.toString(r);
		}
	}
		
	
	
	
	
	/**
	 * @return returns an integer representation of the cards rank. 1 for ace 13 for king
	 */
	public int getRank() {
		return rank;
	}
	
	
	
	
	/**
	 * returns the rank of the card as a string
	 * @return string representation of rank
	 */
	public String getRankString() {
		return rankToString(rank);
	}
	
	public Suits getSuit() {
		return suit;
	}
	
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank()) + suitToString(getSuit());
		
		return s;
	}
}
