package introduction;

public class Junior extends Student {
	
	

	public Junior(String name) {
		super(name);//constructs a student first
	}
	
	public void talk(){
		super.talk();
		System.out.println(" and I'm close to being a Senior!");
	}

}
