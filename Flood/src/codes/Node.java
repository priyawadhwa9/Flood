package codes;

public class Node {
	private int data;
	private Node up;
	private Node down;
	private Node right;
	private Node left;
	
	// constructor with data
	public Node(int data) 
	{	
		this.data = data;
		up = null;
		down = null;
		right = null;
		left = null;
	}
	// constructor without data
	public Node() 
	{	
		data = 0;
		up = null;
		down = null;
		right = null;
		left = null;
	}
	// getters and setters
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getUp() {
		return up;
	}
	public void setUp(Node up) {
		this.up = up;
	}
	public Node getDown() {
		return down;
	}
	public void setDown(Node down) {
		this.down = down;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	
}
