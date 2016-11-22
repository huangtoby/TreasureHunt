package TreasureHunting;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoomPd8[][] caves;
	
	public static Scanner in;
	
	public static CaveRoomPd8 currentRoom;
	
	public static InventoryNockles inventory;
	

	public static boolean Key1 = false;
	public static boolean Key2 = false;
	private static boolean Looped = true;

	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		caves = new CaveRoomPd8 [4][4];
		for(int row = 0; row < caves.length; row++){
			for(int col = 0; col < caves[row].length; col++){
				caves[row][col] = new CaveRoomPd8("This room has coordinates " + row + ", " + col);
			}
		}
		currentRoom = caves[2][3];
		caves[3][3] = new EventRoom("This is where you found the map.", new GameStartEvent());
		caves[0][3] = new EventRoom("This is where you played minesweeper.", new FultonAnthonyRoom());
		caves[3][2] = new EventRoom("This is where you got into the cave.", new TobyKevinRoom());
		if(currentRoom == caves[1][3]){
			print("you duied");
		}
		currentRoom.enter();

		caves[2][3].setConnection(CaveRoomPd8.SOUTH, caves[3][3], new Door());//start, lights out
		caves[3][3].setConnection(CaveRoomPd8.WEST, caves[3][2], new Door());
		caves[3][2].setConnection(CaveRoomPd8.NORTH, caves[2][2], new Door());//death room
		caves[3][2].setConnection(CaveRoomPd8.WEST, caves[3][1], new Door());
		caves[3][1].setConnection(CaveRoomPd8.NORTH, caves[2][1], new Door());
		caves[3][1].setConnection(CaveRoomPd8.WEST, caves[3][0], new Door());//death room
		caves[2][1].setConnection(CaveRoomPd8.NORTH, caves[1][1], new Door());
		caves[1][1].setConnection(CaveRoomPd8.NORTH, caves[0][1], new Door());//treasure room
		caves[1][1].setConnection(CaveRoomPd8.EAST, caves[1][2], new Door());
		caves[1][2].setConnection(CaveRoomPd8.NORTH, caves[0][2], new Door());//death room
		caves[1][2].setConnection(CaveRoomPd8.EAST, caves[1][3], new Door());
		caves[1][3].setConnection(CaveRoomPd8.NORTH, caves[0][3], new Door());//minesweeper room
		caves[0][1].setConnection(CaveRoomPd8.WEST, caves[0][0], new Door());//escape
		caves[0][1].setConnection(CaveRoomPd8.EAST, caves[0][2], new Door());//death room
		
		inventory = new InventoryNockles();
		startExploring();
	}

	private static void startExploring() {
		while(Looped){
			if(currentRoom == caves[1][1]){ 
				Looped = false;
			}
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			act(input);
		}
		if(Key1 == true && Key2 == true){
			print("With both the keys, you disabled the treasure room's traps, and made off with the treasure!");
		}else {
			print("Without both keys, you were injured by the treasure room's booby traps. You weren't able to escape.");
		}
	}
	
	private static void act(String input) {
		currentRoom.interpretAction(input);
	}

	public static void print(String a){
		System.out.println(a);
	}
}