package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static Period8CaveRoom[][] caves;
	public static Scanner in;
	public static Period8CaveRoom currentRoom;
	public static InventoryNockles inventory;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		caves = new Period8CaveRoom[5][5];
		for(int row = 0; row < caves.length; row++){
			for(int col = 0; col < caves[0].length;col++){
				caves[row][col] = new Period8CaveRoom("This room has coordinates, "+
						row+","+col);
			}
		}
		currentRoom = caves[1][2];
		currentRoom.enter();
		caves[1][2].setConnection(caves[1][1]);
		caves[1][2].setConnection(caves[2][2]);
		caves[1][2].setConnection(caves[1][3]);
		
		
		
		
		
		
	}
}
