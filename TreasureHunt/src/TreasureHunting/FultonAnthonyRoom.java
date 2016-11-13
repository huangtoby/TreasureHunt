package TreasureHunting;

public class FultonAnthonyRoom {
	public static boolean[][] mines;
	private static String map;
	
	public static void main(String[] args){
		mines();
	}

	public static void mines(){
		mines = new boolean[10][10];
		plantMines(mines);
		String[][] field = createField(mines);
		printPic(field);
		createGrid(field);
	}
	
	private static String[][] createField(boolean[][] mines) {
		String[][] field = new String[mines.length][mines[0].length];
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				if(mines[row][col]){
					field[row][col] = "x";
				}
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
		int numberOfMines = 17;
		while(numberOfMines > 0){
			int row = (int)(Math.random() * mines.length);
			int col = (int)(Math.random() * mines[0].length);
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines--;
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
	
	public static void createGrid(String[][] field) {
		map = " ";
		for(int i = 0; i < field[0].length-1; i++){
			map += "____";
		}
		map += "___\n";
		String mid = "|   ";
		String end = "|___";
		for(int row = 0; row < field.length; row++){
			for(int layer = 0; layer < 3; layer++){
				for(int cell = 0; cell < field[row].length; cell++){
					if(layer == 2){
						map+= end;
					}else{	
					map += mid;
					}
					}
				map += "|\n";	
				}
//			for(boolean[] row: mines){
//			for(int textRow = 0; textRow < 3; textRow++){
//				for(boolean cr : row){
//					String str = "|___";
//					map += str;
//				}
//			map += "|\n";
//			}
//		}
		}
		CaveExplorer.print(map);
	}
		
		public static void minePlanting(String[][] field, int mines){
			
			for(int num = 0; num < mines; num++){
				
			}
		}

		
	
	
}
