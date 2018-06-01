package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



/**
 * A graph of WordNodes. All nodes that contain words with 1 letter differences are neighbors
 * @author Don
 *
 */
public class Graph{
	
	
	public static final int DFS_MAX_DEPTH = 4000;	//the maximum depth the depth first search will search to
	Set<WordNodes> wordNodes = new HashSet<WordNodes>();	//the set of all the WordNodes in the graph
	
	
	/**
	 * constructor for graph class creates a graph of WordNodes all connected to their neighbors with 1 letter differences
	 * @param dic the dictionary to make the word graph from
	 */
	public Graph(Set<String> dic) {
		for (String s : dic) {
			WordNodes node = new WordNodes();
			node.word = s;
			wordNodes.add(node);
			for (WordNodes n : wordNodes) {
				if (compareStrings(n.word, node.word) == 1) {
					node.links.add(n);
					n.links.add(node);
				}
			}
		}
		
	}
	
	
	/**
	 * print the graph as an adjacency list
	 * also print to a file printGraph_results.txt
	 */
	public void printGraph() {
		for (WordNodes node : wordNodes) {
			System.out.print(node.word + " : ");
			for (WordNodes node2 : node.links) {
				System.out.print(node2.word + " ");
			}
			System.out.println();
		}
		try {
			PrintWriter writer = new PrintWriter("printGraph_results.txt");
			for (WordNodes node : wordNodes) {
				writer.print(node.word + " : ");
				for (WordNodes node2 : node.links) {
					writer.print(node2.word + " ");
				}
				writer.println();
			}
			writer.close();
		}
		catch(IOException e){	//catch in case file output error happens
			System.err.println("Caught IOException: " +  e.getMessage());
		}
	}
	

	
	/**
	 * Function compares 2 strings. If they are the same return 0, if they are 1 letter different return 1, if they are 2 letters different return 2 ect.
	 * If the strings are not the same length return -1
	 * @param s1 first string to compare
	 * @param s2 second string to compare
	 */
	private int compareStrings(String s1, String s2) {
		int noDifCount = 0;	//this will store the number of difference in the strings when comparing characters
		
		if (s1.length() != s2.length()) {
			return -1;
		}
		
		for (int i = 0; (i < s1.length()) || (i <s2.length()); i++ ) {
			if (s1.charAt(i) != s2.charAt(i)) {
				noDifCount++;
			}
		}
		
		return noDifCount;

	}
	
	
	
	/**
	 * Returns an array list of strings that is the word ladder between the start and end string
	 * @param start	string to start word ladder from
	 * @param end string to terminate word ladder at
	 * @return array list of the strings in the word ladder 
	 */
	public ArrayList<String> BFS(String start, String end) {
		ArrayList<String> ladder = new ArrayList<String>();
		WordNodes startNode = findNode(start);						//check to see if the start is in the list of nodes
		if (startNode == null) {									//if not in the list return a null pointer
			return null;
		}
		ArrayList<WordNodes> queue = new ArrayList<WordNodes>();	//queue to store the nodes to look at
		
		queue.add(startNode);
		startNode.checked = true;
		while(!queue.isEmpty()) {
			/*
			for (WordNodes n : queue) {
				System.out.print(n.word + " ");
			}
			System.out.println();
			for (WordNodes n : checkedNodes) {
				System.out.print(n.word + " ");
			}
			System.out.println();
			*/
			WordNodes node = queue.remove(0);
			if (node.word.equals(end)) {
				while (node.parent != null) {
					ladder.add(node.word);
					node = node.parent;
				}
				ladder.add(start);
				return ladder;
			}
			
			for (WordNodes children: node.links) {		//set up the links to the parent node for the children
				if(!children.checked) {					//if the node we are looking at has not been checked we add it to the queue
					children.parent = node;
					queue.add(children);
					children.checked = true;
				}
			}
				
			
		}
		ladder.add(start);
		ladder.add(end);
		return ladder;
	}
	
	
	
	
	/**
	 * Performs a depth first search on the graph for a word ladder between the start and end word
	 * @param start beginning of word ladder
	 * @param end termination of word ladder
	 * @return an array list containing the word ladder connecting start and end
	 */
	public ArrayList<String> DFS(String start, String end){
		ArrayList<String> ladder = new ArrayList<String>();
		WordNodes node = findNode(start);
		final int START_DEPTH = 0;
		DFSrecursive(start, end, ladder, node, START_DEPTH);
		if(ladder.size() == 0) {
			ladder.add(start);
			ladder.add(end);
		}
		return ladder;
	}
	
	
	/**
	 * the recursive helper of DFS
	 * @param start the word to start the ladder at
	 * @param end	the word to terminate the ladder at
	 * @param ladder the word ladder to be built
	 * @param node	the node for the function to check
	 * @param depth	is used to prevent a stack overflow. It limits the depth to which the recursive call can search
	 */
	private void DFSrecursive(String start, String end, ArrayList<String> ladder, WordNodes node, int depth) {
		if(node.word.equals(end)) {		//base case. If we find the end word then return back and add the word to the ladder
			ladder.add(node.word);
			return;
		}
		node.checked = true;
		//System.out.print(node.word + " ");
		
		WordNodes next = node;
		while((next != null) && (ladder.isEmpty()) && (depth < DFS_MAX_DEPTH)) {	//check the adjacent nodes to try and find the end word
			next = null;
			for (WordNodes n : node.links) {	//see if there are any nodes that have not been checked linked to the current node
				if (!n.checked) {
					next = n;
					break;
				}
			}
			if (next != null) {		//if there are no nodes that have not been checked recurse back
				for (WordNodes n : node.links) {	//find the node linked to the current node that is closet to the end word
					if(!n.checked) {
						//System.out.print(n.word + " ");
						if (compareStrings(n.word, end) < compareStrings(next.word, end)) {
							next = n;
						}
					}
					
				}
				DFSrecursive(start, end, ladder, next, depth+1);
			}
		}
		
		if(!ladder.isEmpty()) {		//if we found the word in a previous instance of recursion we need to add the path to the ladder
			ladder.add(node.word);
			//System.out.println();
			return;
		}
		
		//System.out.println();
		return;
	}
	
	
	
	/**
	 * if the word is in the set of word nodes return a pointer to the node, otherwise return a null
	 * @param s	the word to find
	 * @return a point to the node with that word
	 */
	private WordNodes findNode(String s) {
		for (WordNodes node : wordNodes) {
			if (node.word.equals(s)) {
				return node;
			}
		}
		
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * class for the individual nodes
	 * all nodes are connected to other nodes that are 1 letter different
	 * @author Don
	 */
	private static class WordNodes {
		
		String word;	//the word stored in the node
		boolean checked = false;	//keeps track of if this node has been checked during a search
		ArrayList<WordNodes> links = new ArrayList<WordNodes>();	//the links between this node and its neighbors
		WordNodes parent = null;	//used in breadth first search so that once the end of the ladder is found the function can follow the path back to the start node
		
	
	
		/**
		 * constructor for WordNodes. Will add the new word to a node and make links to the list of nodes with any word that is 1 letter away from the word being added
		 * @param s word to be added
		 */
		public WordNodes() {
		}
		
		
		
		
		/**
		 * prints all the connections of this node to the console
		 */
		public void printConnections() {
			 for (WordNodes node: this.links) {
				System.out.println(node.word);
			}
		}
	

		
	}
	
	
}
