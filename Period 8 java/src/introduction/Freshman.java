package introduction;

public class Freshman extends Student {
	
	String Color;

	public Freshman(String name) {
		super(name);//constructs a student first
	}
	
	public void talk(){
		super.talk();
		System.out.println("and i just started!");
	}
	
}
