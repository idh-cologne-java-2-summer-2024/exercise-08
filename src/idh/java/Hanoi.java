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

    public Hanoi() {
	for (int i = 3; i < 10; i++) {
	    left.addLast(i);
	}
    }

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
	}
    }

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

    private void runAutomatically() {
	// we print out the initial situation
	System.out.println(this);

	// this is the entry point into the recursion
	movePieces(left.size(), 'l', 'r', 'm');

	// and in the end, we check that everything has been moved
	System.out.println(this);
    }

    /**
     * This is the recursive method we have to implement. Its core idea is that we a
     * recursion over the number of pieces we want to move. We know how to move one
     * piece (by calling {@link #movePiece(char, char)}). To move <i>n</i> pieces,
     * we can use recursion:
     * <ol>
     * <li>Move n-1 pieces via recursion</li>
     * <li>Move 1 piece (base case)</li>
     * <li>Move n-1 pieces via recursion</li>
     * </ol>
     * 
     * 
     * 
     * @param numberOfPieces
     * @param from
     * @param to
     * @param util
     */
    private void movePieces(int numberOfPieces, char from, char to, char util) {
	// TODO: Implement me!

	if (numberOfPieces == 1) {
	    // base case
	    System.out.println(this);
	    movePiece(from, to);
	} else {
	    // recursion step

	    // move n-1 pieces to an auxiliary stick
	    movePieces(numberOfPieces - 1, from, util, to);
	    // move 1 piece from source to target stick
	    movePiece(from, to);

	    // move n-1 pieces from auxiliary stick to target stick
	    movePieces(numberOfPieces - 1, util, to, from);
	}
    }

}
