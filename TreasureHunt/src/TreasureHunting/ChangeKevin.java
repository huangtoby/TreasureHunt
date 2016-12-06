package TreasureHunting;

public class ChangeKevin {

	public static void changeLights(String[][] field)
	{
		System.out.print("Enter the number of a box (1-25)");
		int number = 0;
		
		while(!TobyKevinRoom.input.hasNextInt())
		{
			System.out.print("That is not a valid input.");
			TobyKevinRoom.input.next();
		}
		number = TobyKevinRoom.input.nextInt();
		if(number > 25||number < 1)
		{
			System.out.println("Please enter a valid number between 1 and 25");
		}
		else
		{
			System.out.println("you have swapped "+number);
		}
		TobyKevinRoom.swap(field, number);
		if(number != 1 || number != 6 ||number != 11 || number != 16 || number != 21)
		{
			TobyKevinRoom.swap(field, number - 1);
		}
		if(number != 5 || number != 10 ||number != 15 || number != 20 || number != 25)
		{
			TobyKevinRoom.swap(field, number + 1);
		}
		TobyKevinRoom.swap(field, number - 5);
		TobyKevinRoom.swap(field, number + 5);
		CreateToby.createGrid(field);
		System.out.println("Continue?");
		TobyKevinRoom.checkWin();
	}
}
