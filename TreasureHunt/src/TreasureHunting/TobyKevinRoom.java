package TreasureHunting;

import java.util.Scanner;

public class TobyKevinRoom 
	{
	public static boolean[][] lights ;
	private static String map;
	public static Scanner input;
	
	public static void main(String[] args)
	{
		input = new Scanner(System.in);
		lights = new boolean[5][5];
		String[][] field = startGame(lights);
		createGrid(field);
		boolean solved= false;
		while(solved == false)
		{
			changeLights(solved);
		}
	}

	public static String[][] startGame(boolean [][] lights)
	{	
		String[][] field = new String[lights.length][lights[0].length];
		for(int row = 0; row < field.length; row++)
		{
			for(int col = 0; col < field[row].length; col++)
			{
				int random = (int) (Math.random()* 2) + 1;
				if (random == 2)
				{
					field[row][col] = "X";
				}
				else
				{
					field[row][col] = "O";
				} 
			}
		}
		return field;
	}

	public static void changeLights(boolean solved)
	{
		System.out.print("Enter the number of a box (1-25)");
		while(!input.hasNextInt()) input.next();
		{
			System.out.print("Please enter a valid number");
		}
		if(input.nextInt() < 1 || input.nextInt() > 25)
		{
			System.out.print("Please enter a number between 1-25");
		}
		//method for changing
		if()
		{
			solved = true;
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
	public static void createGrid(String[][] field)
	{
		map = " ";
		for(int i = 0; i < field[0].length-1; i++)
		{
			map += "______";
		}
		map += "_____\n";
		for(int i = 0; i < field.length; i++)
		{
			for(int textRow = 0; textRow < 3; textRow++)
			{
				for(int j = 0; j < field[i].length; j++)
				{
					int boxNumber = i*5+i/5+j+1;
					String str = "|  " + boxNumber + "  ";
					if (boxNumber > 9 && boxNumber < 100)
					{
						str = "|  " + boxNumber + " ";
					}
					if (boxNumber <= 10 && boxNumber >=99)
					{
						str = "|  " + boxNumber + "  ";
					}
					if(textRow == 1)
					{
						str = "|  " + field[i][j] + "  ";
					}
					if(textRow == 2)
					{
						str = "|_____";
					}
					map += str;
				}
				map += "|\n";
			}
		}
		CaveExplorer.print(map);
	}
}
