/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2017
 */


package assignment3;
import java.util.*;
import assignment3.Graph;
import java.io.*;

public class Main {
	
	// static variables and constants only here.
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();

		
		
		//main while loop runs until user types /quit
		while (true) {
			ArrayList<String> input = parse(kb);
			if (input == null) {
				return;
			}
			else {
				ArrayList<String> ladder = getWordLadderBFS(input.get(0), input.get(1));
				System.out.println("Breadth First Search:::::");
				System.out.println();
				printLadder(ladder);
				System.out.println();
				ladder = getWordLadderDFS(input.get(0), input.get(1));
				System.out.println("Depth First Search:::::");
				System.out.println();
				printLadder(ladder);
			}
		
		}
		
		
		
	}
	
	
	
	
	
	/**
	 * I did not use this function
	 */
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.

	}
	
	
	
	
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO
		String s;
		ArrayList<String> input = new ArrayList<String>();
		while (true) {
			s = keyboard.next().toLowerCase();
			if (s.equals("/quit")) {
				return null;
			}
			input.add(s);
			if (input.size() > 1) {
				return input;
			}
		}
	}
	
	
	
	
	/**
	 * Performs a depth first search on the dictionary for a word ladder between the start and end word
	 * @param start beginning of word ladder
	 * @param end termination of word ladder
	 * @return an array list containing the word ladder connecting start and end
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		Set<String> dict = makeDictionary();
		if(dict.contains(start) && dict.contains(end)) {	//make sure the start and end words are in the dictionary
			Graph graph = new Graph(dict);
			return graph.DFS(start, end);
		}
		
		ArrayList<String> ladder = new ArrayList<String>();
		ladder.add(start);
		ladder.add(end);
		return ladder;
		
	}
	
	
	
	
	
	
	/**
	 * Performs a breadth first search on the dictionary for a word ladder between the start and end word
	 * @param start beginning of word ladder
	 * @param end termination of word ladder
	 * @return an array list containing the word ladder connecting start and end
	 */
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
    	
		Set<String> dict = makeDictionary();
		if(dict.contains(start) && dict.contains(end)) {	//check to make sure the dictionary contains the start and end words
			Graph graph = new Graph(dict);
			return graph.BFS(start, end);
		}
		
		ArrayList<String> ladder = new ArrayList<String>();
		ladder.add(start);
		ladder.add(end);
		return ladder;
	}
    
	
    
    
    
    
    /**
     * Prints a word ladder to the console
     * the ladder is sent in the reverse order so it is reversed before printing
     * @param ladder the ladder to be printed
     */
	public static void printLadder(ArrayList<String> ladder) {
		if ((ladder == null) || (ladder.size() < 2)) {
			System.out.println("no word ladder can be found");
			return;
		}
		if (ladder.size() < 3) {
			System.out.println("no word ladder can be found between " + ladder.get(0) + " and " + ladder.get(1));
			return;
		}
		System.out.println("a " + Integer.toString(ladder.size()-2) + "-rung ladder exists between " + ladder.get(ladder.size()-1) + " and " + ladder.get(0));
		Collections.reverse(ladder);
		for (String s : ladder) {
			System.out.println(s);
		}
	}

	
	
	
	


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toLowerCase());
		}
		return words;
	}
	
	
	
}
