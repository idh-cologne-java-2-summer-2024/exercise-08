package mb.test;

import java.util.LinkedList;
import java.util.List;

public class MyTree<T> {
	T data;
	MyTree<T> parent;
	List<MyTree<T>>children;
	
	public MyTree(T data) {
		this.data = data; //payload
		this.children = new LinkedList<MyTree<T>>();//child nodes which are also trees
	}
	/**
	 * Appends a new ChildNode Object to a parent tree
	 * @param child
	 * @return childNode (seems unnecessary)
	 * @apiNote Couldn't this just be a void method? <br>Unsure if return value is needed
	 */
	public MyTree<T> addChild(T child) {
		MyTree<T> childNode = new MyTree<T>(child);
		childNode.parent = this; //this refers to the MyTree Object calling the method to add a child
		this.children.add(childNode);//append newly created childNode to the parent tree
		return childNode; 
		}
	
	
	
	
	
	public List<MyTree<T>> getChilden(){
		return new LinkedList<MyTree<T>>(children);
	}
	
	public MyTree<T> getParent(){
		return parent;
	}
	@Override
	public String toString() {
		return (String) this.data;
	}
}
