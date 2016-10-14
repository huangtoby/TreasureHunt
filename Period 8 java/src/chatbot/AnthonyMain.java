package chatbot;

import java.util.Scanner;

public class AnthonyMain {
	
	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;
	//list all the chat bots available under this class
	static Chatbot school;

	public static void main(String[] args) {
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
		}
	
	public static void createFields(){
		input = new Scanner(System.in);
		user = "";
		school = new AnthonySchool();
	}
	
	public static void promptName() {
		print("enter your name");
		user = input.nextLine();
		print("Glad to meet you, "+user+ "."
				+"\nFor the rest of the time," 
				+"\nI will call you "+user+ "."
				+"\nYou may call me Computer."
				+"\nWe should become friends." );
	}
	
	public static void promptForever(){
		inMainLoop = true;
		while(inMainLoop){
			print("Hi, "+user+", How Are You?");
			response = promptInput();
			
			//response to how you feel
			if(findKeyword(response, "good", 0) >= 0){
				print("That's wonderful. "
						+"So glad you feel good.");
			
			}
			else if(response.indexOf("school") >= 0){
				print("That's wonderful, "+user+", So glad you feel good.");
				inMainLoop = false;
				school.talk();

			}
		}
	}
	public static String promptInput(){
		String userInput = input.nextLine();
		return userInput;
	}
	public static int findKeyword(String searchString,
			String keyword,
			int startPsn) {
		//delete white space
		searchString = searchString.trim();
		//make lowercase
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		System.out.println("The Phrase Is "+ searchString);
		System.out.println("The Keyword Is "+ keyword);
		//find first position of key word
		int psn = searchString.indexOf(keyword);
		System.out.println("The Keyword was found at "+psn);
		
		//keeps searching until context keyword found
		while(psn >= 0){
			//assume preceded and followed by space
			String before = " ";
			String after =" ";
			//check character in front, if it exists.
			if(psn > 0){
				before = 
						searchString.substring(psn-1, psn);
				System.out.println("The Character before is "
						+before);
			}
			//check if there is a character
			//after the keyword
			if(psn+ keyword.length() < searchString.length()){
				after = 
						searchString.substring(psn + 
								keyword.length(),
								psn + keyword.length() + 1);
				System.out.println("The Character after is "
						+after);
			}
			if (before.compareTo("a") < 0 &&
					after.compareTo("a") < 0 &&
					noNegations(searchString, psn)){
				System.out.println("Found "+keyword+" at "
						+psn);
				return psn;
			}else{
				//psn+1 is one space after our current
				//psn, so this is the next word
				psn = searchString.indexOf(keyword,psn+1);
				System.out.println("Did not find "+keyword
						+", checking position "
						+psn);
			}
		}
		
		return -1;
	}
	/**
	 * This is a helper method.A helper method is a method
	 * designed for "helping" a larger method.Because of this, 
	 * helper methods are generally private because they are 
	 * only used by the methods they are helping.Also when 
	 * you do your project, i expect to see helper methods
	 * because they also make code more readable
	 * 
	 * @param searchString (always lowercase)
	 * @param psn
	 * @return "true" if there is no negation words 
	 * in front of psn
	 */
	private static boolean noNegations(String searchString, 
			int psn) {
		//check to see if the word no is in front 
		//of psn
		//check to see if there are 3 spaces in front
		//then check to see if "no" is there 
		if(psn - 3 >= 0 && 
				searchString.substring(psn-3,psn)
				.equals("no ")){
			return false;
		}
		if(psn - 4 >= 0 && 
				searchString.substring(psn-4,psn)
				.equals("not ")){
			return false;
		}
		if(psn - 6 >= 0 && 
				searchString.substring(psn-6,psn)
				.equals("never ")){
			return false;
		}
		if(psn - 4 >= 0 && 
				searchString.substring(psn-4,psn)
				.equals("n't ")){
			return false;
		}
		return true;
	}

	
	
	public static void print(String s){
		String printString = "";
		int cutoff = 35;
		//check for words to add
		//IOW s has a length > 0
		while(s.length() > 0){
			String cut="";
			String nextWord = "";
			//check to see if the next word
			//will fit on the line AND
			//there must still be words to add
			while(cut.length() + nextWord.length()
			< cutoff && s.length() > 0){
			//add the next word to the line
				cut += nextWord;
				
				s = s.substring(nextWord.length());
				
				//identify the following word without spaces
				int endOfWord = s.indexOf(" ");
				//if there are no more spaces,
				//this is the last word, so add the whole thing
				if(endOfWord == -1){
					endOfWord = s.length() - 1;//-1 for index
				}
				
				nextWord = s.substring(0, endOfWord+1);
				
			}
		
		printString += cut+"\n";
		
		}	
	
		System.out.println(printString);
		
	}
	
}	

