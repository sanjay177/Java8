package playarea;

public class PrintWithoutMain {

	
	//Print SOP even if main methoud not found until JDK6 , In later version , main method is mandatory
	static {
		System.out.println("Hello World I do not have main ");
	}
}
