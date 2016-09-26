package introduction;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;

	public static void main(String[] args) {
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
		}
	
	public static void promptName() {
		print("enter your name");
		user = input.nextLine();
		print("Glad to meet you, "+user + "."
				+"\nFor the rest of the time," 
				+ "\nI will call you "+user
				+".\nYou may call me Computer."
				+ "\nWe should become friends." );
	}
	
	public static void promptForever(){
		while(true){
			promptInput();
		}
	}
	
	public static void promptInput(){
		print("Please type something "+user+".");
		String userInput = input.nextLine();
		print("Congratulations!You typed: "+userInput);
	}
	
	public static void createFields(){
		input = new Scanner(System.in);
		user = "";
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


