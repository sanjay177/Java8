package features;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
	
		
		//No parameters Lambda Expression
		MyFunctionalInterface mfi = () -> { return "First Lambda"; };
		System.out.println("This is My "+mfi.computeExpression());
		
		//Parameterized Lambda expression
		ParameterizeFunctionalInterface pfi = (lmd) -> (lmd+20);
		System.out.println("Interger Number is  "+pfi.computeExpression(5));
		
		//Generic Lambda expression
		GenericFunctionalInterface<Integer> gfi = (lmd1) -> { return lmd1; };
		System.out.println("First Generic  "+gfi.computeExpression(5));
		
		GenericFunctionalInterface<Boolean> gfi1 = (lmd2) -> (lmd2==10);
		System.out.println("Second Generic  "+gfi1.computeExpression(10));
		
		//Mathematical Functions 
		MathematicalFunctionalInterface mafi1 = (a,b) -> (a+b);
		System.out.println("Addition  "+mafi1.computeExpression(10,20));
		
		MathematicalFunctionalInterface mafi2 = (a,b) -> (a-b);
		System.out.println("Subtraction  "+mafi2.computeExpression(30,10));
		
		MathematicalFunctionalInterface mafi3 = (a,b) -> (a*b);
		System.out.println("Multiplication "+mafi3.computeExpression(10,10));
		
		//Along with ForEach
		
		List<String> list=new ArrayList<String>();  
        list.add("A");  
        list.add("B");  
        list.add("C");  
        list.add("D");  
		
        list.forEach((str) -> { 
        	if(str.equals("D")) System.out.println("D1") ;
        	else 
        		System.out.println(str) ; });
		
	}

	
	/**
	 * Functional Interface - having only 1 method
	 * Lambda Used with Functional Interface
	 * To provide the implementation of Functional interface.
	 * 
	 */
	
	interface MyFunctionalInterface{
		
		String computeExpression();
	}
	
	
	interface ParameterizeFunctionalInterface{
		
		int computeExpression(int i);
	}
	
	interface GenericFunctionalInterface<T>{
		
		T computeExpression(int t);
	}
	
	interface MathematicalFunctionalInterface<T>{
		
		int computeExpression(int a,int b);
	}
	
}
