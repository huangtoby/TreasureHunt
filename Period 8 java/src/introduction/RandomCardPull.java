package introduction;

public class RandomCardPull {

	public static void main(String[] args) {

		
		
		//declare variable,logic test, increment
		for(int index = 0; index < 1;index++){;
			System.out.println("Ypu have pulled the "+ Pullcard() + "th card of "+ Pullsuit());

		}

	}
	
	//return 1,2,3,4,5,6 with equal probability
	public static int Pullcard(){
		double rand = Math.random(); 
		int num = (int) (13*rand)+1;
		return num;
	}
	
	public static String Pullsuit(){
		double rand = Math.random(); 
		int suit = (int) (4*rand)+1;
		if(suit == 1) 
			return "Hearts";
		if(suit == 2) 
			return "Diamonds";
		if(suit == 3) 
			return "Spades";
		if(suit == 4) 
			return "Clubs";
		return null;
		
		
	}

}