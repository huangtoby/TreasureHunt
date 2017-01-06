package TreasureHunting;

public class CreateToby {
	
	private static String map;
	
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
