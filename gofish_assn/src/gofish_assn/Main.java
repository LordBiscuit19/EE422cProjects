package gofish_assn;



public class Main {
	
	
	/**
	 * main program just runs the GoFishGame algorithm. Just used to test the game
	 * @param args this is not used
	 */
	public static void main(String args[]) {
		
		
		GoFishGame game = new GoFishGame();	//all the main does is runs the go fish game
		
		
		
		
		//:::::::::::::::::::::::::::::::::::::::
		//everything below here is test code I wrote while testing the program. I left it in for reference
		//:::::::::::::::::::::::::::::::::::::::
		
		
		/*
		System.out.println("Hello World!");
		
		Card c = new Card();
		Card ct = new Card(4,'d');
		
		System.out.println();
		System.out.println(c.toString());
		System.out.println();
			
		Deck d = new Deck();
		
		System.out.println("New deck:");
		d.printDeck();
		System.out.println();
		
		System.out.println("Shuffled Deck:");
		d.shuffle();
		
		d.printDeck();
		System.out.println();

		
		Player p1 = new Player("Jack");
		Player p2 = new Player("Black");
		
		
		for (int i = 0; i < 7; i++) {
			p1.addCardToHand(d.dealCard());
			p2.addCardToHand(d.dealCard());
		}

		System.out.println("Players Hands:");
		System.out.println(p1.handToString());
		System.out.println(p2.handToString());
		
		
		while(p1.checkHandForBook());
		System.out.println("Checked Player 1's Book");
		while(p2.checkHandForBook());
		System.out.println("Checked Player 2's Book");

		
		System.out.println("Players hands after looking for books");
		System.out.println(p1.handToString());
		System.out.println(p2.handToString());
		
		System.out.println("Players Books after looking for books");
		System.out.println("Player1:");
		System.out.println(p1.bookToString());
		System.out.println("Player2:");
		System.out.println(p2.bookToString());
		
		Card test = p1.chooseCardFromHand();
		System.out.println("Payer 1 asks for card: " + Integer.toString(test.getRank()));
		Card test2 = p2.sameRankInHand(test);
		if (test2 != null) {
			p1.addCardToHand(test2);
			System.out.println("Payer 2 has the card");
		}
		System.out.println("After checking for cards hands are: \n");
		System.out.println(p1.handToString());
		System.out.println(p2.handToString());
		
		
		*/
	}

	
	
}
