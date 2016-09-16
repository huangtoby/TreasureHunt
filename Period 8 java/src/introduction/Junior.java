package introduction;

public class Junior extends Student {
	
	private String Classes;

	public Junior(String name, String color) {
		super(name);//constructs a student first
		Classes = color; 
	}
	
	public void talk(){
		super.talk();
		System.out.println(" and I'm close to being a Senior!");
	}

}
