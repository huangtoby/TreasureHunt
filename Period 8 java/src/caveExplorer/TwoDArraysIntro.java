package caveExplorer;

import java.util.Arrays;

public class TwoDArraysIntro {

	public static void main(String[] args) {
		String[] xox = {"x","o","x","o","x"};
		System.out.println(Arrays.toString(xox));
		//a 1D array prints a horizontal String
		
		String[][] arr2D = new String[5][4];
		System.out.println("The height is "+arr2D.length);
		System.out.println("The width is "+arr2D[0].length);
		for(int row = 0; row < arr2D.length; row++){
			//put an entire array into each row
			String[] rowContent = 
					new String[arr2D[0].length];
			//populate with coordinates
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col] = ("("+row+", "+col+")");
			}
		}
		//print the 2D array
		//every element in a 2D array IS itself an array
		//so a for-each loop looks like this
		for(String[] row: arr2D){
			System.out.println(Arrays.toString(row));
		}
	}
}
