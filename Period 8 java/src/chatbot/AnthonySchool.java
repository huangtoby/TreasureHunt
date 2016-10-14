package chatbot;

public class AnthonySchool extends Object implements Chatbot{

private boolean inSchoolLoop;
private String schoolResponse;

	@Override
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			AnthonyMain.print("(Type 'quit' to go back.)");
			//static call on promptInput method from 
			//AnthonyMain class
			schoolResponse = AnthonyMain.promptInput(); 
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				AnthonyMain.promptForever();
			}
			AnthonyMain.print("that's my favorite part "
					+ "about school");
		}	
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"school","class","teacher"};
		//idea: create a for loop to iterate
		//through your array of triggers
		
		if(AnthonyMain.findKeyword(userInput, "school", 0) 
				>= 0){
			return true;
		}
		if(AnthonyMain.findKeyword(userInput, "school", 0) 
				>= 0){
			return true;
		}
		return false;
	}

}
