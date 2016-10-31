package introduction;

import java.util.Scanner;

public class Quiz1 {
	
static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	//1 point for private visibility
	//1 point for data type declaration (throughout)
	private static String username = "test_user";
	private static String password = "test";
	
	//1 point for correct method
	public static void main(String[] args){
		//one point, asking username once
		if(correctUser()){
			askPassword();
		}else{
			System.out.println("Unknown username, "+ 
			"please contact the network " + "administrator");
		}			
	}
	
	private static void askPassword(){
		boolean inLoop = true;
		int triesRemaining = 3;
		while(inLoop){
			System.out.println("Enteryour password");
			//1 point use of waitForEntry() correctly
			String entry = waitForEntry();
			if(entry.equals(password)){
				System.out.println("You're in!");
				inLoop = false;
			}else{
				//.5 triesRemaining is changing
				triesRemaining--;
				if(triesRemaining == 0){
					//.5 printing invalid password
					System.out.println("invalid password");
					//.5 point Max 3 tries
					inLoop = false;
				}else{
					//.5 for printing the correct number
					System.out.println("You have " + triesRemaining + " attempt(s) left.");
				}
			}
		}
	}
	
	private static boolean correctUser() {
		System.out.println("Enter a username");
		//1 point, comparing Strings
		
		//if(waitForEntry().equals(username)){
		//	return true;
		//}
		//return false;
		
		//or
		
		return waitForEntry().equals(username);
	}

}
