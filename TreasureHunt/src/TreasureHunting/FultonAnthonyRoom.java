package TreasureHunting;

import java.util.Scanner;

import TreasureHunting.Playable;

public class FultonAnthonyRoom implements Playable{
	private static boolean[][] isChecked;
	public static boolean[][] mines;
	private static String[][] arr;
	public static Scanner in;
	private String[][] field;
	public  FultonAnthonyRoom(){
		in = new Scanner(System.in);
		mines = new boolean[10][10];
		setIsChecked(new boolean[10][10]);
		plantMines(mines);
		field = createField(mines);
		currentArray();
		
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
					field[row][col] = countNearbyAnthony.countMines(mines,row,col);
				}
			}
		}
		return field;
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
	
//	public static void printPic(String[][] pic){
//		for(String[] row : pic){
//			for(String col: row){
//				System.out.print(col);
//			}
//			System.out.println();
//		}
//	}
	
	private static boolean isValid(String input) {
		String[] validKey = {"1","2","3","4","5","6","7","8","9","0"};
		for(String key: validKey){
			if(input.toLowerCase().equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		new FultonAnthonyRoom().play();
	}
	
	public void play(){
		boolean inLoop = true;
		boolean win = false;
//		createGrid(field);
		CheckWinFulton.createGrid(arr);
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
						CaveExplorer.print("Would you like to reveal the cell or mark it as a mine?\n");
						while(true){
							String response = in.nextLine();
							String output = response.toLowerCase();
							if(output.equals("reveal")){
								if(field[Integer.parseInt(row)][Integer.parseInt(col)] == "x"){
									CheckWinFulton.createGrid(field);
									CaveExplorer.print("You ded");
									inLoop = false;
								}else{
									clearBlock(field, Integer.parseInt(row), Integer.parseInt(col));
									CheckWinFulton.createGrid(arr);
									break;
								}	
							}else if(output.equals("mark")){
								mark(field, Integer.parseInt(row), Integer.parseInt(col));
								CheckWinFulton.createGrid(arr);
								break;
							}else if(output.equals("neither")){
								win = true;
								inLoop = false;
								break;
							}else{
								CaveExplorer.print("Please input 'mark' or 'reveal'");						
							}
						}
					}else{
						CaveExplorer.print("Please input something that exists"+"\n"+"Try Again");
					}
					if(CheckWinFulton.checkWin(field)){
						win = true;
						inLoop = false;
					}
				}
			}
		}
		if(win){

			CaveExplorer.print("With this game completed, you obtained the platinum skull.\n");
			CaveExplorer.print("All that's left is to find the treasure.");
			CaveExplorer.Key1 = true;

		}else{
		CaveExplorer.print("you have failed");
		}
	}

	private static void clearBlock(String[][] field, int r, int c) {
		if(getIsChecked()[r][c] == false){
		arr[r][c] = field[r][c];
		getIsChecked()[r][c] = true;
		}
	}
	
	private static void mark(String[][] field, int r, int c){
		arr[r][c] = "!";
	}

	public static boolean[][] getIsChecked() {
		return isChecked;
	}

	public static void setIsChecked(boolean[][] isChecked) {
		FultonAnthonyRoom.isChecked = isChecked;
	}
}
