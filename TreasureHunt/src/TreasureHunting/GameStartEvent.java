package TreasureHunting;

public class GameStartEvent implements Playable {
	
	private static final String[] SEQUENCE_1 = {"<A spectral being appears through the wall>",
			"Greetings traveler, it has been a long time since a human have entered this cave.",
			"'You notice that the spectral being carries a whip, and the faint sounds of trumpets far off.", 
			"It is too late for you to escape now. All you can do is find the treasure without dying."};
	private static final String[] SEQUENCE_2 = {"I may not be able to help much but before I died, I made an outline of the ruins.",
			"Beware the treasure room. Without the 'keys'... well, you'll end up looking like me. Good Luck."};


	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Have you come for the cursed treasure of these ancient ruines?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			CaveExplorer.print("Well your exit ain't opening anytime soon. So what'll it be?");
		}
		readSequence(SEQUENCE_2);
		CaveExplorer.inventory.setHasMap(true);
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}
}
