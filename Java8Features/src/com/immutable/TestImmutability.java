package com.immutable;

import java.util.Date;

public class TestImmutability{
	public static void main(String args[])
	{
		MyImmutable immut = new MyImmutable(1, "Immutable Object", new Date());
		System.out.println("Integer Field "+immut.getField1());
		System.out.println("String Field "+immut.getField2());
		System.out.println("Date Field "+immut.getDatefield3());
		
		immut.getDatefield3().setTime(new Date(2007, 2, 21).getTime());//Changing Time on Date object from immutable class
		
		System.out.println("After Changing date fieled ");
		System.out.println("Integer Field "+immut.getField1());
		System.out.println("Integer Field "+immut.getField2());
		System.out.println("Integer Field "+immut.getDatefield3());
		
		System.out.println("Values Did not changed");
	}
}

final class MyImmutable { //It wont be extended// No method will be overriden

	private final Integer field1;
	private final String field2;
	private final Date datefield3;

	public MyImmutable(Integer val1, String val2, Date date) {
		this.field1=val1;
		this.field2=val2;
		this.datefield3=new Date(date.getTime());
		//Always creating new instance while assigning mutable object
		
		//this.datefield3=date;//not the correct approach 
	}

	public Integer getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}
	
	//No Setter method for instance variable
	
	public Date getDatefield3() {
		return new Date(this.datefield3.getTime());
	}
}

