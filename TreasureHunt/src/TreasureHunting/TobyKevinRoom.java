package TreasureHunting;

public class TobyKevinRoom 
	{
	
	public static boolean[][] lights ;

	public static void main(String[] args)
	{
		lights = new boolean[5][5];
		startGame(lights);
		String[][] field = createField(lights);
	}

	public static String[][] createField(boolean[][]lights)
	{
		String[][] field = new String[lights.length][lights[0].length];
		for(int row = 0; row < field.length; row++)
		{
			for(int col = 0; col < field[row].length; col++)
			{
				field[row][col] = "X";
			}
		}
		return field;
	}


	public static boolean[][] startGame(boolean [][] lights)
	{	
		boolean[][] field = new boolean[lights.length][lights[0].length];
		for(int row = 0; row < field.length; row++)
		{
			for(int col = 0; col < field[row].length; col++)
			{
				int random = (int) (Math.random()* 1) + 0;
				if (random == 1)
				{
				field[row][col] = true;
				}
				else
				{
					field[row][col] = false;
				} 
			}
		}
		return field;
	}

	public static void changeLights()
	{

	}

	public static void printPic(String[][] pic)
	{
		for(String[] row : pic)
		{
			for(String col: row)
			{
			System.out.print(col);
			}
			System.out.println();
		}
	}

}
