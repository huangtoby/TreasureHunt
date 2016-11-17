package TreasureHunting;

import java.util.Scanner;

public class FultonAnthonyRoom {
	private static boolean[][] isChecked;
	public static boolean[][] mines;
	private static String[][] arr;
	private static String map;
	public static Scanner in;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		mines = new boolean[5][5];
		isChecked = new boolean[5][5];
		plantMines(mines);
		String[][] field = createField(mines);
		currentArray();
		startGame(field);
	}
	
	private static void currentArray(){
		arr = new String[5][5];
		for(int i = 0; i < arr.length; i++){
			for( int j = 0; j < arr.length; j++){
				arr[i][j] = "?";
			}
		}
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
		int numberOfMines = 4;
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
	
	private static boolean isValid(String input) {
		String[] validKey = {"1","2","3","4","5","6","7","8","9","0","warn","normal"};
		for(String key: validKey){
			if(input.toLowerCase().equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void startGame(String[][] field){
		boolean inLoop = true;
		boolean win = true;
		createGrid(field);
		createGrid(arr);
		while(inLoop){
			String row = in.nextLine();
			if(isValid(row)){
				CaveExplorer.print("You inputed " + row);
				String col = in.nextLine();
				if(isValid(col)){
					CaveExplorer.print("You inputed " + col);
					CaveExplorer.print("You inputed coordiantes " +"("+ row +","+ col+")");
					if(Integer.parseInt(row) < field.length && Integer.parseInt(row) > -1 
							&& Integer.parseInt(col) > -1 && Integer.parseInt(col) < field[0].length){
						if(field[Integer.parseInt(row)][Integer.parseInt(col)] == "x"){
							createGrid(field);
							win = false;
							inLoop = false;
						}else{
							clearBlock(field, Integer.parseInt(row), Integer.parseInt(col));
							createGrid(arr);
						}
					}else{
						CaveExplorer.print("Please input something that exists"+"\n"+"Try Again");
					}
					if(checkWin(field)){
						inLoop = false;
					}
				}
			}
		}
		if(win){
			CaveExplorer.print("Congradulation you have won this game and obtained key");
		}else{
			CaveExplorer.print("You ded");
		}
	}

	private static boolean checkWin(String[][] field) {
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[0].length; col++){
				if(field[row][col] != "x" && isChecked[row][col] == false){
					return false;
				}
			}
		}
		return true;
	}

	private static void clearBlock(String[][] field, int r, int c) {
//		if(Integer.parseInt(field[r][c]) == 0 && isChecked[r][c] == false){
//			arr[r][c] = field[r][c];
//			isChecked[r][c] = true;
//			for(int i = -1; i < 2; i++){
//				for(int j = -1; j < 2; j++){
//					if(r > 0 && r < field.length && c > 0 && c < field[0].length){
//						if(Integer.parseInt(field[r+i][c+j]) != Integer.parseInt(field[r][c])){
//							clearBlock(field, r+i, c+j);
//						}
//					}
//				}
//			}
//		}else{
		CaveExplorer.print("Would you like to reveal the cell or mark it as a mine?\n"+
				"Be aware that when a cell is revealed, it cannot be marked as a mine.");
		String response = in.nextLine();
		String output = response.toLowerCase();
		if(output.equals("reveal") && isChecked[r][c] == false){
			arr[r][c] = field[r][c];
			isChecked[r][c] = true;
		}else if(output.equals("mark") && isChecked[r][c] == false){
			arr[r][c] = "!";
		}else{
			CaveExplorer.print("Please input 'mark' or 'reveal'");
		}
//		}
	}

	private static String toLowerCase(String nextLine) {
		// TODO Auto-generated method stub
		return null;
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
