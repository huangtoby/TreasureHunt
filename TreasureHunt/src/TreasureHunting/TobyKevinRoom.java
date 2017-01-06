package TreasureHunting;

import java.util.Scanner;

public class TobyKevinRoom implements Playable
	{
	public static String[][] lights ;
	
	public static Scanner input;
	
	public static void main(String[] args){
		new TobyKevinRoom().play();
	}
	
	public void play()
	{
		input = new Scanner(System.in);
		lights = new String[5][5];
		String[][] field = startGame(lights);
		CreateToby.createGrid(field);
		boolean solved = true;
		A : while(solved)
		{
			ChangeKevin.changeLights(field);
			if(checkWin() == true)
			{
				solved = false;
				break A;
			}
			
		}
		CaveExplorer.Key2 = true;
		System.out.println("You have unlocked the hidden passage to the cave, along with a hidden panel in the wall,\n revealing an unusual golden skull.");
		System.out.println("You have 'beaten' this game.");
		
	}

	public static boolean checkWin() 
	{
		
		if(input.nextLine().toLowerCase().indexOf("yes")<0)
		{
			return true;
		}
		return false;
		
	}

	public static String[][] startGame(String[][] lights2)
	{	
		String[][] field = new String[lights2.length][lights2[0].length];
		for(int row = 0; row < field.length; row++)
		{
			for(int col = 0; col < field[row].length; col++)
			{
				int random = (int) (Math.random()* 2) + 1;
				if (random == 2)
				{
					field[row][col] = "O";
				}
				else
				{
					field[row][col] = "X";
				} 
			}
		}
		return field;
	}

	public static void swap(String[][] input, int number) 
	{
		int colNumber = (number%5) - 1;
		if(number%5 == 0)
		{
			colNumber = 4;
		}
		int rowNumber = (int)(number/5);
		if(number == 5 || number == 10 || number == 15 ||number ==  20 ||number ==  25)
		{
			rowNumber = (number/5) - 1;
		}
		if(number < 0 || number > 25 || rowNumber < 0 || rowNumber > 4 || colNumber < 0 ||colNumber > 4)
		{
			return;
		}
		
		for(int row = 0; row < input.length; row++)
		{
			for(int col = 0; col < input[row].length; col++)
			{
				if(input[rowNumber][colNumber] == "O")
				{

					
					CaveExplorer.Key2 = true;
					input[rowNumber][colNumber] = "X";
					break;
				}else
				{
					if(input[rowNumber][colNumber] == "X")
					{
						input[rowNumber][colNumber] = "O";
					}

				}
			}
		}
	}

	public static void printPic(String[][] field)
	{
		for(String[] row : field)
		{
			for(String col: row)
			{
			System.out.print(col);
			}
			System.out.println();
		}
	}
	
}


