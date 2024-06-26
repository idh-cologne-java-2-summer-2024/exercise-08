package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T> {

	/**
	 * The payload value for this tree node
	 */
	T value;

	/**
	 * The set of children this tree node has
	 */
	Set<Tree<T>> children;

	/**
	 * Constructs a new tree without children.
	 * 
	 * @param value The payload value
	 */
	public Tree(T value) {
		this.value = value;
		this.children = new HashSet<Tree<T>>();
	}

	/**
	 * Constructs a new tree with children.
	 * 
	 * @param value    The payload value
	 * @param children The children. Note that children are represented as set
	 *                 internally, i.e., each child node is unique. Also note that
	 *                 the children are of type Tree<T>.
	 */
	public Tree(T value, Collection<Tree<T>> children) {
		this.value = value;
		this.children = new HashSet<Tree<T>>(children);
	}

	/**
	 * Return the payload value of this tree node
	 * 
	 * @return The payload value
	 */
	public T get() {
		return value;
	}

	/**
	 * Set the payload value of this tree node
	 * 
	 * @param value The new value
	 */
	public void set(T value) {
		this.value = value;
	}

	/**
	 * Return the set of children
	 * 
	 * @return a set of children of a specific node.<br>
	 * 		   Returns an empty set if the node has no more children.
	 */
	public Set<Tree<T>> children() {
		return children;
	}

	/**
	 * Iterate over the tree, printing out each node value
	 */
	public void dfs() {
		int path = 0; // How deep are we in the tree, path-lenght
		int depth = 0; // tree depth-level
		String space = " ";
		
		
		System.out.println(this.value);
		for (Tree<T> child : children) {
			if(child==null) {
				return;
			}	
			if (this.children.contains(child) && child.value != null) {
				System.out.print(space);
				child.dfs();
			}else {
				System.out.println("Test");
				return;
			}
		}
	}

	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> buggy = new Tree<String>("buggy");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");
		

		
		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);

		wheeled_vehicle.dfs();
	}

}
