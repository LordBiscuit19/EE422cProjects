package gofish_assn;

import java.io.IOException;
import java.io.PrintWriter;

public class GoFishGame {
	static final int PLAYER_HAND_SIZE = 7;
	
	
	/**
	 * Plays 1 game of go fish using the Card, Deck, and Player objects
	 * Players start with 7 cards each
	 * Game ends when the deck is empty
	 */
	public GoFishGame() {
		Deck deck = new Deck();	//deck for the game to use
		deck.shuffle();
		Player p1 = new Player("Fresh");	//one of the players for the game
		Player p2 = new Player("Prince");	//the other player for the game
		
		
		for (int i = 0; i < PLAYER_HAND_SIZE; i++) {	//deals 7 cards to each player
			p1.addCardToHand(deck.dealCard());
			p2.addCardToHand(deck.dealCard());
		}
		
		while(p1.checkHandForBook());	//p1 and p2 book all the pairs of cards they have immediately
		while(p2.checkHandForBook());

		Player currentPlayer = p1; //pointer to the current player. This will be used to avoid repeating the main structure of the game twice
		Player otherPlayer = p2;	//pointer to the player who isn't the current player
		
		
		//try block for writing to file purposes
		try {
			PrintWriter writer = new PrintWriter("GoFish_results.txt");	//print writer for outputting to file
		
			while(!deck.isEmpty()) {	//game will keep going until the deck is empty
				
				if (currentPlayer.getHandSize() == 0) {	//if the current player's hand is empty player draws a card and switches turns
					System.out.println(currentPlayer.getName() + " has no cards");
					writer.println(currentPlayer.getName() + " has no cards");
					Card draw = deck.dealCard();	//card drawn from the deck
					System.out.println(currentPlayer.getName() + " draws " + draw.toString() + "\n");
					writer.println(currentPlayer.getName() + " draws " + draw.toString());
					writer.println();
					currentPlayer.addCardToHand(draw);
					while (currentPlayer.checkHandForBook());
					
					//swap players if current player had no cards
					Player temp = currentPlayer;
					currentPlayer = otherPlayer;
					otherPlayer = temp;
				}
				
				else {	//if the current Player's had is not empty current player asks other player for a card
					
					Card lookingFor = currentPlayer.chooseCardFromHand();	//the card that the current player is looking for
					System.out.println(currentPlayer.getName() + " asks - do you have a " + lookingFor.getRankString());
					writer.println(currentPlayer.getName() + " asks - do you have a " + lookingFor.getRankString());
					
					Card doesOtherPlayerHave = otherPlayer.sameRankInHand(lookingFor);	//has a card if the other player has the card the current player is looking for, otherwise null
					if (doesOtherPlayerHave == null) {	//if the other player does not have the card that was asked for
						System.out.println(otherPlayer.getName() + " says - Go Fish");
						writer.println(otherPlayer.getName() + " says - Go Fish");
						Card draw = deck.dealCard();	//card drawn from the deck
						System.out.println(currentPlayer.getName() + " draws " + draw.toString() + "\n");
						writer.println(currentPlayer.getName() + " draws " + draw.toString());
						writer.println();
						currentPlayer.addCardToHand(draw);
						while (currentPlayer.checkHandForBook());
						
						
						//swap players if card is not found
						Player temp = currentPlayer;
						currentPlayer = otherPlayer;
						otherPlayer = temp;
					}
					else {	//if the other player does have the card that was asked for
						System.out.println(otherPlayer.getName() + " says - Yes I Have A " + lookingFor.getRankString());
						writer.println(otherPlayer.getName() + " says - Yes I Have A " + lookingFor.getRankString());
						currentPlayer.addCardToHand(doesOtherPlayerHave);
						System.out.println(currentPlayer.getName() + " books the " + lookingFor.getRankString() + "\n");
						writer.println(currentPlayer.getName() + " books the " + lookingFor.getRankString());
						writer.println();
						while (currentPlayer.checkHandForBook());
						//do not swap players if card is found
					}
				}
			}
		
			
		
			//After game ends decide who won
			
			//list players books
			System.out.println(p1.getName() + " has - " + p1.getBookSize() + " books:");
			writer.println(p1.getName() + " has - " + p1.getBookSize() + " books:");
			System.out.println(p1.bookToString() + "\n");
			writer.println(p1.bookToString());
			writer.println();
			
			System.out.println(p2.getName() + " has - " + p2.getBookSize() + " books:");
			writer.println(p2.getName() + " has - " + p2.getBookSize() + " books:");
			System.out.println(p2.bookToString() + "\n");
			writer.println(p2.bookToString());
			writer.println();

			if (p1.getBookSize() > p2.getBookSize()) {	//if player 1 wins
				System.out.println(p1.getName() + " Wins!");
				writer.println(p1.getName() + " Wins!");
			}
			else if (p2.getBookSize() > p1.getBookSize()) {	//if player 2 wins
				System.out.println(p2.getName() + " Wins!");
				writer.println(p2.getName() + " Wins!");
			}
			else {		//if the game is a tie
				System.out.println("Game is a tie!");
				writer.println("Game is a tie!");
			}
			writer.close();
		}
		
		catch(IOException e){	//catch in case file output error happens
			System.err.println("Caught IOException: " +  e.getMessage());
		}
	}

}
