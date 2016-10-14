package chatbot;

public class AnthonyHello implements Chatbot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	
	private String[] calmResponse =
		{"We already said Hello. " +
			"Let's move the conversation along.",
			"You  already said hello. Did you Forget?"};
	private String[] angryResponses = 
		{"Okay seriously. Stop saying hi.",
				"What is wrong with you and saying hello?"};
		
	private int helloCount;
	
	private AnthonyHello(){
		helloCount = 0;
	}
	
	
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse();//helper method
			helloResponse = AnthonyMain.promptInput();
			//negate use
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				AnthonyMain.promptForever();
			}
		}
	}

	private void printResponse() {
		if(helloCount > 4){
			int responseSelection = 
					(int)(Math.random()*
							angryResponses.length);
			AnthonyMain.print(
					angryResponses[responseSelection]);
		}else{
				int responseSelection = 
						(int)(Math.random()*
								calmResponse.length);
				AnthonyMain.print(
						calmResponse[responseSelection]);
		}
		
	}

	public boolean isTriggered(String userInput) {
		if(AnthonyMain.findKeyword(userInput, "hello", 0)
				>= 0){
			return true;
		}
		if(AnthonyMain.findKeyword(userInput, "hi", 0)
				>= 0){
			return true;
		}
		if(AnthonyMain.findKeyword(userInput, "hey", 0)
				>= 0){
			return true;
		}
		return false;
	}

}
