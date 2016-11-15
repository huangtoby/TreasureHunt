package TreasureHunting;

import java.util.Scanner;

public class FultonAnthonyRoom {
	public static boolean[][] mines;
	private static String map;
	private static String[][] arr;
	private static boolean[][] isChecked;
	public static Scanner in;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		mines = new boolean[10][10];
		isChecked = new boolean[10][10];
		plantMines(mines);
		String[][] field = createField(mines);
		currentArray();
		callPos(field);
		
	}
	
	private static void currentArray(){
		arr = new String[10][10];
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
	
	public static void callPos(String[][] field){
		boolean inLoop = true;
		while(inLoop){
			createGrid(arr);
			String row = in.nextLine();
			int row2 = Integer.parseInt(row);
			CaveExplorer.print("You inputed " + row);
			String col = in.nextLine();
			int col2 = Integer.parseInt(col);
			CaveExplorer.print("You inputed " + col);
			CaveExplorer.print("You inputed coordiantes " +"("+ row +","+ col+")");
			if(row2 < field.length && col2 < field[0].length){
				if(field[row2][col2] == "x"){
					inLoop = false;
				}else{
					clearBlock(field, row2, col2);
				}
			}else{
				CaveExplorer.print("Please input something that exists"+"\n"+"Try Again");
			}
		}
		CaveExplorer.print("You ded");
	}
	
	private static void clearBlock(String[][] field, int r, int c) {
		if(Integer.parseInt(field[r][c]) == 0){
			arr[r][c] = field[r][c];
			isChecked[r][c] = true;
			for(int i = -1; i < 2; i++){
				for(int j = -1; j < 2; j++){
					if(r > 0 && r < field.length && c > 0 && c < field[0].length){
						if(Integer.parseInt(field[r+i][c+j]) == Integer.parseInt(field[r][c])){
							arr[r][c] = field[r][c];
						}else{
							clearBlock(field, r+i, c+j);
						}
					}
				}
			}
		}else{
			arr[r][c] = field[r][c];
			isChecked[r][c] = true;
		}
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
