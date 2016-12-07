package TreasureHunting;

public class CheckWinFulton {
	private static String map;
	
	public static boolean checkWin(String[][] field) {
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				if(field[row][col] != "x" && FultonAnthonyRoom.getIsChecked()[row][col] == false){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void createGrid(String[][] array) {
		map = " ";
		for(int i = 0; i < array[0].length-1; i++){
			map += "____";
		}
		map += "___\n";
		for(int i = 0; i < array.length; i++){
			for(int textRow = 0; textRow < 3; textRow++){
				for(int j = 0; j < array[i].length; j++){
					String str = "|" + i + " " + j;
					if(textRow == 1){
						str = "| " + array[i][j] + " ";
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
