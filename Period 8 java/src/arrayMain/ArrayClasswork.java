package arrayMain;

public class  ArrayClasswork {

	public static void main(String[] args)
	{
		
		
		    String[] letters = {"A","C","B"};
		    String[] numbers = {"1 ","2 ","3 "};
		    for(String n : numbers){
		        for(int i=letters.length-1; i>=0; i--){
		            System.out.print(letters[i]+n);
		        }
		    }
			
	}	

	private static void listPrimes(int limit){
		int lastToCheck = (int)(Math.sqrt(limit));
		boolean[] numbers = new boolean[limit+1];
		for(int i = 0; i < limit+1; i++){
			numbers[i] = true;
		}
		
		//o and 1 are by definition not prime
		numbers[0]=false;
		numbers[1]=false;
		
		//check all non crossed out numbers (starting with 2)
		for(int prime = 2; prime <= lastToCheck; prime++){
			
			if(numbers[prime]){
				
				System.out.println("\n"+prime+" is prime."
						+ " Crossing off:");
				
				for(int i = (int)(Math.pow(prime,2));
						i < limit+1; i += prime){
					
					System.out.println(i + ", ");
					numbers[i] = false;
				}
			}
		}
		//print the primes
		System.out.println("\nThe primes are:");
		for(int index = 0; index < numbers.length; index++){
			if(numbers[index])System.out.print(index+", ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void countResult(int[] intArray) {
		//int[] record = new int[11];
		//for(int i = 0; i<s.length;i++){
		//	 record[(s[i]-1)] += 1;
		//}
		//for(int i = 0; i< record.length;i++){
		//	System.out.println((i+2) + " occurred " + (record[i]/100) + " percent of the time");
		//}
		int[] counter = new int[12];
		for(int n: intArray){
			counter[n-1] = counter[n-1] + 1;
		}
		for(int i = 0; i < counter.length; i++)
			System.out.println((i+1) + " was rolled "
					+ 100*counter[i]/intArray.length + " percent of the time");
	}

	private static void rollDice(int[] s, int n) {	
		for(int i = 0; i<s.length;i++){
			//s += s + (1 + ((6*n)*Math.random());
		}

	}

	private static void randomize(int[] s,int max) {
		for(int i = 0; i<s.length;i++){
			s[i] =  1+(int)(max*Math.random()); 
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