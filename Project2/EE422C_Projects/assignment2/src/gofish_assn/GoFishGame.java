package gofish_assn;

/**
 * contains sample game of Go Fish with two players
 */
public class GoFishGame {

    Deck deck = new Deck();
    Player p1 = new Player("Jane");
    Player p2 = new Player("John");
    static final int GO_FISH_HAND_SIZE_TWO_PLAYER = 7;

    /**
     * mainline logic for a game of Go Fish
     */
	public GoFishGame() {
		setupGame();

		Card playerAsk, playerGet;
		Player playerTurn = p1, playerNotTurn = p2;
		boolean goFish = false;

		while (p1.getBookSize() + p2.getBookSize() < deck.NUM_CARDS) {
			if (playerTurn.getHandSize() > 0) {
				playerAsk = playerTurn.removeCardFromHand(playerTurn.chooseCardFromHand());
				if (playerNotTurn.rankInHand(playerAsk)) {
					playerGet = playerNotTurn.removeRank(playerAsk);
					playerTurn.addToBook(playerAsk, playerGet);
				} else {
					playerTurn.addCardToHand(playerAsk);
					goFish = true;
				}
			} else {
				goFish = true;
			}

			if (goFish) {
				if (deck.deckSize() > 0) {
					playerTurn.addCardToHand(deck.dealCard());
					if (playerTurn.checkHandForBook()) {
						playerTurn.makeBookFromHand();
					}
				}
				if (playerTurn == p1) {
					playerTurn = p2;
					playerNotTurn = p1;
				} else {
					playerTurn = p1;
					playerNotTurn = p2;
				}
				goFish = false;
			}
		}
	}

    /**
     * returns a message with information on who won, who lost, and how many books each player has
     * @return String containing winner, loser, and number of books each player has
     */
	public String winMessage(){
	    String gameOverMessage;
	    Player winner, loser;
	    boolean draw = false;
	    if(p1.getBookSize() + p2.getBookSize() == deck.NUM_CARDS) {
            if (p1.getBookSize() > p2.getBookSize()) {
                winner = p1;
                loser = p2;

            } else if (p1.getBookSize() < p2.getBookSize()) {
                winner = p2;
                loser = p1;
            } else{
                winner = p1;
                loser = p2;
                draw = true;
            }

            if(draw) gameOverMessage = "The game ended in a draw.\n\n" + winner.getName() + " has " + winner.getBookSize() / 2 + " booked pairs\n\n";
            else gameOverMessage = winner.getName() + " wins with " + winner.getBookSize() / 2 + " booked pairs.\n\n";
            gameOverMessage += winner.bookToString() + "\n";
            gameOverMessage += loser.getName() + " has " + loser.getBookSize() / 2 + " booked pairs.\n\n";
            gameOverMessage += loser.bookToString();

        } else{
	        gameOverMessage = "Game is not over";
        }
        return gameOverMessage;
    }

    /**
     * shuffles deck, deals players cards, and creates any initial books dealt to players
     */
	private void setupGame(){
        deck.shuffle();
        p1.dealHand(deck, GO_FISH_HAND_SIZE_TWO_PLAYER);
        p2.dealHand(deck, GO_FISH_HAND_SIZE_TWO_PLAYER);
        while(p1.checkHandForBook() || p2.checkHandForBook()){
            p1.makeBookFromHand();
            p2.makeBookFromHand();
        }
    }

}
