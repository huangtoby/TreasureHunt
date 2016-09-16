package introduction;

public class Student {
	
	//fields
	private String name;
	
	//constructor (initialize fields)
	public Student(String name){
		this.name = name;
	}

public void talk(){
		System.out.println("Hello, My Name is " + name);
	}

}
