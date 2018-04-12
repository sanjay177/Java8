package cloning;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FirstClone{

	public static void main(String[] args) {
		FirstClone fc = new FirstClone();
		CloneObject co = new CloneObject();
		try {
			System.out.println("Cloning 1st Object");
			CloneObject cloneObject1 = (CloneObject)co.clone();//Shallow Cloning
			fc.printClassObjectVariables(cloneObject1);
			cloneObject1.field1=5000;
			System.out.println("Cloning 2nd Object");
			CloneObject cloneObject2 = (CloneObject) cloneObject1.clone();
			fc.printClassObjectVariables(cloneObject2);//Method to print variable of Objects 
			
			//Copy Constructor
			CopyConstructorEx MainObj = new CopyConstructorEx(12, 11, "Copy", "Constructor");
			fc.printClassObjectVariables(MainObj);
			CopyConstructorEx copObj = new CopyConstructorEx(MainObj);
			fc.printClassObjectVariables(copObj);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
			
	}

	// Using Reflection printing object variables for this demo 
	public void printClassObjectVariables(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		Arrays.stream(fields).forEach((fieldObjectReflection)-> {
				try {
					System.out.println(fieldObjectReflection.getName()+" "+fieldObjectReflection.get(obj));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
		});
	}
	
}

class CloneObject implements Cloneable{//clone method is protected so need to be override in this class so that can be used outside of this class
	
	 int field1=20;
	 int field2=50;
	 String strField1="Hello";
	 String strField2="Clone";
			
	@Override
	public Object clone() throws CloneNotSupportedException {
		field1=2000;
		return super.clone();
	}

}


//Use Of Copy Cnstructor
class CopyConstructorEx {
	 int field1;
	 int field2;
	 String strField1;
	 String strField2;
	 
	 public CopyConstructorEx(int field1, int field2, String strField1 , String strField2) {
		 this.field1=field1;
		 this.field2=field2;
		 this.strField1=strField1;
		 this.strField2=strField2;
	 }
	 
	 public CopyConstructorEx(CopyConstructorEx cObj) {
		 this.field1=cObj.field1;
		 this.field2=cObj.field2;
		 this.strField1=cObj.strField1;
		 this.strField2=cObj.strField2;
	 }
	 
}
