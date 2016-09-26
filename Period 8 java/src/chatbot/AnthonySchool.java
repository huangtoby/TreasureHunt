package chatbot;

public class AnthonySchool extends Object implements Chatbot{

private boolean inSchoolLoop;
private String schoolResponse;

	@Override
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			
			//static call on promptInput method from AnthonyMain class
			schoolResponse = AnthonyMain.promptInput(); 
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				AnthonyMain.promptForever();
			}
			AnthonyMain.print("that's my favorite part "
					+ "about school");
		}	
	}

}
