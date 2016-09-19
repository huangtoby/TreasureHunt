package introduction;

public class OOPExample {

	public static void main(String[] args) {
		Student jillian = new Senior("Jillian");
		Student joseph = new Junior("Joseph");
		Student jordan = new Freshman("Jordan");
		Student jack = new Student("Jack");
		
		
		((Student)jillian).talk();
		joseph.talk();
		jordan.talk();
		jack.talk();
	}

}
