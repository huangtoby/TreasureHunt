package arrayMain;

public class  ArrayClasswork {

	public static void main(String[] args)
	{
		int[] fiftyNumbers = new int[50];
		int[] record = {2,3,4,5,6,7,8,9,10,11,12};
		//populate(fiftyNumbers);
		//print(fiftyNumbers);
		//randomize(fiftyNumbers);
		//print(fiftyNumbers);
		rollDice(fiftyNumbers);
		//record each die roll and provide a percentage
		countResult(fiftyNumbers);		
	}	

	private static void countResult(int[] s) {
		for(int i = 0; i<s.length;i++){
			s[i] = i+1; 
		}
	}

	private static void rollDice(int[] s) {
		
		for(int i = 0; i<s.length;i++){
			s[i] = (1 + (int)(6*Math.random()))
				+ (1 + (int)(6*Math.random()));
		}

	}

	private static void randomize(int[] s) {
		for(int i = 0; i<s.length;i++){
			s[i] =  1+(int)(50*Math.random()); 
		}
		
	}

	private static void print(int[] s) {
		for(int i = 0; i<s.length;i++){
			System.out.println(s[i]);
		}
		
	}

	private static void populate(int[] s) {
		for(int i = 0; i<s.length;i++){
			s[i] = i+1; 
		}
	}
}