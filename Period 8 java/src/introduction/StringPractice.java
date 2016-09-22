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
		String printString = s;
		int cutoff = 1;
		if (printString.length()> cutoff){
			for(int i = 0; i * cutoff < s.length(); i++){
				printString += getCut(s,cutoff, i+1)+"\n";
			}
		}
		System.out.println(printString);
	}	
	
	private static String getCut(String s, 
			int cutoff, 
			int cut){
		int cutIndex = cut * cutoff;
		if(cutIndex > s.length())cutIndex = s.length();		
		String currentCut = s.substring(0,cutIndex);
		
		int indexOfLastSpace = currentCut.length()-1;
		//start at last index, go backwards
		for(int i = currentCut.length()-1; i>0; i--){
			String letter = currentCut.substring(i, i+1);
			if(letter.equals(" ")){
				indexOfLastSpace = i;
				break;
			}
		}
		currentCut = currentCut.substring(0,indexOfLastSpace);
		return currentCut;
	}
		

}
