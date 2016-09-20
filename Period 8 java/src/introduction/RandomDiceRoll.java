package introduction;

public class RandomDiceRoll {

	public static void main(String[] args) {
		int[] results = new int [6];//means to fill array with six zeroes
		
		
		//declare variable,logic test, increment
		for(int index = 0; index < 10;index++){
			int result = rollFairDie();
			System.out.println("roll #"+(index+1)+
					": "+ result);
			results[result-1] ++;
		}
		//print the results
		for(int i = 0; i < 6; i++){
			System.out.println((i+1)+" appeared " +
					results[i]+" times.");
		}
	}
	
	//return 1,2,3,4,5,6 with equal probability
	public static int rollFairDie(){
		double rand = Math.random();//returns a double between (0,1) 
		int roll = (int) (6*rand)+1;//[0,5]
		return roll;
	}
	
	public static int rollUnfairDie(){
		int rand = (int) Math.random();
		int roll = (int) (6*rand)+1; 
		return roll;
		
	}
	
}
