package TreasureHunting;

import java.util.Scanner;

public class TobyKevinRoom implements Playable
	{
	public static String[][] lights ;
	private static String map;
	public static Scanner input;
	
	public static void main(String[] args){
		new TobyKevinRoom().play();
	}
	
	public void play()
	{
		input = new Scanner(System.in);
		lights = new String[5][5];
		String[][] field = startGame(lights);
		createGrid(field);
		boolean solved = true;
		A : while(solved)
		{
			changeLights(field);
			if(checkWin() == true)
			{
				solved = false;
				break A;
			}
			
		}
		CaveExplorer.Key2 = true;
		System.out.println("You have 'beaten' this game and obtained key(1/2)");
		
	}

	private static boolean checkWin() 
	{
		System.out.println("Continue?");
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

	public static void changeLights(String[][] field)
	{
		System.out.print("Enter the number of a box (1-25)");
		int number = 0;
		
		while(!input.hasNextInt())
		{
			System.out.print("That is not a valid input.");
			input.next();
		}
		number = input.nextInt();
		if(number > 25||number < 1)
		{
			System.out.println("Please enter a valid number between 1 and 25");
		}
		else
		{
			System.out.println("you have swapped "+number);
		}
		swap(field, number);
		if(number != 1 || number != 6 ||number != 11 || number != 16 || number != 21)
		{
			swap(field, number - 1);
		}
		if(number != 5 || number != 10 ||number != 15 || number != 20 || number != 25)
		{
			swap(field, number + 1);
		}
		swap(field, number - 5);
		swap(field, number + 5);
		createGrid(field);
		checkWin();
	}

	private static void swap(String[][] input, int number) 
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

					System.out.println("You have unlocked the hidden passage to the cave");
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


