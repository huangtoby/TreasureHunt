package TreasureHunting;

public class TobyKevinRoom 
	{
	
	public static boolean[][] lights ;
	private static String map;
	
	public static void main(String[] args)
	{
		lights = new boolean[5][5];
		String[][] field = startGame(lights);
		createGrid(field);
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

	public static void changeLights()
	{

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
		for(int i = 0; i < field[0].length-1; i++){
			map += "____";
		}
		map += "___\n";
		for(int i = 0; i < field.length; i++){
			for(int textRow = 0; textRow < 3; textRow++){
				for(int j = 0; j < field[i].length; j++){
					String str = "|" + i + " " + j;
					if(textRow == 1){
						str = "| " + field[i][j] + " ";
					}if(textRow == 2){
						str = "|___";
					}
					map += str;
				}
			map += "|\n";
			}
		}
		CaveExplorer.print(map);
	}
}
