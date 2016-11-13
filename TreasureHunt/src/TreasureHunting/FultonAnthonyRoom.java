package TreasureHunting;

public class FultonAnthonyRoom {

	public static void mines(){
		boolean[][] mines = new boolean[15][15];
		plantMines(mines);
		String[][] field = createField(mines);
		printPic(field);
	}
	
	private static String[][] createField(boolean[][] mines) {
		String[][] field = new String[mines.length][mines[0].length];
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				if(mines[row][col])field[row][col] = "x";
				else{
					field[row][col] = countNearby(mines,row,col);
				}
			}
		}
		return field;
	}

	private static String countNearby(boolean[][] mines, int row, int col) {
		int count = 0;
		for(int i = -1; i < 2; i++){
			for(int j = -1; j < 2; j++){
				count += isValidAndTrue(mines, row+i, col+j);
			}
		}
		return ""+count;
	}

	private static int isValidAndTrue(boolean[][] mines, int i, int j) {
		if(i >= 0 && i < mines.length && j >= 0 && j < mines[0].length && mines[i][j])
			return 1;
		else return 0;
	}

	private static void plantMines(boolean[][] mines) {
		int numberOfMines = 10;
		while(numberOfMines > 0){
			int row = (int)(Math.random() * mines.length);
			int col = (int)(Math.random() * mines[0].length);
			//this prevents the same mine being selected twice
//			while(mines[row][col]){
//				row = (int)(Math.random() * mines.length);
//				col = (int)(Math.random() * mines[0].length);
//			}
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines--;
			}
		}
	}

	public static void makePic(){
		String[][] pic = new String[10][8];
		for(int row = 0; row < pic.length; row++){
			//populate with coordinates
			for(int col = 0; col < pic[row].length; col++){
				pic[row][col] = "";
			}
		}
		
		//top row and bottom row should be "_"
		for(int col = 0; col < pic[0].length; col++){
			pic[0][col] = "_";
			pic[pic.length-1][col] = "_";
		}
		
		//first and last column is "|"
		for(int row = 1; row < pic.length; row++){
			pic[row][0] = "|";
			pic[row][pic[0].length-1] = "|";
		}
		
//		//sun
//		pic[1][1] = "-";
//		pic[2][2] = "|";
//		pic[1][2] = "0";
//		pic[1][3] = "-";
//		pic[2][1] = "/";
//		pic[2][3] = "";
		
		
		//grassy field
		for(int row = 5; row < 7; row++){
			for(int col = 1; col < pic[row].length-1; col++){
				pic[row][col] = "w";
			}
		}
	}
	
	public static void printPic(String[][] pic){
		for(String[] row : pic){
			for(String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}

}
