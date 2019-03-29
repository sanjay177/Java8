package com.pt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class MethodInterfaceEx {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Sanjay", 10000, "IT", 6.5,"Delhi",LocalDate.ofYearDay(2019, 20));
		Employee emp2 = new Employee("John", 15000, "IT", (double)8,"Pune",LocalDate.ofYearDay(2019, 10));
		Employee emp3 = new Employee("Sam", 60000, "Accounts", null,"Hyderabad",LocalDate.ofYearDay(2019, 40));
		Employee emp4 = new Employee("Kiara", 20000, "IT", 8.5,"Kerala",LocalDate.ofYearDay(2019, 50));
		Employee emp5 = new Employee("Dior", 5000, "Accounts", 2.1,"Sikkim",LocalDate.ofYearDay(2018, 20));
		Employee emp6 = new Employee("Raj", 5000, "Accounts", 4.1,null,LocalDate.ofYearDay(2018, 320));
		Employee emp7 = new Employee("Kiran", 15000, "IT", 3.1,null,LocalDate.ofYearDay(2017, 20));

		MethodInterfaceEx mi = new MethodInterfaceEx();
		System.out.println("------------------ Exc 1 - Sort By Name  ------------------");
		mi.sortByName(emp1,emp2,emp3,emp4,emp5,emp6,emp7);
		
		System.out.println("------------------ Exc 2 - Hire Date More than 1 Year  ------------------");
		mi.hireDateMoreThanYear(emp1,emp2,emp3,emp4,emp5,emp6,emp7);
	}
	
	private void hireDateMoreThanYear(Employee...employees) {
		java.util.List<Employee> listEmp = Arrays.asList(employees);
		listEmp.stream().filter(EmployeeCompHelper::isHireDateMorethanOneYear).forEach(System.out::println);
	}

	public void sortByName(Employee...employees) {
		java.util.List<Employee> listEmp = Arrays.asList(employees);
		Comparator<Employee> empComparator = EmployeeCompHelper::compareMethod;
		Collections.sort(listEmp,empComparator);
		listEmp.forEach(System.out::println);
	}

}

class EmployeeCompHelper{
	
	public static int compareMethod(Employee emp1 , Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	
	public static boolean isHireDateMorethanOneYear(Employee emp1) {
		return emp1.getHireDate().isBefore(LocalDate.now().minusYears(1));
	}
}
