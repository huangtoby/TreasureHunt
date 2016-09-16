package introduction;

public class Senior extends Student {
	
	String Score;
	
	public Senior(String name, String Score) {
		super(name);//constructs a student first
	}
	
	public void talk(){
		super.talk();
		System.out.println("...and I am a senior!");
	}

}
