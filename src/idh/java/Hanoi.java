package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {

    Deque<Integer> left = new LinkedList<Integer>();
    Deque<Integer> middle = new LinkedList<Integer>();
    Deque<Integer> right = new LinkedList<Integer>();

    /**
     * Constructor to create a new board. The left stick is filled with the correct
     * set of pieces.
     */
    public Hanoi() {
	for (int i = 3; i < 10; i++) {
	    left.addLast(i);
	}
    }

    /**
     * Private method to move one piece from one stick to another. The two arguments
     * from and two are `char` values l, m, or r for the left, middle, or right
     * stick. Any other supplied values will throw an IllegalArgumentException.
     * 
     * @param from
     * @param to
     */
    private void movePiece(char from, char to) {

	Integer piece = null;
	switch (from) {
	case 'l':
	    piece = left.remove();
	    break;
	case 'm':
	    piece = middle.remove();
	    break;
	case 'r':
	    piece = right.remove();
	    break;
	default:
	    throw new IllegalArgumentException("Argument " + from + " is not allowed.");
	}

	switch (to) {
	case 'l':
	    left.addFirst(piece);
	    break;
	case 'm':
	    middle.addFirst(piece);
	    break;
	case 'r':
	    right.addFirst(piece);
	    break;
	default:
	    throw new IllegalArgumentException("Argument " + to + " is not allowed.");
	}
    }

    /**
     * Main function to play the game manually. Users enter two-symbol combinations
     * that describe source and target stick.
     */
    public void run() {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	    try {
		System.out.println(this);
		System.out.print("Enter source and target stick (will move top piece):");
		String s = br.readLine();
		if (s.matches("^([lmr])([lmr])$")) {
		    char source = s.charAt(0);
		    char target = s.charAt(1);
		    movePiece(source, target);
		}
	    } catch (Exception e) {
		System.out.println("Try again, something's not right.");
		e.printStackTrace();
	    }
	}
    }

    private Iterator<Integer> getLeftDescendingIterator() {
	return left.descendingIterator();

    }

    private Iterator<Integer> getMiddleDescendingIterator() {
	return middle.descendingIterator();

    }

    private Iterator<Integer> getRightDescendingIterator() {
	return right.descendingIterator();
    }

    /**
     * Method to print out the current state of the board in the terminal.
     */
    @Override
    public String toString() {
	StringBuilder b = new StringBuilder();
	b.append("  |\n l|");
	Iterator<Integer> iter;
	iter = this.getLeftDescendingIterator();
	while (iter.hasNext()) {
	    b.append(iter.next());
	    b.append(' ');
	}
	b.append("\n  |\n m|");
	iter = this.getMiddleDescendingIterator();
	while (iter.hasNext()) {
	    b.append(iter.next());
	    b.append(' ');
	}
	b.append("\n  |\n r|");
	iter = this.getRightDescendingIterator();
	while (iter.hasNext()) {
	    b.append(iter.next());
	    b.append(' ');
	}
	b.append("\n  |");
	return b.toString();
    }

    public static void main(String[] args) {
	Hanoi hanoi = new Hanoi();
	// hanoi.run();
	hanoi.runAutomatically();
    }

    /**
     * The entry point into the automatic solution. The method will print out the
     * initial situation, call {@link #movePieces(int, char, char, char)}, and print
     * the final situation. The recursive implementation of the solution goes into
     * {@link #movePieces(int, char, char, char)}.
     */
    private void runAutomatically() {
	// we print out the initial situation
	System.out.println(this);

	// this is the entry point into the recursion
	movePieces(left.size(), 'l', 'r', 'm');

	// and in the end, we check that everything has been moved
	System.out.println(this);
    }

    private void movePieces(int numberOfPieces, char from, char to, char util) {
	// TODO: Implement me!
    	if(numberOfPieces == 1) {
    		movePiece(from, to);
    	}
    		else {
    			movePieces(numberOfPieces - 1, from, util, to);
    			movePiece(from, to);
    			movePieces(numberOfPieces -1, util, to, from);
    		}
    	}
    }

}
