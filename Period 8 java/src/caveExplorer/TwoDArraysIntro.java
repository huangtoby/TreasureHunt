package caveExplorer;

public class TwoDArraysIntro {

	public static void main(String[] args) {
	
//		boolean[][] mines = new boolean[6][6];
//		plantMines(mines);
//		String[][] field = createField(mines);
//		PrintPic(field);
		String[][] field = new String[17][21];
		makeBorder(field);
		makeInsides(field);
		PrintPic(field);
	}
			
	
	


	private static void makeBorder(String[][] field) {
		for(int row = 0; row < field.length; row += (field.length-1)){
			for( int col = 0; col < field[0].length; col++){
				field[row][col] = "_";
			}
		}
		for(int row = 1; row < field.length; row++){
			for( int col = 0; col < field[0].length; col += (field[0].length-1) ){
				field[row][col] = "|";
			}
		}
	}
	
	private static void makeInsides(String[][] field){
		for(int row = 1; row < field.length-1; row++){
			for( int col = 4; col < field[0].length; col += 4 ){
				if(row % 4 == 0){
					for( int div = 1; div < field[0].length; col++){
						if(div % 4 == 0){
							field[div][col] = "|";
						}else{
							field[div][col] = "_";
						}
					}
				}
				field[row][col] = "|";
			}
		}
	}
}	
	


//		private static String[][] createField(boolean[][] mines) {
//		String[][] field = 
//				new String[mines.length][mines[0].length];
//			for(int row = 0; row < field.length; row++){
//				for(int col = 0; col< field[row].length; col++){
//					if(mines[row][col])field[row][col] = "x";
//					else{
//						field[row][col] = countNearby(mines,row,col);
//					}
//				}
//			}	        
//		return field;
//		}
//
//
//		private static String countNearby(boolean[][] mines, int row, int col) {
////			METHOD 1				
////			for(int r = row -1; r <= row + 1; r++){
////				for(int c = col - 1; c <= col+1; c++){
////					if(r >= 0 && r < mines.length &&
////							c >= 0 && c < mines[0].length){
////						
////					}
////				}
////			}
//			//method 2
//			//THIS METHOD ONLY CONSIDERS ACTUAL ELEMENTS
////			int count = 0;
////			for(int r = 0; r < mines.length;r++){
////				for(int c = 0; c < mines[r].length;c++){
////					if(Math.abs(r-row)+Math.abs(c-col) == 1 &&
////							mines[r][c]){
////						count++;
////					}
////				}
////			}
////			return ""+count;
//			//METHOD 3
//			//this method allows you to be specific 
//			//for example, you only want North and East
//			int count = 0;
//			count += isValidAndTrue(mines,row-1,col);
//			count += isValidAndTrue(mines,row+1,col);
//			count += isValidAndTrue(mines,row,col-1);
//			count += isValidAndTrue(mines,row,col+1);
//			return ""+count;
//		}	
//
//
//		private static int isValidAndTrue(boolean[][] mines, int i, int j) {
//			if(i >= 0 && 
//					i < mines.length && 
//					j >= 0 && 
//					j < mines[0].length &&
//					mines[i][j]){
//				return 1;
//			}
//			return 0;
//		}
//
//
//		private static void plantMines(boolean[][] mines) {
//		int numberOfMines = 10;
//		while (numberOfMines > 0){
//			int row  = (int)(Math.random() * mines.length);
//			int col = (int)(Math.random() * mines[0].length);
//			//this prevents the same mine from being selected 
//			//twice
////			while(mines[row][col]){
////				row = (int)(Math.random() * mines.length);
////				col = (int)(Math.random() * mines[0].length);
////			}
//			
//			 	if(!mines[row][col]){
//			 		mines[row][col]=true;
//			 		numberOfMines--;
//			 	}
//			}
//		}