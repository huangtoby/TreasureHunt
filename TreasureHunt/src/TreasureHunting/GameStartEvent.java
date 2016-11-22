package TreasureHunting;

public class GameStartEvent implements Playable {
	
	private static final String[] SEQUENCE_1 = {"<A spectral being appears through the wall>",
			"Greetings traveler, it has been a long time since a human have entered this cave.",
			"My name is Casper and I used to be an explorer just like you.", 
			"After unsuccessfully trying to escape, I was cursed to roam this cave until one day a greater explorer arrives."};
	private static final String[] SEQUENCE_2 = {"I may not be able to help much but this map is the basic outline of this cave.",
			"Be careful of various traps and deadends. Good luck to you."};

	public GameStartEvent() {
	}

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Have you come for the cursed treasure of the ancient ruines?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			CaveExplorer.print("I beg of your assistance to lift this curse. Please say yes.");
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
