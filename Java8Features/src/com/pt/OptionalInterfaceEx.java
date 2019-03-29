package com.pt;

import java.util.Optional;
import java.util.stream.Stream;
	
public class OptionalInterfaceEx {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Sanjay", 10000, "IT", 6.5,"Delhi");
		Employee emp2 = new Employee("John", 15000, "IT", (double)8,"Pune");
		Employee emp3 = new Employee("Sam", 60000, "Accounts", null,"Hyderabad");
		Employee emp4 = new Employee("Kiara", 20000, "IT", 8.5,"Kerala");
		Employee emp5 = new Employee("Dior", 5000, "Accounts", 2.1,"Sikkim");
		Employee emp6 = new Employee("Raj", 5000, "Accounts", 4.1,null);
		Employee emp7 = new Employee("Kiran", 15000, "IT", 3.1,null);
		
		OptionalInterfaceEx oi = new OptionalInterfaceEx();	
		System.out.println("------------------ Exc 1 - Null Exp ------------------");
		oi.getEmployeeFromAccountWithNullExp(emp1,emp2,emp3,emp4,emp5,emp6,emp7);
		
		System.out.println("------------------ Exc 2 - Not Null Address ------------------");
		oi.getEmployeeFromWithNotNullAddress(emp1,emp2,emp3,emp4,emp5,emp6,emp7);
		
	}
	
	
	public void getEmployeeFromAccountWithNullExp(Employee...employees) {
		Stream.of(employees).filter(emp->emp.department.equals("Accounts") && !Optional.ofNullable(emp.experience).isPresent()).forEach(System.out::println);;
	}
	
	public void getEmployeeFromWithNotNullAddress(Employee...employees) {
		Stream.of(employees).filter(emp->Optional.ofNullable(emp.address).isPresent()).forEach(System.out::println);;
	}
	

}
