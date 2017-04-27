package codes;

public class Grid {
	private Node root;
	private int dimension;

	public Grid(int size)
	{
		//set grid size
		this.dimension = size;
		// Creating the first node, all nodes generated with random number between 1 and 6
		root = new Node((int) (Math.random() * 6 + 1));
		//Tracks horizontal movement
		Node marker = root;
	
		// Creating the first row like a linked list
		for (int x = 0; x < dimension - 1; x++) 
		{
			Node temp = new Node((int) (Math.random() * 6 + 1));
			marker.setRight(temp);
			temp.setLeft(marker);
			marker = temp;
		}
		// tracks vertical movement
		Node rowMarker = root;
		// builds the remaining rows
		for (int y = 0; y < dimension - 1; y++) 
		{
			Node temp = new Node((int) (Math.random() * 6 + 1));
			rowMarker.setDown(temp);
			temp.setUp(rowMarker);
		
			for (int x = 0; x < dimension - 1; x++) 
			{
				marker = temp;
				temp = new Node((int) (Math.random() * 6 + 1));
				marker.setRight(temp);
				temp.setLeft(marker);
				temp.getLeft().getUp().getRight().setDown(temp);
				temp.setUp(temp.getLeft().getUp().getRight());
			}
			
				rowMarker = rowMarker.getDown();
		
		}

	}

	public void display() 
	{
		Node rowMarker = root;
	
		while (rowMarker != null) 
		{
			Node temp = rowMarker;
		
			while (temp != null)
			{
				System.out.print(temp.getData() + "\t");
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
		}
	}
	public boolean flooded()
	{
		// tracks if all numbers in grid are the same
		boolean flooded = true;
		Node rowMarker = root;
		int compare = root.getData();
		//cycles through the whole grid
		while (rowMarker != null && flooded == true) 
		{
			Node temp = rowMarker;
		
			while (temp != null && flooded == true)
			{
				//checks each node to see if it has the same number
				if(temp.getData() != compare)
					flooded = false;
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
		}
		return flooded;
	}
	
	public void flood(int change, Node temp)
	{
		// keeps track of the original node data to compare to
		int original = temp.getData();
		//sets node to new number
		temp.setData(change);
		// checks all adjacent nodes for original number and floods them recursively
		if(temp.getRight() != null && temp.getRight().getData() == original)
			flood(change, temp.getRight());
		if(temp.getDown() != null && temp.getDown().getData() == original)
			flood(change, temp.getDown());
		if(temp.getLeft() != null && temp.getLeft().getData() == original)
			flood(change, temp.getLeft());
		if(temp.getUp() != null && temp.getUp().getData() == original)
			flood(change, temp.getUp());
	}

	public Node getRoot() {
		return root;
	}
}
	

