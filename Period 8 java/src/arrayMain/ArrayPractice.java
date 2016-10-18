package arrayMain;

public class ArrayPractice {
	
	static boolean[] boos3;

	public static void main(String[] args) {
		//how do you time a process?
		long currentTime = System.currentTimeMillis();
		
		
		int x = 10;
		increased(x);
		System.out.println(x);
		
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		print(someStrings);		
		
		initializingArrayExample();
		long endTime = System.currentTimeMillis();
		System.out.println("The process took "
				+(endTime-currentTime)+ "ms.");
	}
		
	private static void increased(int x) {
		x++;
		
	}

	private static void makeSpecial(String s) {
		s = "My mom says I'm special";
		
	}

	private static void print(String[] s){
		for(int i = 0; i < s.length;i++){
			System.out.println(s[i]);
		}
	}
	
	private static void standardPopulate(String[] s) {
		for(int i = 0; i < s.length; i++){
			String string = "String #"+(i+1);
			s[i] = string; 
		}
		
	}


	public static void initializingArrayExample(){
		
		//two different ways to instantiate an array
				boolean[] boos1 = new boolean[3];
				//this can only be done at the declaration
				//because it sets size and content
				boolean[] boos2 = {false, false, false};
				//this does NOT work:
				//boos3 = {false,false,false};
				//However only this will work:
				boos3 = new boolean[3];
				
				/**2 ways of iterating through an array:
				 	STANDARD FOR LOOP
				  			-the index is important to keep track of
				  			- you need to customize the order
				 */
				for(int i = 0; i < boos1.length; i ++){
					System.out.println(boos1[i]);
				}
				
				/**
				 * "FOR - EACH" LOOP
				 * 	-the index is not important
				 *	-doest not need customization
				 *	-automatically assigns "handle"
				 *	-faster
				 */
				for(boolean b: boos1){
					System.out.println(b);
				}
				
				//OBJECT ARRAYS
				String[] someStrings2 = {"a","b","c"};
				String[] someStrings1 = new String[3];
				//you can do this to instatiate the elements...
				someStrings1[0] = "a";
				someStrings1[0] = "b";
				someStrings1[0] = "c";
				//..but it is repetitive
				
				//let's try a loop:
				for(int i= 0; i < someStrings1.length; i++){
					someStrings1[i] = "A New String";
				}
				//a loop to print it
				for(String s: someStrings1){
					System.out.println(s);
				}
	}
}


