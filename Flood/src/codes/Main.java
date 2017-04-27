package codes;


public class Main {

	public static void main(String[] args) {
		// makes game board
		Grid grid = new Grid(5);
		// tracks turn number
		int turnCounter = 1;
		// allows the user to play until the player has won or  ran out of turns
		while(turnCounter < 26 && grid.flooded() == false)
		{
			System.out.println("Turns: " + turnCounter + " / 25");
			grid.display();	
			System.out.print("Please enter the number you would like to flood with: ");
			int choice = Utility.errorTrapInt(6, 1);
			//floods the grid from the top left corner with the chosen number
			grid.flood(choice, grid.getRoot());
			turnCounter++;
		}
		if(grid.flooded() == true)
			System.out.println("You won!");
		else
			System.out.println("You lost");
	}

}
